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

import com.ignovate.service.AttendanceDetailService;
import com.ignovate.domain.AttendanceEntity;

@RestController
@RequestMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class AttendanceDetailController {
	private static final Logger log = LoggerFactory.getLogger(AttendanceDetailController.class);
	   
	@Autowired
	private AttendanceDetailService attendanceDetailService;
	
	@PostMapping("attendance")
	public ResponseEntity<AttendanceEntity> addAttendanceDetail(@RequestBody AttendanceEntity attendanceDetail) {
		return new ResponseEntity<AttendanceEntity>(attendanceDetailService.addAttendanceDetail(attendanceDetail), HttpStatus.OK);
	}
	
	@GetMapping("attendance")
	public ResponseEntity<List<AttendanceEntity>> getAttendanceDetail() {
		return new ResponseEntity<List<AttendanceEntity>>(attendanceDetailService.getAttendanceDetails(), HttpStatus.OK);
	}
	
	@GetMapping("attendance/{id}")
	public ResponseEntity<AttendanceEntity> getAttendanceDetail(@PathVariable Long id) {
		return new ResponseEntity<AttendanceEntity>(attendanceDetailService.getAttendanceDetail(id), HttpStatus.OK);
	}
	
	@PutMapping("attendance/{id}")
	public ResponseEntity<AttendanceEntity> updateAttendanceDetail(@RequestBody AttendanceEntity logs, @PathVariable Long id){
		AttendanceEntity oldData = attendanceDetailService.getAttendanceDetail(id);
		if(oldData == null)
			return ResponseEntity.notFound().build();
			   logs.setAttendanceid(id);
			  attendanceDetailService.addAttendanceDetail(logs);
			   return new ResponseEntity<AttendanceEntity>( attendanceDetailService.getAttendanceDetail(id), HttpStatus.OK);		
	}
	
	@GetMapping("attendance/filter")
	public ResponseEntity<List<AttendanceEntity>> getAttendanceWithFilter(@RequestParam Map<String, String> params) {
		log.info("Inside Filter Function");
		return new ResponseEntity<List<AttendanceEntity>>(attendanceDetailService.getAttendanceDetailWithFilter(params), HttpStatus.OK);
	}
	
}
