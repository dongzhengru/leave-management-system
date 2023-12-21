package top.zhengru.LeaveManagementSystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import top.zhengru.LeaveManagementSystem.base.ResponseResult;
import top.zhengru.LeaveManagementSystem.entity.ApprovalProcess;
import top.zhengru.LeaveManagementSystem.entity.LeaveInfo;
import top.zhengru.LeaveManagementSystem.mapper.LeaveInfoMapper;
import top.zhengru.LeaveManagementSystem.service.ApprovalProcessService;
import top.zhengru.LeaveManagementSystem.mapper.ApprovalProcessMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

/**
* @author 董政儒
* @description 针对表【approval_process】的数据库操作Service实现
* @createDate 2023-12-14 20:10:11
*/
@Service
public class ApprovalProcessServiceImpl extends ServiceImpl<ApprovalProcessMapper, ApprovalProcess>
    implements ApprovalProcessService{

    @Autowired
    ApprovalProcessMapper approvalProcessMapper;
    @Autowired
    LeaveInfoMapper leaveInfoMapper;

    /**
     * 同意审批
     * @param leaveId
     * @param reason
     * @return
     */
    @Override
    @Transactional
    public ResponseResult<Map<String, String>> agreeApproval(Integer leaveId, String reason) {
        UserDetailImpl userDetail = (UserDetailImpl) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        LeaveInfo leaveInfo = leaveInfoMapper.selectById(leaveId);
        if (leaveInfo.getStatus() != 0) {
            return new ResponseResult<>(500, "审批失败，此请假单审批流程已结束！");
        }
        QueryWrapper<ApprovalProcess> approvalProcessQueryWrapper = new QueryWrapper<>();
        approvalProcessQueryWrapper.eq("leave_id", leaveId);
        approvalProcessQueryWrapper.eq("approver_no", userDetail.getUsername());
        approvalProcessQueryWrapper.eq("action", 1);
        ApprovalProcess approvalInfo = approvalProcessMapper.selectOne(approvalProcessQueryWrapper);
        if (approvalInfo == null) {
            return new ResponseResult<>(500, "审批失败，无审批权限！");
        }
        if (!Objects.equals(leaveInfo.getNowOrder(), approvalInfo.getApproveOrder())) {
            return new ResponseResult<>(500, "审批失败，您不是当前审批节点！");
        }
        if (approvalInfo.getStatus() == -1) {
            return new ResponseResult<>(500, "审批失败，您已驳回该审批！");
        }
        // 设置审批意见和审批状态
        approvalInfo.setReason(reason);
        approvalInfo.setStatus(2);
        approvalProcessMapper.updateById(approvalInfo);
        leaveInfo.setNowOrder(leaveInfo.getNowOrder() + 1);
        leaveInfo.setCompleteTime(new Date());
        leaveInfoMapper.updateById(leaveInfo);
        // 如果该审批人是最后节点，更新请假单为审批通过
        if (approvalInfo.getIsLast() == 1) {
            leaveInfo.setStatus(1);
            leaveInfo.setCompleteTime(new Date());
            leaveInfoMapper.updateById(leaveInfo);
        }
        return new ResponseResult<>(200, "审批通过成功！");
    }
}




