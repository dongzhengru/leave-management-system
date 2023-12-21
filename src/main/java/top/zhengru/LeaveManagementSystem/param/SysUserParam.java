package top.zhengru.LeaveManagementSystem.param;

import lombok.Data;

/**
 * @Author: dongzhengru
 * @Blog: blog.zhengru.top
 * @Date: 2023/9/26
 * @Time: 14:23
 */
@Data
public class SysUserParam {
    private Integer page;
    private Integer pageSize;
    private String realName;
    private String username;
    private String classNo;
    private Integer isTeacher;
}
