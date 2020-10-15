package pers.hyu.oa.dao;

import org.springframework.stereotype.Repository;
import pers.hyu.oa.entity.ReimbursementFormRecord;

import java.util.List;

@Repository("reimbursementFormRecordDao")
public interface ReimbursementFormRecordDao {
    void insert(ReimbursementFormRecord reimbursementFormRecord);
    List<ReimbursementFormRecord> selectByReimbursementForm(int formId);
}
