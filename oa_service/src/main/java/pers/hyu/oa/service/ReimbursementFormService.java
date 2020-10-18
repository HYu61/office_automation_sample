package pers.hyu.oa.service;

import pers.hyu.oa.entity.ReimbursementForm;
import pers.hyu.oa.entity.ReimbursementFormRecord;

import java.util.List;

public interface ReimbursementFormService {
    void create(ReimbursementForm reimbursementForm);
    void removeById(int id);
    void removeMulti(List<Integer> idList);
    ReimbursementForm getById(int id);
    List<ReimbursementFormRecord> getRecord(int id);
    List<ReimbursementForm> getByApplicant(String applicantSn);
    List<ReimbursementForm> getByApprover(String approverSn);

    void edit(ReimbursementForm reimbursementForm);
    void submit(int formId);
    void audit(ReimbursementFormRecord record);

}
