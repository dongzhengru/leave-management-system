package top.zhengru.LeaveManagementSystem.service.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import top.zhengru.LeaveManagementSystem.entity.SysUser;

import java.util.Collection;
import java.util.List;

@Data
public class UserDetailImpl implements UserDetails {
    private String username;
    private String realName;
    @JsonIgnore
    private String password;
    private String unitName;
    private String major;
    private String classNo;
    private Integer isTeacher;
    private List<String> roles;
    private List<GrantedAuthorityImpl> authorities;

    @JsonIgnore
    private boolean accountNonExpired;
    @JsonIgnore
    private boolean accountNonLocked;
    @JsonIgnore
    private boolean credentialsNonExpired;
    @JsonIgnore
    private boolean enabled;

    public UserDetailImpl(String username, String realName, String password, String unitName,
                          String major, String classNo, Integer isTeacher,
                          List<String> roles, List<GrantedAuthorityImpl> authorities) {
        this.username = username;
        this.realName = realName;
        this.password = password;
        this.unitName = unitName;
        this.major = major;
        this.classNo = classNo;
        this.isTeacher = isTeacher;
        this.roles = roles;
        this.authorities = authorities;
    }

    public UserDetailImpl(SysUser sysUser, String unitName, String major, List<String> roles, List<GrantedAuthorityImpl> authorities){
        this.username = sysUser.getUsername();
        this.realName = sysUser.getRealName();
        this.password = sysUser.getPassword();
        this.unitName = unitName;
        this.major = major;
        this.classNo = sysUser.getClassNo();
        this.isTeacher = sysUser.getIsTeacher();
        this.roles = roles;
        this.authorities = authorities;
        this.enabled = sysUser.getIsEnabled() == 1;
        this.accountNonLocked = sysUser.getIsAccountNonLocked() == 1;
        this.credentialsNonExpired = true;
        this.accountNonExpired = true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
