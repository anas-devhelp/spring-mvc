package com.jSolutions.entities;

import java.util.Date;

import javax.persistence.Transient;

public class JSolutionEntityImpl implements JSolutionEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Transient
	private Integer statusCode;
	@Transient
	private String message;
	@Transient
	private Object object;
	public JSolutionEntityImpl(Integer statusCode, String message, Object object) {
		this.statusCode=statusCode;
		this.message=message;
		this.object=object;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	@Override
	public Integer getId() {
		return null;
	}

	@Override
	public void setId(Integer id) {
	}

	@Override
	public Integer getDomainId() {
		return null;
	}

	@Override
	public void setDomainId(Integer domainId) {
	}

	@Override
	public Integer getCreatedBy() {
		return null;
	}

	@Override
	public void setCreatedBy(Integer createdBy) {
	}

	@Override
	public Date getCreatedOn() {
		return null;
	}

	@Override
	public void setCreatedOn(Date date) {
	}

	@Override
	public Integer getUpdatedBy() {
		return null;
	}

	@Override
	public void setUpdatedBy(Integer updatedBy) {
	}

	@Override
	public Date getUpdatedOn() {
		return null;
	}

	@Override
	public void setUpdatedOn(Date date) {
	}

}
