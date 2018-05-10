package com.ais.oauth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ais.oauth.model.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
	
	@GetMapping(produces="application/json")
	public Employee getEmployee() {
		Employee e = new Employee();
		e.setId((long) 1);
		e.setName("John");
		e.setAge(27);
		
		return e;
	}
}
