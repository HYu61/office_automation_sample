package pers.hyu.oa.service;

import pers.hyu.oa.entity.Department;
import pers.hyu.oa.entity.Employee;

import java.util.List;

public interface EmployeeService {
    String add(Employee employee);
    String removeOne(String sn);
    String removeMulti(List<String> snList);
    String edit(Employee employee);
    Employee getBySn(String sn);
    List<Employee> getByDept(int deptId);
    List<Employee> getAll();
}
