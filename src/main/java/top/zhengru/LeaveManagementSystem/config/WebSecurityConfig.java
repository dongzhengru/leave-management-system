package top.zhengru.LeaveManagementSystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import top.zhengru.LeaveManagementSystem.filter.JwtAuthenticationFilter;
import top.zhengru.LeaveManagementSystem.handler.AccessDeniedHandlerImpl;
import top.zhengru.LeaveManagementSystem.handler.AuthenticationEntryPointImpl;
import top.zhengru.LeaveManagementSystem.handler.LogoutSuccessHandler;
import top.zhengru.LeaveManagementSystem.service.impl.UserDetailServiceImpl;


@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailServiceImpl userDetailService;

    @Autowired
    JwtAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    AccessDeniedHandlerImpl accessDeniedHandler;

    @Autowired
    AuthenticationEntryPointImpl authenticationEntryPoint;
    @Autowired
    LogoutSuccessHandler logoutSuccessHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                //不通过Session获取SecurityContext
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                // 对于登录接口 允许匿名访问
                .antMatchers("/login").anonymous()
                // 除上面外的所有请求全部需要鉴权认证
                .anyRequest().authenticated()
                .and()
                .logout()
                .logoutSuccessHandler(logoutSuccessHandler)
                .logoutUrl("/logout")
                .and()
                .cors()
                .and()
                // 设置无session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        //添加过滤器
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        //配置异常处理器
        http.exceptionHandling()
                //配置认证失败处理器
                .authenticationEntryPoint(authenticationEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);
    }


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
