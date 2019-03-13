/**
 * 
 */
package com.ignovate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

/**
 * @author Devops
 *
 */
@Entity
@Table(name = "task_assignment")
@DynamicUpdate(true)
public class TaskAssignEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "assign_id")
	private Long assign_id;
	@Column(name = "task_id")
	private Long task_id;
	@Column(name = "employee_id")
	private String employee_id;
	@Column(name = "assigned_date")
	private String assigned_date;
	@Column(name = "status")
	private String status;
	@Column(name = "comments")
	private String comments;
	@Column(name = "completed_date")
	private String completed_date;
	@Column(name = "effort")
	private float effort;
	@Column(name = "log")
	private String log;
	public Long getAssign_id() {
		return assign_id;
	}
	public void setAssign_id(Long assign_id) {
		this.assign_id = assign_id;
	}
	public Long getTask_id() {
		return task_id;
	}
	public void setTask_id(Long task_id) {
		this.task_id = task_id;
	}
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public String getAssigned_date() {
		return assigned_date;
	}
	public void setAssigned_date(String assigned_date) {
		this.assigned_date = assigned_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getCompleted_date() {
		return completed_date;
	}
	public void setCompleted_date(String completed_date) {
		this.completed_date = completed_date;
	}
	public float getEffort() {
		return effort;
	}
	public void setEffort(float effort) {
		this.effort = effort;
	}
	public String getLog() {
		return log;
	}
	public void setLog(String log) {
		this.log = log;
	}
	
}
