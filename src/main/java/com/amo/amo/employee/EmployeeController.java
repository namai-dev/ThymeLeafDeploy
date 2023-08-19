package com.amo.amo.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping(path = "/addEmployee")
    private String addEmployee(@ModelAttribute Employee employee){

        employeeService.addEmployee(employee);
        return "redirect:/";
    }

    @GetMapping(path = "/listEmployee")
    private List<Employee>employeeList(){
        return employeeService.employeeList();
    }

    @GetMapping(path = "/deleteEmployee")
    private String deleteEmployee(@RequestParam Long id){
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }

    // @GetMapping(path="/searchEmployees")
    // public void searchByEmail(@RequestParam String email){
    //     ModelAndView view = new ModelAndView("search-form");


    //    List<Employee>employees =  employeeService.searchByEmail(email);
    //    view.addObject("employees", employees);
    // }



}
