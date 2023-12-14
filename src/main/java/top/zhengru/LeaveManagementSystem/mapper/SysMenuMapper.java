package top.zhengru.LeaveManagementSystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.zhengru.LeaveManagementSystem.entity.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author 董政儒
* @description 针对表【sys_menu】的数据库操作Mapper
* @createDate 2023-09-21 20:34:00
* @Entity top.zhengru.evaluatingsystem.entity.SysMenu
*/
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * 查询主页菜单
     * @param username
     * @return
     */
    List<SysMenu> getMenuByUserId(String username);
}




