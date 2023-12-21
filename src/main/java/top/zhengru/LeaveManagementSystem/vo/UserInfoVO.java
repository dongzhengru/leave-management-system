package top.zhengru.LeaveManagementSystem.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: dongzhengru
 * @Blog: blog.zhengru.top
 * @Date: 2023/9/20
 * @Time: 21:43
 */

@Data
public class UserInfoVO implements Serializable {
    private Integer id;
    private String username;
    private String realName;
    private String unitName;
    private String major;
    private String classNo;
    private Integer isTeacher;
    private List<String> role;
}
