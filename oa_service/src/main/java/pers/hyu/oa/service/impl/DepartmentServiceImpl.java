package pers.hyu.oa.service.impl;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.springframework.stereotype.Service;
import pers.hyu.oa.dao.DepartmentDao;
import pers.hyu.oa.entity.Department;
import pers.hyu.oa.service.DepartmentService;

import javax.annotation.Resource;
import java.util.List;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
    @Resource(name = "departmentDao")
    private DepartmentDao departmentDao;

    /**
     * Add one department into the database
     *
     * @param department
     * @return the error message if the id or the name of the dept is duplicated
     */
    public String add(Department department) {
        try {
            departmentDao.insert(department);
            return null;
        } catch (org.springframework.dao.DuplicateKeyException e) {
            return e.getCause().getMessage();
        }
    }

    /***
     * Remove one dept from db by the id of dept
     * @param id which dept needs to be deleted
     * @return the error message if there is exception
     */
    public String removeOne(int id) {
        try {
            departmentDao.deleteById(id);
            return null;
        } catch (Exception e) {
            return e.getCause().getMessage();

        }
    }

    /***
     * Delete the departments according to the their ids
     * @param idList contains all ids that department needs to be deleted
     * @return the error message of exception
     */
    public String removeMulti(List<Integer> idList) {
        try {
            departmentDao.deleteMulti(idList);
            return null;
        } catch (Exception e) {
            return e.getCause().getMessage();
        }
    }


    /**
     * Update the department
     *
     * @param department
     * @return the error message when there is a id or name duplicate
     */
    public String edit(Department department) {
        try {
            departmentDao.update(department);
            return null;
        } catch (org.springframework.dao.DuplicateKeyException e) {
            return e.getCause().getMessage();
        }
    }

    public Department getById(int id) {
        return departmentDao.selectById(id);
    }

    public List<Department> getAll() {
        return departmentDao.selectAll();
    }

}
