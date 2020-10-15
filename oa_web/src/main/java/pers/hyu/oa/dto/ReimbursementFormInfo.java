package pers.hyu.oa.dto;

import pers.hyu.oa.entity.ReimbursementForm;
import pers.hyu.oa.entity.ReimbursementFormDetail;

import java.util.List;

public class ReimbursementFormInfo {
    private ReimbursementForm form;
    private List<ReimbursementFormDetail> formDetailList;

    public ReimbursementForm getForm() {
        return form;
    }

    public void setForm(ReimbursementForm form) {
        this.form = form;
    }

    public List<ReimbursementFormDetail> getFormDetailList() {
        return formDetailList;
    }

    public void setFormDetailList(List<ReimbursementFormDetail> formDetailList) {
        this.formDetailList = formDetailList;
    }
}
