package top.zhengru.LeaveManagementSystem.mapper;

import top.zhengru.LeaveManagementSystem.entity.SysUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @description 针对表【sys_user_role】的数据库操作Mapper
* @createDate 2023-08-01 14:20:18
*/
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

    /**
     * 根据用户名查询角色
     * @param username
     * @return
     */
    List<String> queryRoleByUsername(String username);
}




