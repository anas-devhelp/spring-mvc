package com.jSolutions.entities.security;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import com.jSolutions.entities.JSolutionEntity;

@Entity
@Table(name="roles", uniqueConstraints= {
		@UniqueConstraint(columnNames = { "name", "domain_id" })})
public class Role implements JSolutionEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;

	@Size(max=45)
	@Column(name = "name", nullable = false)
	private String name;

	@Size(max=255)
	@Column(name = "description", nullable = true)
	private String description;
	
	@Column(name = "status", nullable = false)
	protected Integer status;

	@Column(name = "created_by", nullable = true)
	protected Integer createdBy;

	@Column(name = "created_on", nullable = true)
	protected Date createdOn;

	@Column(name = "updated_by", nullable = true)
	protected Integer updatedBy;

	@Column(name = "updated_on", nullable = true)
	protected Date updatedOn;

	@Column(name = "domain_id", nullable = false)
	protected Integer domainId;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private List<RolePermission> permissions = new ArrayList<>();
	
	@Transient
	Set<String> permissionsSet;
	
	@Transient
	Map<String, RolePermission> permissionsMap;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getDomainId() {
		return domainId;
	}

	public void setDomainId(Integer domainId) {
		this.domainId = domainId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<RolePermission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<RolePermission> permissions) {
		this.permissions = permissions;
	}

	public Set<String> getPermissionsSet() {
		return permissionsSet;
	}

	public void setPermissionsSet(Set<String> permissionsSet) {
		this.permissionsSet = permissionsSet;
	}

	public Map<String, RolePermission> getPermissionsMap() {
		return permissionsMap;
	}

	public void setPermissionsMap(Map<String, RolePermission> permissionsMap) {
		this.permissionsMap = permissionsMap;
	}
	
}
