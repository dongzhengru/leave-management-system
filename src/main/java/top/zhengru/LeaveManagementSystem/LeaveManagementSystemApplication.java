package top.zhengru.LeaveManagementSystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan(basePackages = "top.zhengru.LeaveManagementSystem.mapper")
@EnableCaching
public class LeaveManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeaveManagementSystemApplication.class, args);
    }

}
