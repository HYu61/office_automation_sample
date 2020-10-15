package pers.hyu.oa.dao;

import org.springframework.stereotype.Repository;
import pers.hyu.oa.entity.ReimbursementFormDetail;

import java.util.List;

@Repository("reimbursementFormDetailDao")
public interface ReimbursementFormDetailDao {
    void insert(ReimbursementFormDetail reimbursementFormDetail);

    // delete one detail
    void delete(int id);

    // delete all the detail items which associate with the reimbursement form
    void deleteByReimbursementFromId(int formId);
    void update(ReimbursementFormDetail reimbursementFormDetail);
    List<ReimbursementFormDetail> selectByReimbursementForm(int formId);
}
