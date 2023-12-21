package top.zhengru.LeaveManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.zhengru.LeaveManagementSystem.base.ResponseResult;
import top.zhengru.LeaveManagementSystem.service.ApprovalProcessService;
import top.zhengru.LeaveManagementSystem.vo.StatisticVO;

import java.util.Map;

/**
 * @Author: dongzhengru
 * @Blog: blog.zhengru.top
 * @Date: 2023/12/20
 * @Time: 19:34
 */
@RestController
@RequestMapping("/approval")
public class ApprovalController {
    @Autowired
    ApprovalProcessService approvalProcessService;

    /**
     * 同意审批
     * @param id
     * @param reason
     * @return
     */
    @PostMapping("/agree")
    public ResponseResult<Map<String, String>> agreeApproval(@RequestParam Integer id, @RequestParam String reason) {
        return approvalProcessService.agreeApproval(id, reason);
    }

    /**
     * 驳回审批
     * @param id
     * @param reason
     * @return
     */
    @PostMapping("/reject")
    public ResponseResult<Map<String, String>> rejectApproval(@RequestParam Integer id, @RequestParam String reason) {
        return approvalProcessService.rejectApproval(id, reason);
    }

    /**
     * 统计待审批数量
     * @return
     */
    @GetMapping("/unFinished")
    public ResponseResult<Map<String, Integer>> countUnFinished() {
        return approvalProcessService.countUnFinished();
    }

    /**
     * 查询审批数据统计
     * @return
     */
    @GetMapping("/statistic")
    public ResponseResult<StatisticVO> statistic() {
        return approvalProcessService.statistic();
    }
}
