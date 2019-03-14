/**
 * 
 */
package com.ignovate.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ignovate.common.IgnovateException;
import com.ignovate.domain.EmployeeDetailEntity;
import com.ignovate.service.EmployeeDetailService;
import com.ignovate.web.rest.vm.LoginRequestVM;
import com.ignovate.common.ErrorCodes;
/**
 * @author Suryanand
 *
 */
@RestController
@RequestMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class LoginController {
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private EmployeeDetailService employeeDetailService;
	
	@PostMapping("login")
	public ResponseEntity<EmployeeDetailEntity> addUser(@RequestBody LoginRequestVM loginReq) throws IgnovateException {
		EmployeeDetailEntity userEntity = employeeDetailService.login(loginReq);
		if(userEntity == null)
			throw new IgnovateException(ErrorCodes.CODE_NO_DATA, ErrorCodes.MSG_NO_DATA);

		return new ResponseEntity<EmployeeDetailEntity>(userEntity, HttpStatus.OK);
	}
}
