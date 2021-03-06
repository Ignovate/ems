package com.ignovate.web.rest.vm;

import com.ignovate.common.Constants;
import com.ignovate.common.IgnovateException;

public class ResponseVm {

	private String code;
	private String message;

	public ResponseVm(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public static ResponseVm getSuccessVm()
	{
		return new ResponseVm(Constants.SUCCESS, Constants.SUCCESS);
	}
	public static ResponseVm getFailureVm()
	{
		return new ResponseVm(Constants.FAILURE, Constants.FAILURE);
	}
	public static ResponseVm getErrorVm(IgnovateException e)
	{
		return new ResponseVm(e.getCode(), e.getMessage());
	}

}
