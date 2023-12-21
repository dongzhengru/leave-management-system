package top.zhengru.LeaveManagementSystem.mapper;

import top.zhengru.LeaveManagementSystem.entity.SysUnit;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.zhengru.LeaveManagementSystem.vo.UnitInfoVO;

import java.util.List;

/**
* @author 董政儒
* @description 针对表【sys_unit】的数据库操作Mapper
* @createDate 2023-12-12 20:37:16
* @Entity top.zhengru.LeaveManagementSystem.entity.SysUnit
*/
public interface SysUnitMapper extends BaseMapper<SysUnit> {

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
    List<UnitInfoVO> getAllUnit();

}




