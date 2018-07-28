package com.jSolutions.dao.common;

import com.jSolutions.dao.JSolutionDao;
import com.jSolutions.entities.common.User;

public interface UserDao extends JSolutionDao{
	public User getByEmail(String name, User loginUser);
}
