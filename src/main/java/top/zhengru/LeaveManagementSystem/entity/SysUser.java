package top.zhengru.LeaveManagementSystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Objects;

import lombok.Data;

/**
 * @TableName sys_user
 */
@TableName(value ="sys_user")
@Data
public class SysUser implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 真名
     */
    private String realName;

    /**
     * 分院ID
     */
    private Integer unitId;

    /**
     * 班级号
     */
    @TableField("classno")
    private String classNo;

    /**
     * 密码
     */
    private String password;

    /**
     * 是否为教师
     */
    private Integer isTeacher;

    /**
     * 账户启用 0:未启用 1:启用
     */
    private Integer isEnabled;

    /**
     * 账户没有被锁 0:被锁 1:没被锁
     */
    private Integer isAccountNonLocked;

    /**
     * 逻辑删除标记

     */
    private Integer isDeleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysUser sysUser = (SysUser) o;
        return Objects.equals(id, sysUser.id) && Objects.equals(username, sysUser.username) && Objects.equals(realName, sysUser.realName) && Objects.equals(unitId, sysUser.unitId) && Objects.equals(classNo, sysUser.classNo) && Objects.equals(password, sysUser.password) && Objects.equals(isTeacher, sysUser.isTeacher) && Objects.equals(isEnabled, sysUser.isEnabled) && Objects.equals(isAccountNonLocked, sysUser.isAccountNonLocked) && Objects.equals(isDeleted, sysUser.isDeleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, realName, unitId, classNo, password, isTeacher, isEnabled, isAccountNonLocked, isDeleted);
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", realName='" + realName + '\'' +
                ", unitId=" + unitId +
                ", classNo='" + classNo + '\'' +
                ", password='" + password + '\'' +
                ", isTeacher=" + isTeacher +
                ", isEnabled=" + isEnabled +
                ", isAccountNonLocked=" + isAccountNonLocked +
                ", isDeleted=" + isDeleted +
                '}';
    }
}