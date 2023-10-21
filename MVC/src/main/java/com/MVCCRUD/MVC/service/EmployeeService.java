package com.MVCCRUD.MVC.service;

import com.MVCCRUD.MVC.entity.Employee;

import java.util.List;

public interface EmployeeService {

    //save
    void save(Employee theEmployee);
    //findByid
    Employee findByID(int theID);
    //findbyall
    List<Employee> findAll();
    //delete
    void deleteById(int theId);

}
