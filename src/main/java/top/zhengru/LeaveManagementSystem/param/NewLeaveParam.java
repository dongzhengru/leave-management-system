package top.zhengru.LeaveManagementSystem.param;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @Author: dongzhengru
 * @Blog: blog.zhengru.top
 * @Date: 2023/12/14
 * @Time: 20:11
 */
@Data
public class NewLeaveParam {
    private String leaveNo;
    private String phone;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date endTime;
    private String leaveType;
    private Integer isEvening;
    private MultipartFile[] files;
    private String remark;
    private String approvalPersons;
    private String ccPersons;
}
