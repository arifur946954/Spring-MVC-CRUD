package com.MVCCRUD.MVC.controller;

import com.MVCCRUD.MVC.entity.Employee;
import com.MVCCRUD.MVC.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employeeService;
     @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }



    @GetMapping("/list")
    public String listEmployees(Model theModel){
         List<Employee> theEmployees=employeeService.findAll();
        theModel.addAttribute("employees",theEmployees);
        return "employee/list-employees";

    }
    @GetMapping("/showFormForAdd")
    public String showFormAdd(Model theModel){
         Employee theEmployee=new Employee();
         theModel.addAttribute("employee" , theEmployee);
         return "employee/employee-form";
    }
@PostMapping("/save")
public String saveInfo(@ModelAttribute("employee") Employee theEmployee){

         employeeService.save(theEmployee);
         //use redirect for dupliocite submission
         return "redirect:/employee/list";

}
@GetMapping("/showFormForAddUpdated")
public String showFormForAddUpdated(@RequestParam("employeeId") int theId, Model theModel){
         //get the employee from services
       Employee theEmployee=  employeeService.findByID(theId);
    //set employee in the mocel
    theModel.addAttribute(theEmployee);
    //sent over to our form
    return "employee/employee-form";

}
@GetMapping("/showFormForAddDelete")
public String showDelete(@RequestParam("employeeId") int theId, Model theModel){
       employeeService.deleteById(theId);

    return "redirect:/employee/list";

}



}
