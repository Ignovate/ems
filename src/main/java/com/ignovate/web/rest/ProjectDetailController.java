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

import com.ignovate.service.ProjectDetailService;
import com.ignovate.domain.ProjectDetailEntity;

@RestController
@RequestMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class ProjectDetailController {
	private static final Logger log = LoggerFactory.getLogger(ProjectDetailController.class);
	   
	@Autowired
	private ProjectDetailService projectDetailService;
	
	@PostMapping("projects")
	public ResponseEntity<ProjectDetailEntity> addProjectDetail(@RequestBody ProjectDetailEntity projectDetail) {
		return new ResponseEntity<ProjectDetailEntity>(projectDetailService.addProjectDetail(projectDetail), HttpStatus.OK);
	}
	
	@GetMapping("projects")
	public ResponseEntity<List<ProjectDetailEntity>> getProjectDetails() {
		return new ResponseEntity<List<ProjectDetailEntity>>(projectDetailService.getProjectDetails(), HttpStatus.OK);
	}
	
	@GetMapping("projects/{id}")
	public ResponseEntity<ProjectDetailEntity> getProjectDetail(@PathVariable Long id) {
		return new ResponseEntity<ProjectDetailEntity>(projectDetailService.getProjectDetail(id), HttpStatus.OK);
	}
	
	@PutMapping("projects/{id}")
	public ResponseEntity<ProjectDetailEntity> updateProjectDetail(@RequestBody ProjectDetailEntity projectDetail, @PathVariable Long id){
		ProjectDetailEntity oldData = projectDetailService.getProjectDetail(id);
		if(oldData == null)
			return ResponseEntity.notFound().build();
			   projectDetail.setProjId(id);
			   projectDetailService.addProjectDetail(projectDetail);
			   return new ResponseEntity<ProjectDetailEntity>( projectDetailService.getProjectDetail(id), HttpStatus.OK);		
	}
	
	@GetMapping("projects/filter")
	public ResponseEntity<List<ProjectDetailEntity>> getProjectDetailFilter(@RequestParam Map<String, String> params) {
		log.info("Inside Filter Function");
		return new ResponseEntity<List<ProjectDetailEntity>>(projectDetailService.getProjectDetailFilter(params), HttpStatus.OK);
	}
	
}
