package top.zhengru.LeaveManagementSystem.param;

import lombok.Data;

/**
 * @Author: dongzhengru
 * @Blog: blog.zhengru.top
 * @Date: 2023/9/28
 * @Time: 16:10
 */
@Data
public class ModifyPwdParam {
    private String oldPwd;
    private String newPwd;
}
