package com.ignovate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "project_detail")
@DynamicUpdate(true)
public class ProjectDetailEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "project_id")
	private Long projId;
	
	@Column(name = "project_name")
	private String projName;
	
	@Column(name = "project_overview")
	private String projOverview;
	
	@Column(name = "client")
	private String clientName;
	
	@Column(name = "client_phone")
	private Long clientPhone;
	
	@Column(name = "client_email")
	private String clientEmail;
	
	@Column(name = "start_date")
	private String projStartDate;
	
	@Column(name = "end_date")
	private String projEndDate;
	
	@Column(name = "resource")
	private Long resources;
	
	@Column(name = "created_by")
	private String createdBy;

	public Long getProjId() {
		return projId;
	}

	public void setProjId(Long projId) {
		this.projId = projId;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public String getProjOverview() {
		return projOverview;
	}

	public void setProjOverview(String projOverview) {
		this.projOverview = projOverview;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public Long getClientPhone() {
		return clientPhone;
	}

	public void setClientPhone(Long clientPhone) {
		this.clientPhone = clientPhone;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	public String getProjStartDate() {
		return projStartDate;
	}

	public void setProjStartDate(String projStartDate) {
		this.projStartDate = projStartDate;
	}

	public String getProjEndDate() {
		return projEndDate;
	}

	public void setProjEndDate(String projEndDate) {
		this.projEndDate = projEndDate;
	}

	public Long getResources() {
		return resources;
	}

	public void setResources(Long resources) {
		this.resources = resources;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
}
