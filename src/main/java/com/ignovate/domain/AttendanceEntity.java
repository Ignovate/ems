package com.ignovate.domain;



import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "attendance_management")
@DynamicUpdate(true)
public class AttendanceEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "attendance_id")
	private Long attendanceid;
	@Column(name = "employee_id")
	private String empId;
	@Column(name = "date")
	private String date;
	@Column(name = "status")
	private String status;
	@Column(name = "created_date")
	private String createdDate;
	@Column(name = "approved_by")
	private String approvedBy;
	@Column(name = "log")
	private String log;
	public Long getAttendanceid() {
		return attendanceid;
	}
	public void setAttendanceid(Long attendanceid) {
		this.attendanceid = attendanceid;
	}
	
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getApprovedBy() {
		return approvedBy;
	}
	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLog() {
		return log;
	}
	public void setLog(String log) {
		this.log = log;
	}
	
}
