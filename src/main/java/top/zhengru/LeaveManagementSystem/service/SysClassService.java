package top.zhengru.LeaveManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import top.zhengru.LeaveManagementSystem.entity.SysClass;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 董政儒
* @description 针对表【sys_class】的数据库操作Service
* @createDate 2023-12-12 20:43:20
*/
public interface SysClassService extends IService<SysClass> {

    /**
     * 根据用户ID查询班级信息
     * @param userId
     * @return
     */
    SysClass queryClassByUserId(Integer userId);
}