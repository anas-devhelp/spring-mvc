package com.jSolutions.services.common;

import com.jSolutions.entities.common.Category;
import com.jSolutions.entities.common.User;
import com.jSolutions.services.JSolutionService;

public interface CategoryService extends JSolutionService{
	Category getByName(String name, User loginUser);
}
