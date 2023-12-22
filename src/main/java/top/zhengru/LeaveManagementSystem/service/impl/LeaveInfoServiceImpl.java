package top.zhengru.LeaveManagementSystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import top.zhengru.LeaveManagementSystem.base.PageResult;
import top.zhengru.LeaveManagementSystem.base.ResponseResult;
import top.zhengru.LeaveManagementSystem.config.MinIOConfig;
import top.zhengru.LeaveManagementSystem.entity.ApprovalProcess;
import top.zhengru.LeaveManagementSystem.entity.LeaveInfo;
import top.zhengru.LeaveManagementSystem.entity.SysUser;
import top.zhengru.LeaveManagementSystem.exception.CustomException;
import top.zhengru.LeaveManagementSystem.mapper.ApprovalProcessMapper;
import top.zhengru.LeaveManagementSystem.mapper.SysUserMapper;
import top.zhengru.LeaveManagementSystem.param.NewLeaveParam;
import top.zhengru.LeaveManagementSystem.param.QueryLeaveParam;
import top.zhengru.LeaveManagementSystem.service.LeaveInfoService;
import top.zhengru.LeaveManagementSystem.mapper.LeaveInfoMapper;
import org.springframework.stereotype.Service;
import top.zhengru.LeaveManagementSystem.utils.MinIOUtils;
import top.zhengru.LeaveManagementSystem.vo.LeaveDetailVO;
import top.zhengru.LeaveManagementSystem.vo.LeaveInfoVO;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

/**
* @author 董政儒
* @description 针对表【leave_info】的数据库操作Service实现
* @createDate 2023-12-14 20:10:11
*/
@Service
public class LeaveInfoServiceImpl extends ServiceImpl<LeaveInfoMapper, LeaveInfo>
    implements LeaveInfoService{

    @Autowired
    LeaveInfoMapper leaveInfoMapper;
    @Autowired
    ApprovalProcessMapper approvalProcessMapper;
    @Autowired
    MinIOConfig minIOConfig;
    @Autowired
    SysUserMapper sysUserMapper;

    /**
     * 学生发起请假
     * @param newLeaveParam
     * @return
     */
    @Override
    @Transactional
    public ResponseResult<String> newLeave(NewLeaveParam newLeaveParam) {
        UserDetailImpl userDetail = (UserDetailImpl) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();

        LeaveInfo leaveInfo = new LeaveInfo();
        if (newLeaveParam.getLeaveNo() == null) throw new CustomException("表单异常，请刷新页面重试！");
        leaveInfo.setLeaveNo(newLeaveParam.getLeaveNo());
        leaveInfo.setUnitName(userDetail.getUnitName());
        leaveInfo.setMajor(userDetail.getMajor());
        leaveInfo.setClassno(userDetail.getClassNo());
        leaveInfo.setUsername(userDetail.getUsername());
        leaveInfo.setRealName(userDetail.getRealName());
        if (newLeaveParam.getPhone() == null) throw new CustomException("手机号不能为空！");
        leaveInfo.setPhone(newLeaveParam.getPhone());
        if (newLeaveParam.getStartTime() == null) throw new CustomException("请假开始时间不能为空！");
        leaveInfo.setStartTime(newLeaveParam.getStartTime());
        if (newLeaveParam.getEndTime() == null) throw new CustomException("请假结束时间不能为空！");
        leaveInfo.setEndTime(newLeaveParam.getEndTime());
        if (newLeaveParam.getLeaveType() == null) throw new CustomException("请假类型不能为空！");
        leaveInfo.setLeaveType(newLeaveParam.getLeaveType());
        leaveInfo.setIsEvening(newLeaveParam.getIsEvening());
        leaveInfo.setRemark(newLeaveParam.getRemark());
        leaveInfo.setUrl(null);
        leaveInfo.setStatus(0);
        leaveInfo.setNowOrder(1);
        leaveInfo.setCreateTime(new Date());

        // 获取当前年月份
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");
        String currentDate = DATE_FORMAT.format(new Date());

        if (newLeaveParam.getFiles() != null) {
            List<String> url = new ArrayList<>();
            for (MultipartFile file : newLeaveParam.getFiles()) {
                String imgUrl = null;
                try {
                    String oldFilename = file.getOriginalFilename();
                    // 以日期归档，文件名生成格式：姓名_学号_审批编号_UUID
                    String newFileName = currentDate + "/";
                    newFileName += userDetail.getRealName() + "_" + userDetail.getUsername()
                            + "_" + newLeaveParam.getLeaveNo() + "_" + UUID.randomUUID()
                            + oldFilename.substring(oldFilename.lastIndexOf('.'));
                    MinIOUtils.uploadFile(minIOConfig.getBucketName(), newFileName,
                            file.getInputStream());
                    imgUrl = MinIOUtils.getBasisUrl() + newFileName;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                url.add(imgUrl);
            }
            leaveInfo.setUrl(url.toString());
        }

        // 插入请假单数据
        Integer count = leaveInfoMapper.newLeave(leaveInfo);
        Integer leaveId = leaveInfo.getId();
        // 获取审批人和抄送人
        List<String> approvalPersons = Arrays.asList(newLeaveParam.getApprovalPersons().replaceAll("\\[|\\]|\"", "").split(","));
        List<String> ccPersons = Arrays.asList(newLeaveParam.getCcPersons().replaceAll("\\[|\\]|\"", "").split(","));
        // 检查合法性
        Set<String> set = new HashSet<>();
        for (String person : approvalPersons) {
            if (!set.add(person)) {
                throw new CustomException("请勿添加重复的审批人!");
            }
        }
        set.clear();
        for (String cc : ccPersons) {
            if (!set.add(cc)) {
                throw new CustomException("请勿添加重复的抄送人!");            }
        }
        // 审批流程表添加审批人
        int order = 1;
        for (String approvalPerson : approvalPersons) {
            ApprovalProcess approvalProcess = new ApprovalProcess();
            approvalProcess.setLeaveId(leaveId);
            approvalProcess.setApproverNo(approvalPerson);
            approvalProcess.setApproveOrder(order);
            // 人员类型为审批人
            approvalProcess.setAction(1);
            approvalProcess.setStatus(0);
            approvalProcess.setIsLast(0);
            if (order == approvalPersons.size()) {
                // 为最后审批节点
                approvalProcess.setIsLast(1);
            }
            count += approvalProcessMapper.insert(approvalProcess);
            order++;
        }
        // 审批流程表添加抄送人
        if (!ccPersons.contains("")) {
            for (String ccPerson : ccPersons) {
                ApprovalProcess approvalProcess = new ApprovalProcess();
                approvalProcess.setLeaveId(leaveId);
                approvalProcess.setApproverNo(ccPerson);
                // 不参与审批流程
                approvalProcess.setApproveOrder(-1);
                // 人员类型为抄送人
                approvalProcess.setAction(0);
                approvalProcess.setStatus(0);
                approvalProcess.setIsLast(0);
                count += approvalProcessMapper.insert(approvalProcess);
            }
        } else {
            ccPersons.remove("");
        }
        if (count == approvalPersons.size() + ccPersons.size() + 1) {
            return new ResponseResult<>(200, "提交成功！");
        } else {
            throw new CustomException("提交失败");
        }
    }

    /**
     * 查询请假单
     * @param queryLeaveParam
     * @return
     */
    @Override
    public ResponseResult<PageResult> queryLeave(QueryLeaveParam queryLeaveParam) {
        UserDetailImpl userDetail = (UserDetailImpl) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        if (userDetail.getRoles().contains("学生")) {
            queryLeaveParam.setUsername(userDetail.getUsername());
        } else if (userDetail.getRoles().contains("教师")) {
            queryLeaveParam.setApproverNo(userDetail.getUsername());
            if (userDetail.getRoles().contains("分院教务办老师") || userDetail.getRoles().contains("分院院长")) {
                queryLeaveParam.setApproverNo(null);
                queryLeaveParam.setUnitName(userDetail.getUnitName());
            }
            if (userDetail.getRoles().contains("教务处老师")) {
                queryLeaveParam.setApproverNo(null);
            }
        }
        Integer page = queryLeaveParam.getPage();
        Integer pageSize = queryLeaveParam.getPageSize();
        if (page == null) {
            page = 1;
        }
        if (pageSize == null) {
            pageSize = 20;
        }
        PageHelper.startPage(page, pageSize);
        Page<LeaveInfoVO> leaveInfoVOList = leaveInfoMapper.queryLeave(queryLeaveParam);
        return new ResponseResult<>(200, new PageResult(leaveInfoVOList.getTotal(), leaveInfoVOList));
    }

    /**
     * 生成审批编号
     * @return
     */
    @Override
    public ResponseResult<Map<String, String>> getLeaveNo() {
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");
        String currentDate = DATE_FORMAT.format(new Date());
        String number = String.format("%013d", System.currentTimeMillis() % 10000000000000L);
        Map<String, String> leaveNo = new HashMap<>();
        leaveNo.put("leaveNo", currentDate + number);
        return new ResponseResult<>(200, leaveNo);
    }

    /**
     * 查询请假详情
     * @param id
     * @return
     */
    @Override
    @Transactional
    public ResponseResult<LeaveDetailVO> queryLeaveDetail(Integer id) {
        UserDetailImpl userDetail = (UserDetailImpl) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        ApprovalProcess approvalProcess = new ApprovalProcess();
        approvalProcess.setLeaveId(id);
        approvalProcess.setApproverNo(userDetail.getUsername());
        approvalProcess.setCompleteTime(new Date());
        approvalProcessMapper.readLeaveDetail(approvalProcess);
        LeaveDetailVO leaveDetailVO = leaveInfoMapper.queryLeaveDetail(id);
        leaveDetailVO.setApprovalProcess(approvalProcessMapper.queryApprovalProcess(id));
        leaveDetailVO.setCcPersons(approvalProcessMapper.queryCcPersons(id));
        return new ResponseResult<>(200, leaveDetailVO);
    }
}




