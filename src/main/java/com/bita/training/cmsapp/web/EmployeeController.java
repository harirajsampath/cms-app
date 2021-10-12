package com.bita.training.cmsapp.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bita.training.cmsapp.model.Employee;
import com.bita.training.cmsapp.service.EmployeeService;

import ch.qos.logback.core.util.ContentTypeUtil;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired EmployeeService empSvc;
	
	@GetMapping(produces = "APPLICATION/JSON")
	public Page<Employee> getAllEmployees() {
		return empSvc.getPaginatedEmployees();
	}
	
	@GetMapping(produces = "APPLICATION/JSON", path = "/{id}")
	public Employee getEmployeeById(@PathVariable("id") Integer id) {
		return empSvc.getEmployee(id).get();
	}
}
