package pers.hyu.oa.service.impl;

import org.springframework.stereotype.Service;
import pers.hyu.oa.dao.EmployeeDao;
import pers.hyu.oa.entity.Employee;
import pers.hyu.oa.service.GlobalService;

import javax.annotation.Resource;

@Service("globalService")
public class GlobalServiceImpl implements GlobalService {
    @Resource(name = "employeeDao")
    private EmployeeDao employeeDao;

    public Employee login(String sn, String password) {
        Employee employee = employeeDao.selectBySn(sn);
        if(employee != null && employee.getPassword().equals(password) ){
            return employee;
        }
        return null;
    }

    public void changePassword(Employee employee, String password) {
        employee.setPassword(password);
        employeeDao.update(employee);
    }
}
