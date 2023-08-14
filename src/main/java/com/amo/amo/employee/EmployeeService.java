package com.amo.amo.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    public void addEmployee(Employee employee){
        employeeRepo.save(employee);
    }

    public List<Employee>employeeList(){
        return employeeRepo.findAll();
    }


    public void update(Long id){
        Employee employee = employeeRepo.findById(id).get();
    }
}
