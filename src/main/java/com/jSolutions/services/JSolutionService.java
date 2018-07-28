package com.jSolutions.services;

import java.util.List;

import com.amazonaws.services.kms.model.NotFoundException;
import com.jSolutions.entities.JSolutionEntity;
import com.jSolutions.entities.common.User;
import com.jSolutions.exceptions.NotBelongsToDomainException;

public interface JSolutionService {
	void create(JSolutionEntity entity, User loginUser);

	JSolutionEntity read(Integer id, User loginUser) throws NotFoundException, NotBelongsToDomainException;

	void update(JSolutionEntity entity, User loginUser) throws NotFoundException, NotBelongsToDomainException;

	void delete(Integer id, User loginUser) throws NotFoundException, NotBelongsToDomainException;
	
	void delete(JSolutionEntity entity, User loginUser) throws NotFoundException, NotBelongsToDomainException;

	List<? extends JSolutionEntity> getAll(User loginUser);
}
