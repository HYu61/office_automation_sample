package pers.hyu.oa.service;

import pers.hyu.oa.entity.Employee;

public interface GlobalService {
    Employee login(String sn, String password);
    void changePassword(Employee employee, String password);
}
