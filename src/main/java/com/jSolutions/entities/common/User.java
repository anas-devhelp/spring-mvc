package com.jSolutions.entities.common;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import com.jSolutions.entities.JSolutionEntity;

@Entity
@Table(name="users", uniqueConstraints= {@UniqueConstraint(columnNames = { "user_name", "domain_id" }),@UniqueConstraint(columnNames = { "email", "domain_id" })})
public class User implements JSolutionEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;


	@Size(max=45)
	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Size(max=45)
	@Column(name = "middle_name", nullable = true)
	private String middleName;

	@Size(max=45)
	@Column(name = "last_name", nullable = true)
	private String lastName;

	@Column(name = "dob", nullable = false)
	private Date dob;

	@Size(max=255)
	@Column(name = "email", nullable = false)
	private String email;

	@Size(max=45)
	@Column(name = "user_name", nullable = false)
	private String userName;

	@Size(max=45)
	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "status", nullable = false)
	private Integer status;


	@Column(name = "domain_id", nullable = false)
	private Integer domainId;

	@Column(name = "created_by", nullable = true)
	private Integer createdBy;

	@Column(name = "created_on", nullable = true)
	private Date createdOn;

	@Column(name = "updated_by", nullable = true)
	private Integer updatedBy;

	@Column(name = "updated_on", nullable = true)
	private Date updatedOn;



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDomainId() {
		return domainId;
	}

	public void setDomainId(Integer domainId) {
		this.domainId = domainId;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {

		StringBuilder sb=new StringBuilder();
		sb.append("{");
		sb.append("id:");sb.append(this.getId());sb.append(",");
		sb.append("firstName:");sb.append(this.firstName);sb.append(",");
		sb.append("middleName:");sb.append(this.middleName);sb.append(",");
		sb.append("lastName:");sb.append(this.lastName);sb.append(",");
		sb.append("dob:");sb.append(this.dob);sb.append(",");
		sb.append("email:");sb.append(this.email);sb.append(",");
		sb.append("userName:");sb.append(this.userName);sb.append(",");
		sb.append("password:");sb.append("[SECURED]");sb.append(",");
		sb.append("status:");sb.append(this.status);sb.append(",");
		sb.append("domainId:");sb.append(this.getDomainId());
		sb.append("}");
		return sb.toString();
	}
}
