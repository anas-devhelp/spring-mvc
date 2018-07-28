package com.jSolutions.dao.common;

import com.jSolutions.dao.JSolutionDao;
import com.jSolutions.entities.common.Domain;

public interface DomainDao extends JSolutionDao{
	Domain getByName(String name);
	Domain read(Integer id);
}
