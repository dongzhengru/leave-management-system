package top.zhengru.LeaveManagementSystem.service;

import top.zhengru.LeaveManagementSystem.base.PageResult;
import top.zhengru.LeaveManagementSystem.base.ResponseResult;
import top.zhengru.LeaveManagementSystem.entity.LeaveInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import top.zhengru.LeaveManagementSystem.param.NewLeaveParam;
import top.zhengru.LeaveManagementSystem.param.QueryLeaveParam;
import top.zhengru.LeaveManagementSystem.vo.LeaveDetailVO;
import top.zhengru.LeaveManagementSystem.vo.LeaveInfoVO;

import java.util.Map;

/**
* @author 董政儒
* @description 针对表【leave_info】的数据库操作Service
* @createDate 2023-12-14 21:46:30
*/
public interface LeaveInfoService extends IService<LeaveInfo> {

    /**
     * 学生发起请假
     * @param newLeaveParam
     * @return
     */
    ResponseResult<String> newLeave(NewLeaveParam newLeaveParam);

    /**
     * 查询请假单
     * @param queryLeaveParam
     * @return
     */
    ResponseResult<PageResult> queryLeave(QueryLeaveParam queryLeaveParam);

    /**
     * 生成审批编号
     * @return
     */
    ResponseResult<Map<String, String>> getLeaveNo();

    /**
     * 查询请假详情
     * @param id
     * @return
     */
    ResponseResult<LeaveDetailVO> queryLeaveDetail(Integer id);
}
