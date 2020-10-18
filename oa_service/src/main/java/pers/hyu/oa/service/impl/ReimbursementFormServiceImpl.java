package pers.hyu.oa.service.impl;

import org.springframework.stereotype.Service;
import pers.hyu.oa.dao.EmployeeDao;
import pers.hyu.oa.dao.ReimbursementFormDao;
import pers.hyu.oa.dao.ReimbursementFormDetailDao;
import pers.hyu.oa.dao.ReimbursementFormRecordDao;
import pers.hyu.oa.entity.Employee;
import pers.hyu.oa.entity.ReimbursementForm;
import pers.hyu.oa.entity.ReimbursementFormDetail;
import pers.hyu.oa.entity.ReimbursementFormRecord;
import pers.hyu.oa.global.infoenum.PositionEnum;
import pers.hyu.oa.global.infoenum.ProcessTypeEnum;
import pers.hyu.oa.global.infoenum.ReimbursementLevelEnum;
import pers.hyu.oa.global.infoenum.StatusEnum;
import pers.hyu.oa.service.ReimbursementFormService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service("reimbursementFormService")
public class ReimbursementFormServiceImpl implements ReimbursementFormService {
    @Resource(name = "reimbursementFormDao")
    private ReimbursementFormDao reimbursementFormDao;
    @Resource(name = "reimbursementFormDetailDao")
    private ReimbursementFormDetailDao reimbursementFormDetailDao;
    @Resource(name = "reimbursementFormRecordDao")
    private ReimbursementFormRecordDao reimbursementFormRecordDao;
    @Resource(name = "employeeDao")
    private EmployeeDao employeeDao;


    /**
     * Create the reimbursement form
     *
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
     *
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
     *
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
     *
     * @param applicantSn The applicant's sn
     * @return the list of the form
     */
    public List<ReimbursementForm> getByApplicant(String applicantSn) {
        return reimbursementFormDao.selectByApplicant(applicantSn);
    }

    /**
     * Get all the forms that the approver needs to be handle
     *
     * @param approverSn The approver's sn
     * @return the list of the form
     */
    public List<ReimbursementForm> getByApprover(String approverSn) {
        return reimbursementFormDao.selectByApprover(approverSn);
    }

    /**
     * edit the reimbursement form
     *
     * @param reimbursementForm
     */
    public void edit(ReimbursementForm reimbursementForm) {
        reimbursementForm.setApproverSn(reimbursementForm.getApplicantSn());
        reimbursementForm.setStatus(StatusEnum.CREATED.getStatus());
        reimbursementFormDao.update(reimbursementForm);

        // Get the list of old details
        List<ReimbursementFormDetail> oldDetailList = reimbursementFormDetailDao.selectByReimbursementForm(reimbursementForm.getId());
        for (ReimbursementFormDetail oldItem : oldDetailList) {

            // check if the old expense item exists in the new expense item list
            boolean exists = false;
            for (ReimbursementFormDetail newItem : reimbursementForm.getReimbursementFormDetailList()) {
                if (oldItem.getId() == newItem.getId()) {
                    exists = true;
                    break;
                }
            }

            // if the old one do not exist in the new list, then delete the old one
            if (!exists) {
                reimbursementFormDetailDao.delete(oldItem.getId());
            }
        }

        // compare to the edited detail between old and new items
        for (ReimbursementFormDetail newItem : reimbursementForm.getReimbursementFormDetailList()) {

            // if the new item has the id, it means that this item is already in the db; update it
            if (newItem.getId() != null) {
                reimbursementFormDetailDao.update(newItem);
            } else {

                //it is a new item, add it to the db
                newItem.setReimbursementFormId(reimbursementForm.getId());
                reimbursementFormDetailDao.insert(newItem);
            }
        }
    }

    /**
     * submit the form, according to the applicant's position and dept,
     * after the form submit, it will forward to the approver to handle the form
     * and will record the action to the db
     *
     * @param formId
     */
    public void submit(int formId) {
        ReimbursementForm form = reimbursementFormDao.selectById(formId);
        Employee employee = employeeDao.selectBySn(form.getApplicantSn());

        //update the status of the form
        form.setStatus(StatusEnum.SUBMITTED.getStatus());

        // set the approver according to the applicant's position
        PositionEnum applicantPosition = PositionEnum.valueOf(employee.getPosition());
        String approverPosition;
        int approverDeptId;
        switch (applicantPosition) {

            // if the applicant is the DM or the GM Assistant, the GM will audit the form
            case GM_ASST:
            case DM:
                approverPosition = PositionEnum.GM.name();
                approverDeptId = 1001;
                break;

            // if the applicant is the GM, the Finical DM  will audit the form
            case GM:
                approverPosition = PositionEnum.DM.name();
                approverDeptId = 1002;
                break;

            // all the staff in the
            default:
                approverPosition = PositionEnum.DM.name();
                approverDeptId = employee.getDeptId();
        }
        form.setApproverSn(employeeDao.selectByDeptAndPosition(approverDeptId, approverPosition).get(0).getSn());
        reimbursementFormDao.update(form);

        //record the action to db
        ReimbursementFormRecord record = new ReimbursementFormRecord();
        record.setReimbursementFormId(formId);
        record.setApproverSn(form.getApplicantSn());
        record.setHandleDate(new Date());
        record.setRemark("N/A");
        record.setProcessType(ProcessTypeEnum.SUBMIT.name());
        record.setResult(StatusEnum.SUBMITTED.getStatus());

        reimbursementFormRecordDao.insert(record);
    }


    /**
     * accord to the total cost and the applicant and the approver's position to audit the form
     * @param record
     */
    public void audit(ReimbursementFormRecord record) {
        ReimbursementForm form = reimbursementFormDao.selectById(record.getReimbursementFormId());
        ProcessTypeEnum processType = ProcessTypeEnum.valueOf(record.getProcessType());
        Employee approver = employeeDao.selectBySn(record.getApproverSn());

        boolean isGM = form.getApplicant().getPosition().equals(PositionEnum.GM.name());
        boolean isApproverFDM = approver.getPosition().equals(PositionEnum.DM.name()) && approver.getDeptId() == 1002;
        boolean isApproverGM = approver.getPosition().equals(PositionEnum.GM.name()) && approver.getDeptId() == 1001;
        boolean isLessDMLimit = form.getTotalAmount()<= ReimbursementLevelEnum.DM_LIMIT.getLimit();
        boolean isLessFDMLimit = form.getTotalAmount()<=ReimbursementLevelEnum.FIN_DM_LIMIT.getLimit();

        switch (processType) {
            // the form be passed
            case PASS:
                // if the total cost is not over the DM limit or the applicant is the GM will be approved
                if (isLessDMLimit || isGM || isApproverGM || (isApproverFDM&&isLessFDMLimit)) {
                    form.setStatus(StatusEnum.APPROVED.getStatus());

                    //send to the passed form to the auditor to get paid
                    form.setApproverSn(getRandomEmpSn(1002, PositionEnum.AUD.name()));

                    record.setResult(StatusEnum.APPROVED.getStatus());

                    //if the total cost is over the limit for the DM but under the Finical DM, send it to FDM to recheck
                } else if (isLessFDMLimit ) {
                    form.setStatus(StatusEnum.RECHECK.getStatus());
                    form.setApproverSn(getRandomEmpSn(1002, PositionEnum.DM.name()));

                    record.setResult(StatusEnum.RECHECK.getStatus());

                    //if the total cost is over the limit for the FDM send it to GM
                } else {
                    form.setStatus(StatusEnum.RECHECK.getStatus());
                    form.setApproverSn(getRandomEmpSn(1001, PositionEnum.GM.name()));
                    record.setResult(StatusEnum.RECHECK.getStatus());
                }
                break;

            // the form is send back to the applicant for review
            case RETURN:
                form.setStatus(StatusEnum.ROLLED_BACK.getStatus());
                form.setApproverSn(form.getApplicantSn());

                record.setResult(StatusEnum.ROLLED_BACK.getStatus());
                break;

            // reject the form
            case REJECT:
                form.setStatus(StatusEnum.TERMINATED.getStatus());
                form.setApproverSn(null);
                record.setResult(StatusEnum.TERMINATED.getStatus());
                break;

            // pay the payment of the form
            case PAY:
                form.setStatus(StatusEnum.PAID.getStatus());
                form.setApproverSn(null);
                record.setResult(StatusEnum.PAID.getStatus());
                break;
        }

        reimbursementFormDao.update(form);

        record.setHandleDate(new Date());
        reimbursementFormRecordDao.insert(record);

    }


    //used for send the form to the different approver to handle the form
    private String getRandomEmpSn(int deptId, String position){
        List<Employee> employeeList = employeeDao.selectByDeptAndPosition(deptId, position);
        int i = new Random().nextInt(employeeList.size());
        return employeeList.get(i).getSn();
    }
}
