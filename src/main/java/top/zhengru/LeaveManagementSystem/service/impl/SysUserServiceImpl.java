package top.zhengru.LeaveManagementSystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.zhengru.LeaveManagementSystem.base.ResponseResult;
import top.zhengru.LeaveManagementSystem.entity.SysClass;
import top.zhengru.LeaveManagementSystem.entity.SysUnit;
import top.zhengru.LeaveManagementSystem.entity.SysUser;
import top.zhengru.LeaveManagementSystem.mapper.SysUserMapper;
import top.zhengru.LeaveManagementSystem.param.LoginUserParam;
import top.zhengru.LeaveManagementSystem.param.ModifyPwdParam;
import top.zhengru.LeaveManagementSystem.service.SysUnitService;
import top.zhengru.LeaveManagementSystem.service.SysUserService;
import top.zhengru.LeaveManagementSystem.utils.JwtUtils;
import top.zhengru.LeaveManagementSystem.vo.RoleInfoVO;
import top.zhengru.LeaveManagementSystem.vo.UserInfoVO;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
* @description 针对表【sys_user】的数据库操作Service实现
* @createDate 2023-08-01 14:20:18
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
    implements SysUserService{
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    SysUserMapper sysUserMapper;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    ObjectMapper objectMapper;

    /**
     * 根据用户ID查询权限
     * @param userId
     * @return
     */
    @Override
    public List<RoleInfoVO> queryPermByUserId(Integer userId) {
        return sysUserMapper.queryPermByUserId(userId);
    }

    /**
     * 用户登录
     * @param userInfo
     * @return
     * @throws JsonProcessingException
     */
    @Override
    public ResponseResult<Map<String, String>> login(LoginUserParam userInfo) throws JsonProcessingException {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userInfo.getUsername(), userInfo.getPassword());
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        //判断登录结果
        if (Objects.isNull(authenticate)) {
             return new ResponseResult<>(500,"登录失败");
        }

        //为了安全性的考虑，密码设置为空
        UserDetailImpl user = (UserDetailImpl) authenticate.getPrincipal();
        user.setPassword(null);

        //载荷 map,Jwt的载荷,传入做生成
        Map<String, Object> claims = new HashMap<String, Object>();
        //根据业务需要加入
        claims.put("userInfo", user);

        //获取token
        JwtUtils jwtUtils = new JwtUtils();
        String token = jwtUtils.generateJwtToken(claims);

        Map<String,String> resMap= new HashMap<>(2);
        resMap.put("token",token);

        //token存入redis并设置过期时间
        stringRedisTemplate.opsForValue()
                .set("logintoken:" + token, objectMapper.writeValueAsString(authenticate), 12, TimeUnit.HOURS);

        return new ResponseResult<>(200,"登录成功", resMap);
    }

    /**
     * 查询用户详情
     * @return
     */
    @Override
    public ResponseResult<UserInfoVO> getUserInfo() {
        UserDetailImpl userDetail = (UserDetailImpl) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        UserInfoVO userInfoVO = new UserInfoVO();
        userInfoVO.setUsername(userDetail.getUsername());
        userInfoVO.setRealName(userDetail.getRealName());
        userInfoVO.setUnitName(userDetail.getUnitName());
        userInfoVO.setMajor(userDetail.getMajor());
        userInfoVO.setClassNo(userDetail.getClassNo());
        userInfoVO.setIsTeacher(userDetail.getIsTeacher());
        userInfoVO.setRole(userDetail.getRoles());
        return new ResponseResult<>(200, userInfoVO);
    }

    /**
     * 根据用户id重置密码
     * @param id
     * @return
     */
    @Override
    @Transactional
    public ResponseResult<Map<String, String>> resetPwd(Integer id) {
        SysUser sysUser = sysUserMapper.getUserInfoById(id);
        if (sysUser != null) {
            String pwd = bCryptPasswordEncoder.encode(sysUser.getUsername());
            sysUserMapper.resetPwd(id, pwd);
        }
        return new ResponseResult<>(200, "用户："  + sysUser.getRealName() + " 密码重置成功");
    }

    /**
     * 修改密码
     * @param modifyPwdParam
     * @return
     */
    @Override
    @Transactional
    public ResponseResult<Map<String, String>> modifyPwd(ModifyPwdParam modifyPwdParam) {
        UserDetailImpl userDetail = (UserDetailImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetail.getUsername();
        if (Objects.equals(modifyPwdParam.getOldPwd(), modifyPwdParam.getNewPwd())) {
            return new ResponseResult<>(500, "请不要修改相同的密码");
        }
        String pwd = sysUserMapper.getUserPwdByUsername(username);
        if (bCryptPasswordEncoder.matches(modifyPwdParam.getOldPwd(), pwd)) {
            sysUserMapper.modifyPwd(username, bCryptPasswordEncoder.encode(modifyPwdParam.getNewPwd()));
            return new ResponseResult<>(200, "修改成功");
        }
        return new ResponseResult<>(500, "修改失败");
    }

    /**
     * 获取教师列表
     * @param keyword
     * @return
     */
    @Override
    public ResponseResult<List<UserInfoVO>> getTeacherList(String keyword) {
        List<UserInfoVO> teacherList = sysUserMapper.getTeacherList(keyword);
        for (UserInfoVO teacherInfo : teacherList) {
            teacherInfo.setRole(sysUserMapper.getRole(teacherInfo.getUsername()));
        }
        return new ResponseResult<>(200, teacherList);
    }
}




