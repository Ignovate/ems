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
 * @author Suryanand
 *
 */
@Entity
@Table(name = "task_list")
@DynamicUpdate(true)
public class TaskListEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "task_id")
	private Long id;
	@Column(name = "project_id")
	private Long project_id;
	@Column(name = "task_description")
	private String description;
	@Column(name = "estimated_date")
	private String estimatedDate;
	@Column(name = "estimated_hours")
	private float estimatedHours;
	@Column(name = "created_date")
	private String createdDate;
	@Column(name = "completed_date")
	private String completedDate;
	@Column(name = "status")
	private String status;
	@Column(name = "log")
	private String log;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getProject_id() {
		return project_id;
	}
	public void setProject_id(Long project_id) {
		this.project_id = project_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEstimatedDate() {
		return estimatedDate;
	}
	public void setEstimatedDate(String estimatedDate) {
		this.estimatedDate = estimatedDate;
	}
	public float getEstimatedHours() {
		return estimatedHours;
	}
	public void setEstimatedHours(float estimatedHours) {
		this.estimatedHours = estimatedHours;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getCompletedDate() {
		return completedDate;
	}
	public void setCompletedDate(String completedDate) {
		this.completedDate = completedDate;
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
