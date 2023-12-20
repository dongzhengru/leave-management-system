package top.zhengru.LeaveManagementSystem.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Author: dongzhengru
 * @Blog: blog.zhengru.top
 * @Date: 2023/12/17
 * @Time: 0:13
 */
@Data
public class LeaveDetailVO {
    private Integer id;
    private String leaveNo;
    private String unitName;
    private String major;
    private String classNo;
    private String username;
    private String realName;
    private String phone;
    private String leaveType;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date startTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date endTime;
    private Integer isEvening;
    private String remark;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date createTime;
    private List<String> url;
    private Integer status;
    private String nowOrder;
    private List<ApprovalProcessVO> approvalProcess;
    private List<ccPersonVO> ccPersons;
}
