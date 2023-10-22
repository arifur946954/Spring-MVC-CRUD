package com.MVCCRUD.MVC.service;

import com.MVCCRUD.MVC.dao.EmployeeRepository;
import com.MVCCRUD.MVC.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeServiceImp implements EmployeeService{
    private EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void save(Employee theEmployee) {
        employeeRepository.save(theEmployee);

    }

    @Override
    public Employee findByID(int theID) {
        //here the value of result is null or another valule thats wht we are uding to optional
        Optional <Employee>  result=  employeeRepository.findById(theID);
      Employee theEmployee=null;
      if (result.isPresent()){
          //.get is a method call of ooptional object;
          theEmployee=result.get();

      }else {
          throw new RuntimeException("Did not find employee id - " + theID);
      }
        return theEmployee;
    }

    @Override
    public List<Employee> findAll() {
//     List<Employee> theEmployee=   employeeRepository.findAll();
//        return theEmployee;
        return employeeRepository.findAll();
    }

    @Override
    public void deleteById(int theId) {

        employeeRepository.deleteById(theId);

    }
}
