package top.zhengru.LeaveManagementSystem.exception;

/**
 * @Author: dongzhengru
 * @Blog: blog.zhengru.top
 * @Date: 2023/12/21
 * @Time: 14:57
 */
public class CustomException extends RuntimeException {
    public CustomException() {
    }

    public CustomException(String message) {
        super(message);
    }
}
