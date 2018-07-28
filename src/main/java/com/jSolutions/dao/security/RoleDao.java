package com.jSolutions.dao.security;

import com.jSolutions.dao.JSolutionDao;
import com.jSolutions.entities.common.User;
import com.jSolutions.entities.security.Role;

public interface RoleDao extends JSolutionDao{
	Role getByName(String name, User loginUser);
}
