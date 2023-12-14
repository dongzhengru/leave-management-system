package top.zhengru.LeaveManagementSystem.service.impl;

import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author yugle
 */
@NoArgsConstructor
public class GrantedAuthorityImpl implements GrantedAuthority {
    private String authority;

    public GrantedAuthorityImpl(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
