package top.zhengru.LeaveManagementSystem.mapper;

import top.zhengru.LeaveManagementSystem.entity.SysClass;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 董政儒
* @description 针对表【sys_class】的数据库操作Mapper
* @createDate 2023-12-12 20:43:20
* @Entity top.zhengru.LeaveManagementSystem.entity.SysClass
*/
public interface SysClassMapper extends BaseMapper<SysClass> {

    /**
     * 根据用户ID查询班级信息
     * @param userId
     * @return
     */
    SysClass queryClassByUserId(Integer userId);
}



