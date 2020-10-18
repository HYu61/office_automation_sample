package pers.hyu.oa.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import pers.hyu.oa.entity.Department;
import pers.hyu.oa.entity.Employee;

import java.util.List;

/***
 * CRUD for departments
 */
@Repository("employeeDao")
public interface EmployeeDao {
    void insert(Employee employee);
    void deleteBySn(String sn);

    // Delete multi entries according to the id of the department
    void deleteMulti(List<String> snList);
    void update(Employee employee);
    Employee selectBySn(String sn);
    List<Employee> selectByDept(int deptId);
    List<Employee> selectAll();
    Employee selectBySnForRecord(String sn);
    List<Employee> selectByDeptAndPosition(@Param("deptId")int deptId, @Param("position")String position);

}
