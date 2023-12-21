package top.zhengru.LeaveManagementSystem.service;

import top.zhengru.LeaveManagementSystem.base.ResponseResult;
import top.zhengru.LeaveManagementSystem.entity.ApprovalProcess;
import com.baomidou.mybatisplus.extension.service.IService;
import top.zhengru.LeaveManagementSystem.vo.StatisticVO;

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

    /**
     * 驳回审批
     * @param leaveId
     * @param reason
     * @return
     */
    ResponseResult<Map<String, String>> rejectApproval(Integer leaveId, String reason);

    /**
     * 统计待审批数量
     * @return
     */
    ResponseResult<Map<String, Integer>> countUnFinished();

    /**
     * 查询审批数据统计
     * @return
     */
    ResponseResult<StatisticVO> statistic();
}
