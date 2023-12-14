package top.zhengru.LeaveManagementSystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import top.zhengru.LeaveManagementSystem.entity.SysUserRole;
import top.zhengru.LeaveManagementSystem.service.SysUserRoleService;
import top.zhengru.LeaveManagementSystem.mapper.SysUserRoleMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description 针对表【sys_user_role】的数据库操作Service实现
* @createDate 2023-08-01 14:20:18
*/
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole>
    implements SysUserRoleService{

    @Autowired
    SysUserRoleMapper sysUserRoleMapper;

    /**
     * 根据用户名查询角色
     * @param username
     * @return
     */
    @Override
    public List<String> queryRoleByUsername(String username) {
        return sysUserRoleMapper.queryRoleByUsername(username);
    }
}




