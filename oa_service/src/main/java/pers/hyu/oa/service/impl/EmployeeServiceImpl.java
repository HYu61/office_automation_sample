package pers.hyu.oa.service.impl;

import org.springframework.stereotype.Service;
import pers.hyu.oa.dao.EmployeeDao;
import pers.hyu.oa.entity.Employee;
import pers.hyu.oa.service.EmployeeService;

import javax.annotation.Resource;
import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Resource(name = "employeeDao")
    private EmployeeDao employeeDao;

    public String add(Employee employee) {
        employee.setPassword("000000");
        try {
            employeeDao.insert(employee);
            return null;
        } catch (org.springframework.dao.DuplicateKeyException e) {
            return e.getCause().getMessage();
        }
    }

    public String removeOne(String sn) {
        try {
            employeeDao.deleteBySn(sn);
            return null;
        } catch (Exception e) {
            return e.getCause().getMessage();
        }
    }

    public String removeMulti(List<String> snList) {
        try {
            employeeDao.deleteMulti(snList);
            return null;
        } catch (Exception e) {
            return e.getCause().getMessage();
        }
    }

    public String edit(Employee employee) {
        try {
            employeeDao.update(employee);
            return null;
        } catch (org.springframework.dao.DuplicateKeyException e) {
            return e.getCause().getMessage();
        }
    }

    public Employee getBySn(String sn) {
        return employeeDao.selectBySn(sn);
    }

    public List<Employee> getByDept(int deptId) {
        return employeeDao.selectByDept(deptId);
    }

    public List<Employee> getAll() {
        return employeeDao.selectAll();
    }
}
