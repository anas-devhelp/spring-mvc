package com.jSolutions.services.common;

import com.jSolutions.entities.common.Domain;
import com.jSolutions.services.JSolutionService;

public interface DomainService extends JSolutionService{
	Domain getByName(String name);
}
