package top.zhengru.LeaveManagementSystem.vo;

import lombok.Data;

/**
 * @Author: dongzhengru
 * @Blog: blog.zhengru.top
 * @Date: 2023/12/21
 * @Time: 19:45
 */
@Data
public class StatisticVO {
    private Integer total;
    private Integer unFinished;
    private Double avgTime;
}
