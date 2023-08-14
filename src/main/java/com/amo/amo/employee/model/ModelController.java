package com.amo.amo.employee.model;

import com.amo.amo.employee.Employee;
import com.amo.amo.employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ModelController {
    private final EmployeeService employeeService;

    @GetMapping({"/", "/listEmployee"})
    public ModelAndView modelAndView(){
        ModelAndView view = new ModelAndView("listEmployee");
       List<Employee>employeeList = employeeService.employeeList();
       view.addObject("employees", employeeList);
        return view;
    }


    @GetMapping(path = "/addEmployeeForm")
    public ModelAndView addEmployee(){
        ModelAndView view = new ModelAndView("addEmployee");
        Employee newEmployee = new Employee();
        view.addObject("employee", newEmployee);
        return view;
    }
}
