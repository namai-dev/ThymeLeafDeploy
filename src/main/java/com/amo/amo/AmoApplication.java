package com.amo.amo;

import com.amo.amo.employee.Employee;
import com.amo.amo.employee.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AmoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmoApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(EmployeeService employeeService){
		Employee employee = new Employee("Harmony Namai","namai@gmail.com",254712547896L);
		Employee employee2 = new Employee("Ivan Kingsley","ivan@gmail.com",254712547896L);
		Employee employee3 = new Employee("Maurise Clock","maurise@gmail.com",254712547896L);
		Employee employee4 = new Employee("Lisen Swappy","lisen@gmail.com",254712547896L);
		Employee employee5 = new Employee("Willy Bamford","willy@gmail.com",254712547896L);
		return args -> {
			employeeService.addEmployee(employee);
			employeeService.addEmployee(employee2);
			employeeService.addEmployee(employee3);
			employeeService.addEmployee(employee4);
			employeeService.addEmployee(employee5);

		};
	}



}
