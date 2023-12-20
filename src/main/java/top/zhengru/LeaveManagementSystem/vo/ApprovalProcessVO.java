package top.zhengru.LeaveManagementSystem.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Author: dongzhengru
 * @Blog: blog.zhengru.top
 * @Date: 2023/12/17
 * @Time: 0:31
 */
@Data
public class ApprovalProcessVO {
    private String realName;
    private String username;
    private List<String> roleName;
    private String reason;
    private Integer status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date completeTime;
}
