package top.zhengru.LeaveManagementSystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 
 * @TableName sys_unit
 */
@TableName(value ="sys_unit")
public class SysUnit implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 分院名称
     */
    private String unitname;

    /**
     * 分院院长工号
     */
    private String headerNo;

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
     * 分院名称
     */
    public String getUnitname() {
        return unitname;
    }

    /**
     * 分院名称
     */
    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }

    /**
     * 分院院长工号
     */
    public String getHeaderNo() {
        return headerNo;
    }

    /**
     * 分院院长工号
     */
    public void setHeaderNo(String headerNo) {
        this.headerNo = headerNo;
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
        SysUnit other = (SysUnit) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUnitname() == null ? other.getUnitname() == null : this.getUnitname().equals(other.getUnitname()))
            && (this.getHeaderNo() == null ? other.getHeaderNo() == null : this.getHeaderNo().equals(other.getHeaderNo()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUnitname() == null) ? 0 : getUnitname().hashCode());
        result = prime * result + ((getHeaderNo() == null) ? 0 : getHeaderNo().hashCode());
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
        sb.append(", unitname=").append(unitname);
        sb.append(", headerNo=").append(headerNo);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}