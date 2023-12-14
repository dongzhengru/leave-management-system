package top.zhengru.LeaveManagementSystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import top.zhengru.LeaveManagementSystem.base.ResponseResult;
import top.zhengru.LeaveManagementSystem.entity.SysMenu;
import top.zhengru.LeaveManagementSystem.service.SysMenuService;
import top.zhengru.LeaveManagementSystem.mapper.SysMenuMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 董政儒
* @description 针对表【sys_menu】的数据库操作Service实现
* @createDate 2023-09-21 20:34:00
*/
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu>
    implements SysMenuService{

    @Autowired
    SysMenuMapper sysMenuMapper;

    /**
     * 查询主页菜单
     * @return
     */
    @Override
    public ResponseResult<List<SysMenu>> getMenuByUserId() {
        UserDetailImpl userDetail = (UserDetailImpl) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        String username = userDetail.getUsername();
        return new ResponseResult<>(200, sysMenuMapper.getMenuByUserId(username));
    }
}




