package com.ignovate.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ignovate.web.rest.vm.ResponseVm;

@RestControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(IgnovateException.class)
	public ResponseEntity<ResponseVm> notFoundException(final IgnovateException e) {
		return new ResponseEntity<ResponseVm>(ResponseVm.getErrorVm(e), HttpStatus.OK);
	}

}
