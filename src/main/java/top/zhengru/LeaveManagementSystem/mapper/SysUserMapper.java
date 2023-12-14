package top.zhengru.LeaveManagementSystem.mapper;

import org.apache.ibatis.annotations.Param;
import top.zhengru.LeaveManagementSystem.entity.SysUnit;
import top.zhengru.LeaveManagementSystem.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.zhengru.LeaveManagementSystem.vo.RoleInfoVO;
import top.zhengru.LeaveManagementSystem.vo.UserInfoVO;

import java.util.List;


public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 根据用户ID查询权限
     * @param userId
     * @return
     */
    List<RoleInfoVO> queryPermByUserId(Integer userId);

    /**
     * 根据用户名查询用户详情
     * @param username
     * @return
     */
    UserInfoVO getUserInfo(String username);

    /**
     * 根据用户ID查询用户详情
     * @param id
     * @return
     */
    SysUser getUserInfoById(Integer id);

    /**
     * 根据用户名查询用户角色
     * @param username
     * @return
     */
    List<String> getRole(String username);

    /**
     * 重置密码
     * @param pwd
     */
    void resetPwd(@Param("id") Integer id, @Param("pwd") String pwd);

    /**
     * 根据用户名查询加密密码
     * @param username
     * @return
     */
    String getUserPwdByUsername(String username);

    /**
     * 根据用户名修改密码
     * @param username
     * @param newPwd
     */
    void modifyPwd(@Param("username") String username, @Param("newPwd") String newPwd);

    /**
     * 获取教师列表
     * @param keyword
     * @return
     */
    List<UserInfoVO> getTeacherList(String keyword);
}




