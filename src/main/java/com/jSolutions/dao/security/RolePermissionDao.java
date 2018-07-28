package com.jSolutions.dao.security;

import com.jSolutions.dao.JSolutionDao;
import com.jSolutions.entities.common.User;
import com.jSolutions.entities.security.RolePermission;

public interface RolePermissionDao extends JSolutionDao{
	RolePermission getByName(String name, User loginUser);
	public RolePermission readByNameAndRoleId(String entityName, Integer roleId, User loginUser);
}
