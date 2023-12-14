package top.zhengru.LeaveManagementSystem.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import top.zhengru.LeaveManagementSystem.base.ResponseResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class LogoutSuccessHandler implements org.springframework.security.web.authentication.logout.LogoutSuccessHandler {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    ObjectMapper objectMapper;
    
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        String authorization = request.getHeader("Authorization");
        if(authorization == null){
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json;charset=utf-8");
            ResponseResult<Object> result = new ResponseResult<>(50008, "尚未登录，请重新登录");
            PrintWriter writer = response.getWriter();
            writer.write(objectMapper.writeValueAsString(result));
            writer.flush();
            return;
        }
        String token = authorization.replace("Bearer ", "");
        stringRedisTemplate.delete("logintoken:"+token);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        ResponseResult<Object> result = new ResponseResult<>(200, "您已成功退出登录");
        PrintWriter writer = response.getWriter();
        writer.write(objectMapper.writeValueAsString(result));
        writer.flush();
    }
}