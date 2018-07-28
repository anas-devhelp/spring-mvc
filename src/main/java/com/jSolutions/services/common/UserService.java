package com.jSolutions.services.common;

import com.jSolutions.entities.common.User;
import com.jSolutions.services.JSolutionService;

public interface UserService extends JSolutionService{
	User getByEmail(String email, User loginUser);
}
