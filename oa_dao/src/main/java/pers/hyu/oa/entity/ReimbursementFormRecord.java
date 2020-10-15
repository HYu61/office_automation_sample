package pers.hyu.oa.entity;

import java.util.Date;

public class ReimbursementFormRecord {
    private Integer id;
    private Integer reimbursementFormId;
    private String approverSn;
    private Date handleDate;
    private String processType;
    private String result;
    private String remark;

    private Employee approver;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReimbursementFormId() {
        return reimbursementFormId;
    }

    public void setReimbursementFormId(Integer reimbursementFormId) {
        this.reimbursementFormId = reimbursementFormId;
    }

    public String getApproverSn() {
        return approverSn;
    }

    public void setApproverSn(String approverSn) {
        this.approverSn = approverSn;
    }

    public Date getHandleDate() {
        return handleDate;
    }

    public void setHandleDate(Date handleDate) {
        this.handleDate = handleDate;
    }

    public String getProcessType() {
        return processType;
    }

    public void setProcessType(String processType) {
        this.processType = processType;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Employee getApprover() {
        return approver;
    }

    public void setApprover(Employee approver) {
        this.approver = approver;
    }
}
