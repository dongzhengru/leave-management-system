package top.zhengru.LeaveManagementSystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import top.zhengru.LeaveManagementSystem.entity.SysUnit;
import top.zhengru.LeaveManagementSystem.service.SysUnitService;
import top.zhengru.LeaveManagementSystem.mapper.SysUnitMapper;
import org.springframework.stereotype.Service;

/**
* @author 董政儒
* @description 针对表【sys_unit】的数据库操作Service实现
* @createDate 2023-12-12 20:37:16
*/
@Service
public class SysUnitServiceImpl extends ServiceImpl<SysUnitMapper, SysUnit>
    implements SysUnitService{

    @Autowired
    SysUnitMapper sysUnitMapper;

    /**
     * 根据用户ID查询所在分院信息
     * @param userId
     * @return
     */
    @Override
    public SysUnit queryUnitByUserId(Integer userId) {
        return sysUnitMapper.queryUnitByUserId(userId);
    }
}



