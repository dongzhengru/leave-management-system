package top.zhengru.LeaveManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import top.zhengru.LeaveManagementSystem.base.ResponseResult;
import top.zhengru.LeaveManagementSystem.entity.SysMenu;
import top.zhengru.LeaveManagementSystem.param.ModifyPwdParam;
import top.zhengru.LeaveManagementSystem.service.SysMenuService;
import top.zhengru.LeaveManagementSystem.service.SysPermissionService;
import top.zhengru.LeaveManagementSystem.service.SysUserService;

import java.util.List;
import java.util.Map;

/**
 * @Author: dongzhengru
 * @Blog: blog.zhengru.top
 * @Date: 2023/9/21
 * @Time: 20:21
 */
@RestController
@RequestMapping("/system")
public class SystemController {
    @Autowired
    SysMenuService sysMenuService;
    @Autowired
    SysUserService sysUserService;
    @Autowired
    SysPermissionService sysPermissionService;
    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 查询主页菜单
     * @return
     */
    @GetMapping("/menu")
    public ResponseResult<List<SysMenu>> getMenuByUserId(){
        return sysMenuService.getMenuByUserId();
    }

    /**
     * 根据id重置密码
     * @return
     */
    @GetMapping("/resetPwd")
    @PreAuthorize("hasAuthority('admin')")
    public ResponseResult<Map<String, String>> resetPwd(Integer id){
        return sysUserService.resetPwd(id);
    }

    /**
     * 修改密码
     * @param modifyPwdParam
     * @return
     */
    @PostMapping("/modifyPwd")
    public ResponseResult<Map<String, String>> modifyPwd(@RequestBody ModifyPwdParam modifyPwdParam){
        return sysUserService.modifyPwd(modifyPwdParam);
    }
}