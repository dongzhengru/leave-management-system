package top.zhengru.LeaveManagementSystem.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author: dongzhengru
 * @Blog: blog.zhengru.top
 * @Date: 2023/12/15
 * @Time: 23:38
 */
@Data
public class LeaveInfoVO {
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
    private Integer status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date createTime;
    private String nowApproval;

}
