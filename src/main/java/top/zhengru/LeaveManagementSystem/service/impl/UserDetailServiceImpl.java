package top.zhengru.LeaveManagementSystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import top.zhengru.LeaveManagementSystem.entity.SysClass;
import top.zhengru.LeaveManagementSystem.entity.SysUnit;
import top.zhengru.LeaveManagementSystem.entity.SysUser;
import top.zhengru.LeaveManagementSystem.service.SysClassService;
import top.zhengru.LeaveManagementSystem.service.SysUnitService;
import top.zhengru.LeaveManagementSystem.service.SysUserRoleService;
import top.zhengru.LeaveManagementSystem.service.SysUserService;
import top.zhengru.LeaveManagementSystem.vo.PermInfoVO;
import top.zhengru.LeaveManagementSystem.vo.RoleInfoVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 用于security获取用户信息
 */
@Component
@Slf4j
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    SysUserService sysUserService;
    @Autowired
    SysUnitService sysUnitService;
    @Autowired
    SysClassService sysClassService;
    @Autowired
    SysUserRoleService sysUserRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*获取账户名和密码*/
        QueryWrapper<SysUser> userWrapper = new QueryWrapper<>();
        userWrapper.eq("username",username);
        SysUser sysUser = sysUserService.getOne(userWrapper);
        if (Objects.isNull(sysUser)){
            log.info("有人尝试登录失败");
            throw new UsernameNotFoundException("账户或者密码错误");
        }
        Integer userId = sysUser.getId();
        /*获取账户的权限信息*/
        List<GrantedAuthorityImpl> grantedAuthorities = new ArrayList<>();
        List<RoleInfoVO> permissionList = sysUserService.queryPermByUserId(userId);
        SysUnit sysUnit = new SysUnit();
        SysClass sysClass = new SysClass();
        // 如果不是系统管理员继续查询分院和班级信息
        if (!Objects.equals(sysUser.getUsername(), "admin")) {
            sysUnit = sysUnitService.queryUnitByUserId(userId);
            // 如果不是教师继续查询班级信息
            if (sysUser.getIsTeacher() == 0) {
                sysClass = sysClassService.queryClassByUserId(userId);
            }
        }
        for (RoleInfoVO roleInfoVo : permissionList) {
            for (PermInfoVO permInfoVo : roleInfoVo.getPermInfoVOList()) {
                grantedAuthorities.add(new GrantedAuthorityImpl(permInfoVo.getPermission()));
            }
        }
        log.info(username+"正在获取信息！权限信息为："+grantedAuthorities);

        /*获取用户的角色信息*/
        List<String> roleList = sysUserRoleService.queryRoleByUsername(username);

        return new UserDetailImpl(sysUser, sysUnit.getUnitname(), sysClass.getMajor(), roleList, grantedAuthorities);
    }
}
