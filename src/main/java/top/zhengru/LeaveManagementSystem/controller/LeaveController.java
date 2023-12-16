package top.zhengru.LeaveManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.zhengru.LeaveManagementSystem.base.PageResult;
import top.zhengru.LeaveManagementSystem.base.ResponseResult;
import top.zhengru.LeaveManagementSystem.param.NewLeaveParam;
import top.zhengru.LeaveManagementSystem.param.QueryLeaveParam;
import top.zhengru.LeaveManagementSystem.service.LeaveInfoService;
import top.zhengru.LeaveManagementSystem.vo.LeaveInfoVO;

import java.util.Map;

/**
 * @Author: dongzhengru
 * @Blog: blog.zhengru.top
 * @Date: 2023/12/14
 * @Time: 10:33
 */
@RestController
@RequestMapping("/leave")
public class LeaveController {
    @Autowired
    LeaveInfoService leaveInfoService;

    /**
     * 生成审批编号
     * @return
     */
    @GetMapping("/getLeaveNo")
    public ResponseResult<Map<String, String>> getLeaveNo() {
        return leaveInfoService.getLeaveNo();
    }

    /**
     * 学生发起请假
     * @param newLeaveParam
     * @return
     */
    @PostMapping("/newLeave")
    public ResponseResult<String> newLeave(NewLeaveParam newLeaveParam) {
        return leaveInfoService.newLeave(newLeaveParam);
    }

    /**
     * 查询请假单
     * @param queryLeaveParam
     * @return
     */
    @PostMapping("/queryLeave")
    public ResponseResult<PageResult> queryLeave(QueryLeaveParam queryLeaveParam) {
        return leaveInfoService.queryLeave(queryLeaveParam);
    }

}
