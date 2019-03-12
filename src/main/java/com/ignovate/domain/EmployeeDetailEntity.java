package com.ignovate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "employee_detail")
@DynamicUpdate(true)
public class EmployeeDetailEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "employee_id")
	private String empId;
	
	@Column(name = "employee_firstname")
	private String firstName;
	
	@Column(name = "employee_lastname")
	private String lastName;
	
	@Column(name = "employee_prefix")
	private String prefix;
	
	@Column(name = "employee_address")
	private String address;
	
	@Column(name = "employee_email")
	private String email;
	
	@Column(name = "employee_contact")
	private Long contact;
	
	@Column(name = "employee_bloodgroup")
	private String bloodgroup;
	
	@Column(name = "employee_dob")
	private String dob;
	
	@Column(name = "employee_doj")
	private String doj;
	
	@Column(name = "employee_dor")
	private String dor;
	
	@Column(name = "employee_skillset")
	private String skillset;
	
	@Column(name = "employee_experience")
	private Long experience;
	
	@Column(name = "employee_education")
	private String education;
	
	@Column(name = "employee_technology")
	private String technology;
	
	@Column(name = "employee_role")
	private String role;
	
	@Column(name = "employee_password")
	private String password;
	
	@Column(name = "employee_status")
	private String status;
	
	@Column(name = "employee_createdby")
	private String createdby;
	
	@Column(name = "employee_log")
	private String log;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getContact() {
		return contact;
	}

	public void setContact(Long contact) {
		this.contact = contact;
	}

	public String getBloodgroup() {
		return bloodgroup;
	}

	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public String getDor() {
		return dor;
	}

	public void setDor(String dor) {
		this.dor = dor;
	}

	public String getSkillset() {
		return skillset;
	}

	public void setSkillset(String skillset) {
		this.skillset = skillset;
	}

	public Long getExperience() {
		return experience;
	}

	public void setExperience(Long experience) {
		this.experience = experience;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}
	
}
