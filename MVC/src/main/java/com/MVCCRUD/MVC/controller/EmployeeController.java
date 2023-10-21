package com.MVCCRUD.MVC.controller;

import com.MVCCRUD.MVC.entity.Employee;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private List<Employee> theEmployees;
    @PostConstruct
    private void loadData(){
        // create employees
        Employee emp1 = new Employee(1,"Leslie", "Andrews", "leslie@luv2code.com");
        Employee emp2 = new Employee(2,"Emma", "Baumgarten", "emma@luv2code.com");
        Employee emp3 = new Employee(3,"Avani", "Gupta", "avani@luv2code.com");
        Employee emp4 = new Employee(4,"Arifur", "rahman", "arif@luv2code.com");


        // create the list
        theEmployees= new ArrayList<>();


        // add to the list
        theEmployees.add(emp1);
        theEmployees.add(emp2);
        theEmployees.add(emp3);
        theEmployees.add(emp4);

    }
    @GetMapping("/list")
    public String listEmployees(Model theModel){
        theModel.addAttribute("employees",theEmployees);
        return "list-employees";

    }




}
