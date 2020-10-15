package pers.hyu.oa.service.impl;

import org.springframework.stereotype.Service;
import pers.hyu.oa.dao.ReimbursementFormDao;
import pers.hyu.oa.dao.ReimbursementFormDetailDao;
import pers.hyu.oa.dao.ReimbursementFormRecordDao;
import pers.hyu.oa.entity.ReimbursementForm;
import pers.hyu.oa.entity.ReimbursementFormDetail;
import pers.hyu.oa.entity.ReimbursementFormRecord;
import pers.hyu.oa.global.infoenum.StatusEnum;
import pers.hyu.oa.service.ReimbursementFormService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("reimbursementFormService")
public class ReimbursementFormServiceImpl implements ReimbursementFormService {
    @Resource(name = "reimbursementFormDao")
    private ReimbursementFormDao reimbursementFormDao;
    @Resource(name = "reimbursementFormDetailDao")
    private ReimbursementFormDetailDao reimbursementFormDetailDao;
    @Resource(name = "reimbursementFormRecordDao")
    private ReimbursementFormRecordDao reimbursementFormRecordDao;




    /**
     * Create the reimbursement form
     * @param reimbursementForm
     */
    public void create(ReimbursementForm reimbursementForm) {
        // set the created date
        reimbursementForm.setCreateTime(new Date());
        // set the approver. The form is only created and not submit yet, so the approver should be the applicant self.
        reimbursementForm.setApproverSn(reimbursementForm.getApplicantSn());
        // set status to created
        reimbursementForm.setStatus(StatusEnum.CREATED.getStatus());
        // add form
        reimbursementFormDao.insert(reimbursementForm);


        // add the expense item detail to the form
        for (ReimbursementFormDetail rfd :
                reimbursementForm.getReimbursementFormDetailList()) {

            //set form id to each item
            rfd.setReimbursementFormId(reimbursementForm.getId());
            reimbursementFormDetailDao.insert(rfd);
        }
    }

    /**
     * delete the form by id
     * @param id
     */
    public void removeById(int id) {
        // delete the detail form first
       reimbursementFormDetailDao.deleteByReimbursementFromId(id);
       reimbursementFormDao.deleteById(id);
    }

    public void removeMulti(List<Integer> idList) {
        // delete the detail form first
        for (int id :
                idList) {
            reimbursementFormDetailDao.deleteByReimbursementFromId(id);
        }

        // batch delete the forms
        reimbursementFormDao.deleteMulti(idList);
    }

    /**
     * get form by its id
     * @param id the id of the form that need to get
     * @return the form or null if there is no form with that id
     */
    public ReimbursementForm getById(int id) {
        return reimbursementFormDao.selectById(id);
    }

    public List<ReimbursementFormRecord> getRecord(int id) {
        return reimbursementFormRecordDao.selectByReimbursementForm(id);
    }

    /**
     * Get the applicant's all forms
     * @param applicantSn The applicant's sn
     * @return the list of the form
     */
    public List<ReimbursementForm> getByApplicant(String applicantSn) {
        return reimbursementFormDao.selectByApplicant(applicantSn);
    }

    /**
     * Get all the forms that the approver needs to be handle
     * @param approverSn The approver's sn
     * @return the list of the form
     */
    public List<ReimbursementForm> getByApprover(String approverSn) {
        return reimbursementFormDao.selectByApprover(approverSn);
    }


}
