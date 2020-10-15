package pers.hyu.oa.dao;

import org.springframework.stereotype.Repository;
import pers.hyu.oa.entity.ReimbursementForm;

import java.util.List;

/***
 * CRUD for reimbursement form
 */
@Repository("reimbursementFormDao")
public interface ReimbursementFormDao {
    void insert(ReimbursementForm reimbursementForm);
    void deleteById(int id);
    void deleteMulti(List<Integer> idList);
    void update(ReimbursementForm reimbursementForm);
    ReimbursementForm selectById(int id);
    List<ReimbursementForm> selectByApplicant(String applicantSn);
    List<ReimbursementForm> selectByApprover(String approverSn);
}
