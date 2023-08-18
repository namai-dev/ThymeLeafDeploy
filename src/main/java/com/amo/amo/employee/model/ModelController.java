package com.amo.amo.employee.model;

import com.amo.amo.employee.Employee;
import com.amo.amo.employee.EmployeeRepo;
import com.amo.amo.employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ModelController {
    private final EmployeeService employeeService;
    private final EmployeeRepo employeeRepo;

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


    @GetMapping("/updateEmployeeForm")
    public ModelAndView updateEmployee(@RequestParam Long employeeId){
        ModelAndView view = new ModelAndView("update-form");
        Employee employee = employeeRepo.findById(employeeId).get();
        view.addObject("employee", employee);
        return view;
    }
}
