package top.zhengru.LeaveManagementSystem.service;

import top.zhengru.LeaveManagementSystem.base.ResponseResult;
import top.zhengru.LeaveManagementSystem.entity.ApprovalProcess;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
* @author 董政儒
* @description 针对表【approval_process】的数据库操作Service
* @createDate 2023-12-14 20:10:11
*/
public interface ApprovalProcessService extends IService<ApprovalProcess> {

    /**
     * 同意审批
     * @param leaveId
     * @param reason
     * @return
     */
    ResponseResult<Map<String, String>> agreeApproval(Integer leaveId, String reason);
}
