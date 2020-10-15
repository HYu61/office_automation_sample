package pers.hyu.oa.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class ReimbursementForm {
    private Integer id;
    private String businessPurpose;
    private String applicantSn;

    @DateTimeFormat(pattern = "yyyy-MM-dd : HH:mm:ss")
    private Date createTime;
    private String approverSn;
    private Double totalAmount;
    private String status;

    private Employee applicant;
    private Employee approver;

    private List<ReimbursementFormDetail> reimbursementFormDetailList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBusinessPurpose() {
        return businessPurpose;
    }

    public void setBusinessPurpose(String businessPurpose) {
        this.businessPurpose = businessPurpose;
    }

    public String getApplicantSn() {
        return applicantSn;
    }

    public void setApplicantSn(String applicantSn) {
        this.applicantSn = applicantSn;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getApproverSn() {
        return approverSn;
    }

    public void setApproverSn(String approverSn) {
        this.approverSn = approverSn;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Employee getApplicant() {
        return applicant;
    }

    public void setApplicant(Employee applicant) {
        this.applicant = applicant;
    }

    public Employee getApprover() {
        return approver;
    }

    public void setApprover(Employee approver) {
        this.approver = approver;
    }

    public List<ReimbursementFormDetail> getReimbursementFormDetailList() {
        return reimbursementFormDetailList;
    }

    public void setReimbursementFormDetailList(List<ReimbursementFormDetail> reimbursementFormDetailList) {
        this.reimbursementFormDetailList = reimbursementFormDetailList;
    }
}
