package pers.hyu.oa.dao;

import org.springframework.stereotype.Repository;
import pers.hyu.oa.entity.Department;

import java.util.List;

/***
 * CRUD for department
 */
@Repository("departmentDao")
public interface DepartmentDao {
    void insert(Department dept);
    void deleteById(int id);
    // Delete multi entries according to the id of the department
    void deleteMulti(List<Integer> idList);
    void update(Department dept);
    Department selectById(int id);
    List<Department> selectAll();
}
