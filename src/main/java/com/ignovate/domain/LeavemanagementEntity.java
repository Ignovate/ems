package com.ignovate.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;


@Entity
@Table(name = "leave_management")
@DynamicUpdate(true)
public class LeavemanagementEntity {
	

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "leave_id")
	private Long leaveid;
	
	public Long getLeaveid() {
		return leaveid;
	}

	public void setLeaveid(Long leaveid) {
		this.leaveid = leaveid;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getApprovedby() {
		return approvedby;
	}

	public void setApprovedby(String approvedby) {
		this.approvedby = approvedby;
	}

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}
	@Column(name = "employee_id")
	private String empId;
	
	
	@Column(name = "start_date")
	private String startdate;


    
	@Column(name = "end_date")
	private String enddate;
	


	
	@Column(name = "reason")
	private String reason;
	
	@Column(name = "comment")
		private String comment;


	@Column(name = "status")
	private String status;
	
	@Column(name = "approved_by")
	private String approvedby;
	
	@Column(name = "log")
	private String log;
	
	
	

}
