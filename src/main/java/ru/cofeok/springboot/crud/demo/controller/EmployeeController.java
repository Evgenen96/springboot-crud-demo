package ru.cofeok.springboot.crud.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.cofeok.springboot.crud.demo.entity.Employee;
import ru.cofeok.springboot.crud.demo.service.EmployeeService;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping("/list")
    public String getEmployees(Model theModel) {
        List<Employee> employees = employeeService.findAll();
        theModel.addAttribute("employees", employees);
        return "employees/employee-list";
    }

    @GetMapping("/showFormAdd")
    public String showFormAdd(Model theModel) {
        Employee theEmployee = new Employee();
        theModel.addAttribute("employee", theEmployee);
        employeeService.save(theEmployee);
        return "employees/employee-form";
    }

    @GetMapping("/showFormUpdate")
    public String showFormUpdate(@RequestParam("employeeId") int theId, Model theModel) {
        Employee theEmployee = employeeService.findById(theId);
        theModel.addAttribute("employee", theEmployee);
        employeeService.save(theEmployee);
        return "employees/employee-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId) {
        employeeService.deleteById(theId);
        return "redirect:/employees/list";
    }
}
