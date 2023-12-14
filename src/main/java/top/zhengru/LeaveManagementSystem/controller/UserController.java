package top.zhengru.LeaveManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.zhengru.LeaveManagementSystem.base.ResponseResult;
import top.zhengru.LeaveManagementSystem.param.SysUserParam;
import top.zhengru.LeaveManagementSystem.service.SysUserService;
import top.zhengru.LeaveManagementSystem.vo.UserInfoVO;

import java.util.List;

/**
 * @Author: dongzhengru
 * @Blog: blog.zhengru.top
 * @Date: 2023/9/20
 * @Time: 21:31
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    SysUserService sysUserService;

    /**
     * 查询用户详情
     * @return
     */
    @GetMapping("/getUserInfo")
    public ResponseResult<UserInfoVO> getUserInfo(){
        return sysUserService.getUserInfo();
    }

    /**
     * 获取教师列表
     * @return
     */
    @GetMapping("/getTeacherList")
    public ResponseResult<List<UserInfoVO>> getTeacherList(String keyword){
        return sysUserService.getTeacherList(keyword);
    }
}
