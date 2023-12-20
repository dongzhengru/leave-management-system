package top.zhengru.LeaveManagementSystem.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Author: dongzhengru
 * @Blog: blog.zhengru.top
 * @Date: 2023/12/17
 * @Time: 0:49
 */
@Data
public class ccPersonVO {
    private String realName;
    private String username;
    private Integer status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date completeTime;
}
