package top.zhengru.LeaveManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import top.zhengru.LeaveManagementSystem.base.PageResult;
import top.zhengru.LeaveManagementSystem.base.ResponseResult;
import top.zhengru.LeaveManagementSystem.entity.SysMenu;
import top.zhengru.LeaveManagementSystem.entity.SysUnit;
import top.zhengru.LeaveManagementSystem.param.ModifyPwdParam;
import top.zhengru.LeaveManagementSystem.param.SysUserParam;
import top.zhengru.LeaveManagementSystem.service.*;
import top.zhengru.LeaveManagementSystem.vo.ClassInfoVO;
import top.zhengru.LeaveManagementSystem.vo.UnitInfoVO;

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
    @Autowired
    SysUnitService sysUnitService;
    @Autowired
    SysClassService sysClassService;

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

    /**
     * 查询所有用户
     * @param sysUserParam
     * @return
     */
    @GetMapping("/getAllUser")
    public ResponseResult<PageResult> getAllUser(SysUserParam sysUserParam) {
        return sysUserService.getAllUser(sysUserParam);
    }

    /**
     * 查询所有二级学院
     * @return
     */
    @GetMapping("/getAllUnit")
    public ResponseResult<List<UnitInfoVO>> getAllUnit() {
        return sysUnitService.getAllUnit();
    }

    /**
     * 查询所有班级
     * @return
     */
    @GetMapping("/getAllClass")
    public ResponseResult<List<ClassInfoVO>> getAllClass() {
        return sysClassService.getAllClass();
    }
}
