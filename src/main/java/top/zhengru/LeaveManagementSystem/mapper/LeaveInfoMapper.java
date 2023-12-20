package top.zhengru.LeaveManagementSystem.mapper;

import com.github.pagehelper.Page;
import top.zhengru.LeaveManagementSystem.entity.LeaveInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.zhengru.LeaveManagementSystem.param.QueryLeaveParam;
import top.zhengru.LeaveManagementSystem.vo.LeaveDetailVO;
import top.zhengru.LeaveManagementSystem.vo.LeaveInfoVO;

import java.util.List;

/**
* @author 董政儒
* @description 针对表【leave_info】的数据库操作Mapper
* @createDate 2023-12-14 21:46:30
* @Entity top.zhengru.LeaveManagementSystem.entity.LeaveInfo
*/
public interface LeaveInfoMapper extends BaseMapper<LeaveInfo> {

    /**
     * 学生发起请假
     * @param leaveInfo
     * @return
     */
    Integer newLeave(LeaveInfo leaveInfo);

    /**
     * 查询请假单
     * @param queryLeaveParam
     * @return
     */
    Page<LeaveInfoVO> queryLeave(QueryLeaveParam queryLeaveParam);

    /**
     * 查询请假详情
     * @param id
     * @return
     */
    LeaveDetailVO queryLeaveDetail(Integer id);
}




