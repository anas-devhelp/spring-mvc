package com.jSolutions.entities.security;

public class RolePermissionFormData {
	private String  entityName;
	private String  permission;
	private Integer roleId;
	private String  roleName;
	private String  can_create;
	private String  can_read;
	private String  can_update;
	private String  can_delete;
	public String getEntityName() {
		return entityName;
	}
	
	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getCan_create() {
		return can_create;
	}

	public void setCan_create(String can_create) {
		this.can_create = can_create;
	}

	public String getCan_read() {
		return can_read;
	}

	public void setCan_read(String can_read) {
		this.can_read = can_read;
	}

	public String getCan_update() {
		return can_update;
	}

	public void setCan_update(String can_update) {
		this.can_update = can_update;
	}

	public String getCan_delete() {
		return can_delete;
	}

	public void setCan_delete(String can_delete) {
		this.can_delete = can_delete;
	}
}
