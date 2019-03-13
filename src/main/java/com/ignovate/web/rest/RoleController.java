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

import com.ignovate.domain.RoleEntity;
import com.ignovate.service.RoleService;

/**
 * @author Suryanand
 *
 */
@RestController
@RequestMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class RoleController {
	private static final Logger log = LoggerFactory.getLogger(RoleController.class);
	
	@Autowired
	private RoleService roleService;
	
	@PostMapping("roles")
	public ResponseEntity<RoleEntity> addRoleDetail(@RequestBody RoleEntity RoleDetail) {
		return new ResponseEntity<RoleEntity>(roleService.addRole(RoleDetail), HttpStatus.OK);
	}
	
	@GetMapping("roles")
	public ResponseEntity<List<RoleEntity>> getRoleDetail() {
		return new ResponseEntity<List<RoleEntity>>(roleService.getRoleDetails(), HttpStatus.OK);
	}
	
	@GetMapping("roles/{id}")
	public ResponseEntity<RoleEntity> getRoleDetail(@PathVariable Long id) {
		return new ResponseEntity<RoleEntity>(roleService.getRoleDetail(id), HttpStatus.OK);
	}
	
	@PutMapping("roles/{id}")
	public ResponseEntity<RoleEntity> updateRoleDetail(@RequestBody RoleEntity logs, @PathVariable Long id){
		RoleEntity oldData = roleService.getRoleDetail(id);
		if(oldData == null)
			return ResponseEntity.notFound().build();
			   logs.setId(id);
			   roleService.addRole(logs);
			   return new ResponseEntity<RoleEntity>( roleService.getRoleDetail(id), HttpStatus.OK);		
	}
	
	@GetMapping("roles/filter")
	public ResponseEntity<List<RoleEntity>> getRolesWithFilter(@RequestParam Map<String, String> params) {
		log.info("Inside Filter Function");
		return new ResponseEntity<List<RoleEntity>>(roleService.getRoleDetailWithFilter(params), HttpStatus.OK);
	}
}
