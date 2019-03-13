/**
 * 
 */
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

import com.ignovate.domain.TaskListEntity;
import com.ignovate.service.TaskListService;

/**
 * @author Suryanand
 *
 */
@RestController
@RequestMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class TaskListController {
	private static final Logger log = LoggerFactory.getLogger(TaskListController.class);
	@Autowired
	private TaskListService taskListService;
	@PostMapping("taskList")
	public ResponseEntity<TaskListEntity> addTaskListDetail(@RequestBody TaskListEntity TaskListDetail) {
		return new ResponseEntity<TaskListEntity>(taskListService.addTaskList(TaskListDetail), HttpStatus.OK);
	}
	
	@GetMapping("taskList")
	public ResponseEntity<List<TaskListEntity>> getTaskListDetail() {
		log.info("Inside Get TaskList");
		return new ResponseEntity<List<TaskListEntity>>(taskListService.getTaskListDetails(), HttpStatus.OK);
	}
	
	@GetMapping("taskList/{id}")
	public ResponseEntity<TaskListEntity> getTaskListDetail(@PathVariable Long id) {
		return new ResponseEntity<TaskListEntity>(taskListService.getTaskListDetail(id), HttpStatus.OK);
	}
	
	@PutMapping("taskList/{id}")
	public ResponseEntity<TaskListEntity> updateTaskListDetail(@RequestBody TaskListEntity logs, @PathVariable Long id){
		TaskListEntity oldData = taskListService.getTaskListDetail(id);
		if(oldData == null)
			return ResponseEntity.notFound().build();
			   logs.setId(id);
			   taskListService.addTaskList(logs);
			   return new ResponseEntity<TaskListEntity>( taskListService.getTaskListDetail(id), HttpStatus.OK);		
	}
	
	@GetMapping("taskList/filter")
	public ResponseEntity<List<TaskListEntity>> getTaskListWithFilter(@RequestParam Map<String, String> params) {
		log.info("Inside Filter Function");
		return new ResponseEntity<List<TaskListEntity>>(taskListService.getTaskListWithFilter(params), HttpStatus.OK);
	}
}
