package com.ignovate.web.rest;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ignovate.service.EmployeeDetailService;
import com.ignovate.domain.EmployeeDetailEntity;

@RestController
@RequestMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeDetailController {
	private static final Logger log = LoggerFactory.getLogger(EmployeeDetailController.class);
	   
	@Autowired
	private EmployeeDetailService employeeDetailService;
	
	@PostMapping("register")
	public ResponseEntity<EmployeeDetailEntity> addEmployeeDetail(@RequestBody EmployeeDetailEntity employeeDetail) {
		return new ResponseEntity<EmployeeDetailEntity>(employeeDetailService.addEmployeeDetail(employeeDetail), HttpStatus.OK);
	}
	
	@GetMapping("employees")
	public ResponseEntity<List<EmployeeDetailEntity>> getEmployeeDetail() {
		return new ResponseEntity<List<EmployeeDetailEntity>>(employeeDetailService.getEmployeeDetails(), HttpStatus.OK);
	}
	
	@GetMapping("employees/{id}")
	public ResponseEntity<EmployeeDetailEntity> getEmployeeDetail(@PathVariable Long id) {
		return new ResponseEntity<EmployeeDetailEntity>(employeeDetailService.getEmployeeDetail(id), HttpStatus.OK);
	}
	
	@PutMapping("employees/{id}")
	public ResponseEntity<EmployeeDetailEntity> updateEmployeeDetail(@RequestBody EmployeeDetailEntity logs, @PathVariable Long id){
		EmployeeDetailEntity oldData = employeeDetailService.getEmployeeDetail(id);
		if(oldData == null)
			return ResponseEntity.notFound().build();
			   logs.setId(id);
			   employeeDetailService.addEmployeeDetail(logs);
			   return new ResponseEntity<EmployeeDetailEntity>( employeeDetailService.getEmployeeDetail(id), HttpStatus.OK);		
	}
	
	@GetMapping("employees/filter")
	public ResponseEntity<List<EmployeeDetailEntity>> getUsersWithFilter(@RequestParam Map<String, String> params) {
		log.info("Inside Filter Function");
		return new ResponseEntity<List<EmployeeDetailEntity>>(employeeDetailService.getEmployeeDetailWithFilter(params), HttpStatus.OK);
	}
	
}
