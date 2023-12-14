package top.zhengru.LeaveManagementSystem.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import top.zhengru.LeaveManagementSystem.base.ResponseResult;
import top.zhengru.LeaveManagementSystem.service.impl.GrantedAuthorityImpl;
import top.zhengru.LeaveManagementSystem.service.impl.UserDetailImpl;
import top.zhengru.LeaveManagementSystem.utils.JwtUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


@Component
public class JwtAuthenticationFilter extends GenericFilter {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    ObjectMapper objectMapper;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String token = request.getHeader(JwtUtils.HEADER_TOKEN_NAME);   // 从请求头中拿到token
        Claims claims = null;
        //判断token
        if (Objects.nonNull(token) && !token.trim().isEmpty()){
            String tokenInRedis = stringRedisTemplate.opsForValue().get("logintoken:" + token);
            if(!StringUtils.hasText(tokenInRedis)){
                servletResponse.setCharacterEncoding("UTF-8");
                servletResponse.setContentType("application/json;charset=utf-8");
                ResponseResult<Object> result = new ResponseResult<>(50014, "登录过期，请重新登录");
                PrintWriter writer = servletResponse.getWriter();
                writer.write(objectMapper.writeValueAsString(result));
                writer.flush();
                return;
            }
            try {
                claims = Jwts.parser().setSigningKey(JwtUtils.SECRET).parseClaimsJws(token).getBody();
            } catch (ExpiredJwtException ignored) {
            }
            if (!Objects.isNull(claims)){
                claims = Jwts.parser().setSigningKey(JwtUtils.SECRET).parseClaimsJws(token).getBody();
                Map<String, Object> userInfoMap = (Map<String, Object>) claims.get("userInfo");
                String username = (String) userInfoMap.get("username");
                String realName = (String) userInfoMap.get("realName");
                String unitName = (String) userInfoMap.get("unitName");
                String major = (String) userInfoMap.get("major");
                String classNo = (String) userInfoMap.get("classNo");
                Integer isTeacher = (Integer) userInfoMap.get("isTeacher");
                List<String> roles = (List<String>) userInfoMap.get("roles");

                //别管怎么回事，chatGpt写的，并且能用，就暂时这么用吧
                List<Map<String, String>> authoritiesData = (List<Map<String, String>>) userInfoMap.get("authorities");
                List<GrantedAuthority> authorities = authoritiesData.stream()
                        .map(authorityMap -> new SimpleGrantedAuthority(authorityMap.get("authority")))
                        .collect(Collectors.toList());

                List<GrantedAuthorityImpl> grantedAuthoritiesImpl = authorities.stream()
                        .map(authority -> new GrantedAuthorityImpl(authority.getAuthority()))
                        .collect(Collectors.toList());

                UserDetailImpl userDetail = new UserDetailImpl(username, realName, null, unitName, major, classNo, isTeacher, roles, grantedAuthoritiesImpl);
                //交还给SpringSecurity
                SecurityContextHolder.getContext().setAuthentication
                        (new UsernamePasswordAuthenticationToken(userDetail, null, authorities));
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
