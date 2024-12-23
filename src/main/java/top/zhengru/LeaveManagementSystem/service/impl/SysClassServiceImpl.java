package top.zhengru.LeaveManagementSystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import top.zhengru.LeaveManagementSystem.base.ResponseResult;
import top.zhengru.LeaveManagementSystem.entity.SysClass;
import top.zhengru.LeaveManagementSystem.service.SysClassService;
import top.zhengru.LeaveManagementSystem.mapper.SysClassMapper;
import org.springframework.stereotype.Service;
import top.zhengru.LeaveManagementSystem.vo.ApprovalProcessVO;
import top.zhengru.LeaveManagementSystem.vo.ClassInfoVO;
import top.zhengru.LeaveManagementSystem.vo.UnitInfoVO;

import java.util.List;

/**
* @author 董政儒
* @description 针对表【sys_class】的数据库操作Service实现
* @createDate 2023-12-12 20:43:20
*/
@Service
public class SysClassServiceImpl extends ServiceImpl<SysClassMapper, SysClass>
    implements SysClassService{

    @Autowired
    SysClassMapper sysClassMapper;

    /**
     * 根据用户ID查询班级信息
     * @param userId
     * @return
     */
    @Override
    public SysClass queryClassByUserId(Integer userId) {
        return sysClassMapper.queryClassByUserId(userId);
    }

    /**
     * 获取辅导员信息
     * @return
     */
    @Override
    public ResponseResult<ApprovalProcessVO> getClassTeach() {
        UserDetailImpl userDetail = (UserDetailImpl) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        ApprovalProcessVO teachInfo = sysClassMapper.queryClassTeachInfoByClassNo(userDetail.getClassNo());
        return new ResponseResult<>(200, teachInfo);
    }

    /**
     * 查询所有班级
     * @return
     */
    @Override
    public ResponseResult<List<ClassInfoVO>> getAllClass() {
        List<ClassInfoVO> classInfoVOS = sysClassMapper.getAllClass();
        return new ResponseResult<>(200,classInfoVOS);
    }
}




