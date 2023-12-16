package top.zhengru.LeaveManagementSystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName approval_process
 */
@TableName(value ="approval_process")
public class ApprovalProcess implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 审批单id
     */
    private Integer leaveId;

    /**
     * 审批人工号
     */
    private String approverNo;

    /**
     * 审批顺序
     */
    private Integer approveOrder;

    /**
     * 人员类型
     */
    private Integer action;

    /**
     * 审批意见
     */
    private String reason;

    /**
     * 审批状态（驳回-1、待审批0、已读1、通过2）
     */
    private Integer status;

    /**
     * 是否为最后节点
     */
    private Integer isLast;

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
     * 审批单id
     */
    public Integer getLeaveId() {
        return leaveId;
    }

    /**
     * 审批单id
     */
    public void setLeaveId(Integer leaveId) {
        this.leaveId = leaveId;
    }

    /**
     * 审批人工号
     */
    public String getApproverNo() {
        return approverNo;
    }

    /**
     * 审批人工号
     */
    public void setApproverNo(String approverNo) {
        this.approverNo = approverNo;
    }

    /**
     * 审批顺序
     */
    public Integer getApproveOrder() {
        return approveOrder;
    }

    /**
     * 审批顺序
     */
    public void setApproveOrder(Integer approveOrder) {
        this.approveOrder = approveOrder;
    }

    /**
     * 人员类型
     */
    public Integer getAction() {
        return action;
    }

    /**
     * 人员类型
     */
    public void setAction(Integer action) {
        this.action = action;
    }

    /**
     * 审批意见
     */
    public String getReason() {
        return reason;
    }

    /**
     * 审批意见
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * 审批状态（驳回-1、待审批0、已读1、通过2）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 审批状态（驳回-1、待审批0、已读1、通过2）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 是否为最后节点
     */
    public Integer getIsLast() {
        return isLast;
    }

    /**
     * 是否为最后节点
     */
    public void setIsLast(Integer isLast) {
        this.isLast = isLast;
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
        ApprovalProcess other = (ApprovalProcess) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLeaveId() == null ? other.getLeaveId() == null : this.getLeaveId().equals(other.getLeaveId()))
            && (this.getApproverNo() == null ? other.getApproverNo() == null : this.getApproverNo().equals(other.getApproverNo()))
            && (this.getApproveOrder() == null ? other.getApproveOrder() == null : this.getApproveOrder().equals(other.getApproveOrder()))
            && (this.getAction() == null ? other.getAction() == null : this.getAction().equals(other.getAction()))
            && (this.getReason() == null ? other.getReason() == null : this.getReason().equals(other.getReason()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getIsLast() == null ? other.getIsLast() == null : this.getIsLast().equals(other.getIsLast()))
            && (this.getCompleteTime() == null ? other.getCompleteTime() == null : this.getCompleteTime().equals(other.getCompleteTime()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLeaveId() == null) ? 0 : getLeaveId().hashCode());
        result = prime * result + ((getApproverNo() == null) ? 0 : getApproverNo().hashCode());
        result = prime * result + ((getApproveOrder() == null) ? 0 : getApproveOrder().hashCode());
        result = prime * result + ((getAction() == null) ? 0 : getAction().hashCode());
        result = prime * result + ((getReason() == null) ? 0 : getReason().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getIsLast() == null) ? 0 : getIsLast().hashCode());
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
        sb.append(", leaveId=").append(leaveId);
        sb.append(", approverNo=").append(approverNo);
        sb.append(", approveOrder=").append(approveOrder);
        sb.append(", action=").append(action);
        sb.append(", reason=").append(reason);
        sb.append(", status=").append(status);
        sb.append(", isLast=").append(isLast);
        sb.append(", completeTime=").append(completeTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}