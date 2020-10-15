package pers.hyu.oa.entity;

public class ReimbursementFormDetail {
    private Integer id;
    private Integer reimbursementFormId;
    private String cateOfExpense;
    private Double amount;
    private String description;

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

    public String getCateOfExpense() {
        return cateOfExpense;
    }

    public void setCateOfExpense(String cateOfExpense) {
        this.cateOfExpense = cateOfExpense;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
