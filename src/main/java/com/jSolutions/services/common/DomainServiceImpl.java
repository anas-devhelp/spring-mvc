package com.jSolutions.services.common;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.kms.model.NotFoundException;
import com.jSolutions.dao.common.DomainDao;
import com.jSolutions.entities.JSolutionEntity;
import com.jSolutions.entities.common.Domain;
import com.jSolutions.entities.common.User;
import com.jSolutions.exceptions.NotBelongsToDomainException;

@Service("domainService")
@Transactional
public class DomainServiceImpl implements DomainService{
	@Autowired
    private DomainDao domainDao;
	
	
	public Domain getByName(String name) {
		return domainDao.getByName(name);
	}


	@Override
	public void create(JSolutionEntity entity, User loginUser) {
		entity.setDomainId(loginUser.getDomainId());
		domainDao.create(entity, loginUser);
	}


	@Override
	public JSolutionEntity read(Integer id, User loginUser) throws NotFoundException, NotBelongsToDomainException {
		return domainDao.read(id, loginUser);
	}


	@Override
	public void update(JSolutionEntity entity, User loginUser) throws NotFoundException, NotBelongsToDomainException {
		entity.setDomainId(loginUser.getDomainId());
		domainDao.update(entity, loginUser);
		
	}


	@Override
	public void delete(Integer id, User loginUser) throws NotFoundException, NotBelongsToDomainException {
		JSolutionEntity entity=domainDao.read(id, loginUser);
		domainDao.delete(entity, loginUser);
		
	}


	@Override
	public void delete(JSolutionEntity entity, User loginUser) throws NotFoundException, NotBelongsToDomainException {
		entity=domainDao.read(entity.getId(), loginUser);
		domainDao.delete(entity, loginUser);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Domain> getAll(User loginUser) {
		return (List<Domain>) domainDao.getAll(loginUser);
	}
}
