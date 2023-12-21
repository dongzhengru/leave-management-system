package top.zhengru.LeaveManagementSystem.service;

import top.zhengru.LeaveManagementSystem.base.ResponseResult;
import top.zhengru.LeaveManagementSystem.entity.SysUnit;
import com.baomidou.mybatisplus.extension.service.IService;
import top.zhengru.LeaveManagementSystem.vo.UnitInfoVO;

import java.util.List;

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

    /**
     * 查询所有二级学院
     * @return
     */
    ResponseResult<List<UnitInfoVO>> getAllUnit();

}
