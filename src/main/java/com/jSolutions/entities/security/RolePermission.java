package com.jSolutions.entities.security;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import com.jSolutions.entities.JSolutionEntity;


@Entity
@Table(name="role_permissions", uniqueConstraints= {
		@UniqueConstraint(columnNames = { "entity_name", "role_id", "domain_id" })})
public class RolePermission implements JSolutionEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;
	
	@Size(max=45)
    @Column(name = "entity_name", nullable = false)
    private String entityName;
	
	@Column(name = "role_id", nullable = false)
	private Integer roleId;
	
	@Column(name = "can_create", nullable = false)
	private Integer canCreate;
	
	@Column(name = "can_read", nullable = false)
	private Integer canRead;
	
	@Column(name = "can_update", nullable = false)
	private Integer canUpdate;
	
	@Column(name = "can_delete", nullable = false)
	private Integer canDelete;
	
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
	
	@Transient
	protected String[] names;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public Integer getCanCreate() {
		return canCreate;
	}

	public void setCanCreate(Integer canCreate) {
		this.canCreate = canCreate;
	}

	public Integer getCanRead() {
		return canRead;
	}

	public void setCanRead(Integer canRead) {
		this.canRead = canRead;
	}

	public Integer getCanUpdate() {
		return canUpdate;
	}

	public void setCanUpdate(Integer canUpdate) {
		this.canUpdate = canUpdate;
	}

	public Integer getCanDelete() {
		return canDelete;
	}

	public void setCanDelete(Integer canDelete) {
		this.canDelete = canDelete;
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

	public String[] getNames() {
		return names;
	}

	public void setNames(String[] names) {
		this.names = names;
	}
}
