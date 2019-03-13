package com.ignovate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "project_assignment")
@DynamicUpdate(true)
public class ProjectAssignEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private Long projAssignId;
	
	@Column(name = "project_id")
	private Long projId;
	
	@Column(name = "employee_id")
	private String empId;
	
	@Column(name = "employee_role")
	private String empRole;
	
	@Column(name = "project_platform")
	private String platform;
	
	@Column(name = "project_assigned_date")
	private String assignedDate;
	
	@Column(name = "project_assigned_by")
	private String assigneBy;
	
	@Column(name = "project_status")
	private String status;
	
	@Column(name = "project_log")
	private String log;

	public Long getProjAssignId() {
		return projAssignId;
	}

	public void setProjAssignId(Long projAssignId) {
		this.projAssignId = projAssignId;
	}

	public Long getProjId() {
		return projId;
	}

	public void setProjId(Long projId) {
		this.projId = projId;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpRole() {
		return empRole;
	}

	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(String assignedDate) {
		this.assignedDate = assignedDate;
	}

	public String getAssigneBy() {
		return assigneBy;
	}

	public void setAssigneBy(String assigneBy) {
		this.assigneBy = assigneBy;
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
