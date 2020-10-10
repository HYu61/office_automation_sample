package pers.hyu.oa.service;

import pers.hyu.oa.entity.Department;

import java.util.List;

public interface DepartmentService {
    String add(Department department);
    String removeOne(int id);
    String removeMulti(List<Integer> idList);
    String edit(Department department);
    Department getById(int id);
    List<Department> getAll();

}
