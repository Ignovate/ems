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

import com.ignovate.service.LeaveDetailService;
import com.ignovate.domain.LeavemanagementEntity;

@RestController
@RequestMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class LeaveDetailController {
	private static final Logger log = LoggerFactory.getLogger(LeaveDetailController.class);
	   
	@Autowired
	private LeaveDetailService leaveDetailService;
	
	@PostMapping("leavedetails")
	public ResponseEntity<LeavemanagementEntity> addLeaveDetail(@RequestBody LeavemanagementEntity leaveDetail) {
		return new ResponseEntity<LeavemanagementEntity>(leaveDetailService.addLeaveDetail(leaveDetail), HttpStatus.OK);
	}
	
	@GetMapping("leavedetails")
	public ResponseEntity<List<LeavemanagementEntity>> getLeaveDetail() {
		return new ResponseEntity<List<LeavemanagementEntity>>(leaveDetailService.getLeaveDetails(), HttpStatus.OK);
	}
	
	@GetMapping("leavedetails/{id}")
	public ResponseEntity<LeavemanagementEntity> getLeaveDetail(@PathVariable Long id) {
		return new ResponseEntity<LeavemanagementEntity>(leaveDetailService.getLeaveDetail(id), HttpStatus.OK);
	}
	
	@PutMapping("leavedetails/{id}")
	public ResponseEntity<LeavemanagementEntity> updateLeaveDetail(@RequestBody LeavemanagementEntity logs, @PathVariable Long id){
		LeavemanagementEntity oldData = leaveDetailService.getLeaveDetail(id);
		if(oldData == null)
			return ResponseEntity.notFound().build();
			   logs.setLeaveid(id);
			   leaveDetailService.addLeaveDetail(logs);
			   return new ResponseEntity<LeavemanagementEntity>( leaveDetailService.getLeaveDetail(id), HttpStatus.OK);		
	}
	
	@GetMapping("leavedetails/filter")
	public ResponseEntity<List<LeavemanagementEntity>> getLeaveWithFilter(@RequestParam Map<String, String> params) {
		log.info("Inside Filter Function");
		return new ResponseEntity<List<LeavemanagementEntity>>(leaveDetailService.getLeaveDetailWithFilter(params), HttpStatus.OK);
	}
	
}
