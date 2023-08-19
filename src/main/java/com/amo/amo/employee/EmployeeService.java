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

    public void update(Long id, String name, String email, Long cotact){
         Employee employee = employeeRepo.findById(id).get();
        if(employee == null){
            throw new IllegalArgumentException("Emloyee not found");
        }
        employee.setContact(cotact);
        employee.setEmail(email);
        employee.setName(name);
    }

    public List<Employee>searchByEmail(String email){

        return employeeRepo.findAllByEmail(email);
    }


  

    public void deleteEmployee(Long id){
        Employee employee = employeeRepo.findById(id).get();
        if(employee == null){
            throw new IllegalArgumentException("User not found");
        }
        employeeRepo.deleteById(id);
    }
}
