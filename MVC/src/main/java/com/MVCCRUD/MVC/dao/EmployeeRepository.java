package com.MVCCRUD.MVC.dao;

import com.MVCCRUD.MVC.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
