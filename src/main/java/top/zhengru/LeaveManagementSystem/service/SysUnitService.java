package top.zhengru.LeaveManagementSystem.service;

import top.zhengru.LeaveManagementSystem.entity.SysUnit;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 董政儒
* @description 针对表【sys_unit】的数据库操作Service
* @createDate 2023-12-12 20:37:16
*/
public interface SysUnitService extends IService<SysUnit> {

    /**
     * 根据用户ID查询所在分院信息
     * @param userId
     * @return
     */
    SysUnit queryUnitByUserId(Integer userId);
}
