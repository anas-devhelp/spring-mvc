package com.jSolutions.services.security;

import com.jSolutions.entities.common.User;
import com.jSolutions.entities.security.RolePermission;
import com.jSolutions.services.JSolutionService;

public interface RolePermissionService extends JSolutionService{
	
	RolePermission getByName(String name, User loginUser);
	
	boolean isNameUnique(String name, User loginUser);
	
	public RolePermission readByNameAndRoleId(String entityName, Integer roleId, User loginUser);
	
	public void saveOrUpdate(RolePermission entity, User loginUser);
	
}
