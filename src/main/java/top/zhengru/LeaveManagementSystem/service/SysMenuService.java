package top.zhengru.LeaveManagementSystem.service;

import top.zhengru.LeaveManagementSystem.base.ResponseResult;
import top.zhengru.LeaveManagementSystem.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 董政儒
* @description 针对表【sys_menu】的数据库操作Service
* @createDate 2023-09-21 20:34:00
*/
public interface SysMenuService extends IService<SysMenu> {

    /**
     * 查询主页菜单
     * @return
     */
    ResponseResult<List<SysMenu>> getMenuByUserId();
}
