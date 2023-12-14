package top.zhengru.LeaveManagementSystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 
 * @TableName sys_class
 */
@TableName(value ="sys_class")
public class SysClass implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 班级号
     */
    private String classno;

    /**
     * 专业名称
     */
    private String major;

    /**
     * 教师工号
     */
    private String teachNo;

    /**
     * 逻辑删除
     */
    private Integer isDeleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 班级号
     */
    public String getClassno() {
        return classno;
    }

    /**
     * 班级号
     */
    public void setClassno(String classno) {
        this.classno = classno;
    }

    /**
     * 专业名称
     */
    public String getMajor() {
        return major;
    }

    /**
     * 专业名称
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * 教师工号
     */
    public String getTeachNo() {
        return teachNo;
    }

    /**
     * 教师工号
     */
    public void setTeachNo(String teachNo) {
        this.teachNo = teachNo;
    }

    /**
     * 逻辑删除
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * 逻辑删除
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SysClass other = (SysClass) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getClassno() == null ? other.getClassno() == null : this.getClassno().equals(other.getClassno()))
            && (this.getMajor() == null ? other.getMajor() == null : this.getMajor().equals(other.getMajor()))
            && (this.getTeachNo() == null ? other.getTeachNo() == null : this.getTeachNo().equals(other.getTeachNo()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getClassno() == null) ? 0 : getClassno().hashCode());
        result = prime * result + ((getMajor() == null) ? 0 : getMajor().hashCode());
        result = prime * result + ((getTeachNo() == null) ? 0 : getTeachNo().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", classno=").append(classno);
        sb.append(", major=").append(major);
        sb.append(", teachNo=").append(teachNo);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}