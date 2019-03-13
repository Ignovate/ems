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

import com.ignovate.service.ProjectAssignService;
import com.ignovate.domain.ProjectAssignEntity;

@RestController
@RequestMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class ProjectAssignController {
	private static final Logger log = LoggerFactory.getLogger(ProjectAssignController.class);
	   
	@Autowired
	private ProjectAssignService projectAssignService;
	
	@PostMapping("assignProjects")
	public ResponseEntity<ProjectAssignEntity> addProjectAssign(@RequestBody ProjectAssignEntity projectDetail) {
		return new ResponseEntity<ProjectAssignEntity>(projectAssignService.addProjectAssign(projectDetail), HttpStatus.OK);
	}
	
	@GetMapping("assignProjects")
	public ResponseEntity<List<ProjectAssignEntity>> getAssignedProjects() {
		return new ResponseEntity<List<ProjectAssignEntity>>(projectAssignService.getAssignedProjects(), HttpStatus.OK);
	}
	
	@GetMapping("assignProjects/{id}")
	public ResponseEntity<ProjectAssignEntity> getAssignedProject(@PathVariable Long id) {
		return new ResponseEntity<ProjectAssignEntity>(projectAssignService.getAssignedProject(id), HttpStatus.OK);
	}
	
	@PutMapping("assignProjects/{id}")
	public ResponseEntity<ProjectAssignEntity> updateAssignedProject(@RequestBody ProjectAssignEntity projectDetail, @PathVariable Long id){
		ProjectAssignEntity oldData = projectAssignService.getAssignedProject(id);
		if(oldData == null)
			return ResponseEntity.notFound().build();
			   projectDetail.setProjAssignId(id);
			   projectAssignService.addProjectAssign(projectDetail);
			   return new ResponseEntity<ProjectAssignEntity>( projectAssignService.getAssignedProject(id), HttpStatus.OK);		
	}
	
	@GetMapping("assignProjects/filter")
	public ResponseEntity<List<ProjectAssignEntity>> getAssignedProjectsFilter(@RequestParam Map<String, String> params) {
		log.info("Inside Filter Function");
		return new ResponseEntity<List<ProjectAssignEntity>>(projectAssignService.getAssignedProjectsFilter(params), HttpStatus.OK);
	}
	
}
