/**
 * 
 */
package com.ignovate.web.rest.vm;

import java.time.LocalDateTime;

/**
 * @author Suryanand
 *
 */
public class LoginRequestVM {
	private String email;
	private String password;
	private String permission;
	private String status;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
