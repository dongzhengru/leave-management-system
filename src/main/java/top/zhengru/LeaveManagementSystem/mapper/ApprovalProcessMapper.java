package top.zhengru.LeaveManagementSystem.mapper;

import org.apache.ibatis.annotations.Param;
import top.zhengru.LeaveManagementSystem.entity.ApprovalProcess;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.zhengru.LeaveManagementSystem.service.impl.UserDetailImpl;
import top.zhengru.LeaveManagementSystem.vo.ApprovalProcessVO;
import top.zhengru.LeaveManagementSystem.vo.ccPersonVO;

import java.util.List;

/**
* @author 董政儒
* @description 针对表【approval_process】的数据库操作Mapper
* @createDate 2023-12-14 20:10:11
* @Entity top.zhengru.LeaveManagementSystem.entity.ApprovalProcess
*/
public interface ApprovalProcessMapper extends BaseMapper<ApprovalProcess> {

    /**
     * 查询审批流程详情
     * @param id
     * @return
     */
    List<ApprovalProcessVO> queryApprovalProcess(Integer id);

    /**
     * 查询抄送详情
     * @param id
     * @return
     */
    List<ccPersonVO> queryCcPersons(Integer id);

    /**
     * 抄送人设置已读
     * @param approvalProcess
     * @return
     */
    Integer readLeaveDetail(ApprovalProcess approvalProcess);

    /**
     * 统计待审批数量
     * @param username
     * @return
     */
    Integer countUnFinished(String username);

    /**
     * 查询教师平均审批耗时
     * @param username
     * @return
     */
    Double teachAvgTime(String username);
}




