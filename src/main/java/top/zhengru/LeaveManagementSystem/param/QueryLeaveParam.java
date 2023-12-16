package top.zhengru.LeaveManagementSystem.param;

import lombok.Data;

/**
 * @Author: dongzhengru
 * @Blog: blog.zhengru.top
 * @Date: 2023/12/15
 * @Time: 23:31
 */
@Data
public class QueryLeaveParam {
    private Integer page;
    private Integer pageSize;
    private String username;
    private String approverNo;
    private String realName;
    private String classNo;
    private String leaveType;
    private Integer status;
}
