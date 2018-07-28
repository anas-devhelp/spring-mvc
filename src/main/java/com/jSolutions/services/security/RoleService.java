package com.jSolutions.services.security;

import com.jSolutions.entities.common.User;
import com.jSolutions.entities.security.Role;
import com.jSolutions.services.JSolutionService;

public interface RoleService extends JSolutionService{

	Role getByName(String name, User loginUser);
	boolean isNameUnique(String name, User loginUser);
	
}
