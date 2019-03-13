/**
 * 
 */
package com.ignovate.web.rest;

import java.util.List;
import java.util.Map;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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

import com.ignovate.domain.TaskAssignEntity;
import com.ignovate.domain.TaskListEntity;
import com.ignovate.service.TaskAssignService;
import com.ignovate.service.TaskListService;

/**
 * @author Suryanand
 *
 */
@RestController
@RequestMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class TaskAssignController {
	private static final Logger log = LoggerFactory.getLogger(TaskAssignController.class);
	@ManyToOne
	@JoinColumn(name="task_id", nullable=false)
	private TaskListEntity tasklist;
	
	@Autowired
	private TaskAssignService taskAssignService;
	@Autowired
	private TaskListService taskListService;
	@PostMapping("taskassign")
	public ResponseEntity<TaskAssignEntity> addTaskAssignDetail(@RequestBody TaskAssignEntity TaskAssingDetail) {
		return new ResponseEntity<TaskAssignEntity>(taskAssignService.addTaskAssign(TaskAssingDetail), HttpStatus.OK);
	}
	
	@GetMapping("taskassign")
	public ResponseEntity<List<TaskAssignEntity>> getTaskAssignDetail() {
		return new ResponseEntity<List<TaskAssignEntity>>(taskAssignService.getTaskAssignDetails(), HttpStatus.OK);
	}
	
	@GetMapping("taskassign/{id}")
	public ResponseEntity<TaskAssignEntity> getTaskAssignDetail(@PathVariable Long id) {
		return new ResponseEntity<TaskAssignEntity>(taskAssignService.getTaskAssignDetail(id), HttpStatus.OK);
	}
	
	@PutMapping("taskassign/{id}")
	public ResponseEntity<TaskAssignEntity> updateTaskAssignDetail(@RequestBody TaskAssignEntity logs, @PathVariable Long id){
		TaskAssignEntity oldData = taskAssignService.getTaskAssignDetail(id);
		if(oldData == null)
			return ResponseEntity.notFound().build();
			   logs.setAssign_id(id);
			   taskAssignService.addTaskAssign(logs);
			   return new ResponseEntity<TaskAssignEntity>( taskAssignService.getTaskAssignDetail(id), HttpStatus.OK);		
	}
	
	@GetMapping("taskassign/filter")
	public ResponseEntity<List<TaskAssignEntity>> getTaskAssignWithFilter(@RequestParam Map<String, String> params) {
		log.info("Inside Filter Function");
		return new ResponseEntity<List<TaskAssignEntity>>(taskAssignService.getTaskAssignWithFilter(params), HttpStatus.OK);
	}
}
