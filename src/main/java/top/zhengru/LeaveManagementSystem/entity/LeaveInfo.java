package top.zhengru.LeaveManagementSystem.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName leave_info
 */
@TableName(value ="leave_info")
public class LeaveInfo implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer id;

    /**
     * 班级号
     */
    private String classno;

    /**
     * 审批编号
     */
    private String leaveNo;

    /**
     * 分院名称
     */
    private String unitName;

    /**
     * 专业名
     */
    private String major;

    /**
     * 学号
     */
    private String username;

    /**
     * 姓名
     */
    private String realName;

    /**
     * 家长联系方式
     */
    private String phone;

    /**
     * 请假开始时间
     */
    private Date startTime;

    /**
     * 请假结束时间
     */
    private Date endTime;

    /**
     * 请假类型
     */
    private String leaveType;

    /**
     * 是否影响晚自习
     */
    private Integer isEvening;

    /**
     * 备注
     */
    private String remark;

    /**
     * 材料
     */
    private String url;

    /**
     * 审批状态（驳回-2、撤销-1、待审批0、审批中1、通过2）
     */
    private Integer status;

    /**
     * 当前审批节点
     */
    private Integer nowOrder;

    /**
     * 审批发起时间
     */
    private Date createTime;

    /**
     * 审批完成时间
     */
    private Date completeTime;

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
     * 审批编号
     */
    public String getLeaveNo() {
        return leaveNo;
    }

    /**
     * 审批编号
     */
    public void setLeaveNo(String leaveNo) {
        this.leaveNo = leaveNo;
    }

    /**
     * 分院id
     */
    public String getUnitName() {
        return unitName;
    }

    /**
     * 分院id
     */
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    /**
     * 专业名
     */
    public String getMajor() {
        return major;
    }

    /**
     * 专业名
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * 学号
     */
    public String getUsername() {
        return username;
    }

    /**
     * 学号
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 姓名
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * 家长联系方式
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 家长联系方式
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 请假开始时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 请假开始时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 请假结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 请假结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 请假类型
     */
    public String getLeaveType() {
        return leaveType;
    }

    /**
     * 请假类型
     */
    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    /**
     * 是否影响晚自习
     */
    public Integer getIsEvening() {
        return isEvening;
    }

    /**
     * 是否影响晚自习
     */
    public void setIsEvening(Integer isEvening) {
        this.isEvening = isEvening;
    }

    /**
     * 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 材料
     */
    public String getUrl() {
        return url;
    }

    /**
     * 材料
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 审批状态（驳回-2、撤销-1、待审批0、审批中1、通过2）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 审批状态（驳回-2、撤销-1、待审批0、审批中1、通过2）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 当前审批节点
     */
    public Integer getNowOrder() {
        return nowOrder;
    }

    /**
     * 当前审批节点
     */
    public void setNowOrder(Integer nowOrder) {
        this.nowOrder = nowOrder;
    }

    /**
     * 审批发起时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 审批发起时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 审批完成时间
     */
    public Date getCompleteTime() {
        return completeTime;
    }

    /**
     * 审批完成时间
     */
    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
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
        LeaveInfo other = (LeaveInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getClassno() == null ? other.getClassno() == null : this.getClassno().equals(other.getClassno()))
            && (this.getLeaveNo() == null ? other.getLeaveNo() == null : this.getLeaveNo().equals(other.getLeaveNo()))
            && (this.getUnitName() == null ? other.getUnitName() == null : this.getUnitName().equals(other.getUnitName()))
            && (this.getMajor() == null ? other.getMajor() == null : this.getMajor().equals(other.getMajor()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getRealName() == null ? other.getRealName() == null : this.getRealName().equals(other.getRealName()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getLeaveType() == null ? other.getLeaveType() == null : this.getLeaveType().equals(other.getLeaveType()))
            && (this.getIsEvening() == null ? other.getIsEvening() == null : this.getIsEvening().equals(other.getIsEvening()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getNowOrder() == null ? other.getNowOrder() == null : this.getNowOrder().equals(other.getNowOrder()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCompleteTime() == null ? other.getCompleteTime() == null : this.getCompleteTime().equals(other.getCompleteTime()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getClassno() == null) ? 0 : getClassno().hashCode());
        result = prime * result + ((getLeaveNo() == null) ? 0 : getLeaveNo().hashCode());
        result = prime * result + ((getUnitName() == null) ? 0 : getUnitName().hashCode());
        result = prime * result + ((getMajor() == null) ? 0 : getMajor().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getRealName() == null) ? 0 : getRealName().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getLeaveType() == null) ? 0 : getLeaveType().hashCode());
        result = prime * result + ((getIsEvening() == null) ? 0 : getIsEvening().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getNowOrder() == null) ? 0 : getNowOrder().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCompleteTime() == null) ? 0 : getCompleteTime().hashCode());
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
        sb.append(", leaveNo=").append(leaveNo);
        sb.append(", unitName=").append(unitName);
        sb.append(", major=").append(major);
        sb.append(", username=").append(username);
        sb.append(", realName=").append(realName);
        sb.append(", phone=").append(phone);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", leaveType=").append(leaveType);
        sb.append(", isEvening=").append(isEvening);
        sb.append(", remark=").append(remark);
        sb.append(", url=").append(url);
        sb.append(", status=").append(status);
        sb.append(", nowOrder=").append(nowOrder);
        sb.append(", createTime=").append(createTime);
        sb.append(", completeTime=").append(completeTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}