package com.jSolutions.services.common;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jSolutions.dao.common.UserDao;
import com.jSolutions.entities.JSolutionEntity;
import com.jSolutions.entities.common.Domain;
import com.jSolutions.entities.common.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;
	@Override
	public User getByEmail(String email, User loginUser) {
		return userDao.getByEmail(email, loginUser);
	}
	@Override
	public void create(JSolutionEntity entity, User loginUser) {
		entity.setDomainId(loginUser.getDomainId());
		userDao.create(entity, loginUser);
		
	}
	@Override
	public User read(Integer id, User loginUser) {
		return (User) userDao.read(id, loginUser);
	}
	@Override
	public void update(JSolutionEntity entity, User loginUser) {
		entity.setDomainId(loginUser.getDomainId());
		userDao.update(entity);
		
	}
	@Override
	public void delete(Integer id, User loginUser) {
		JSolutionEntity entity=userDao.read(id, loginUser);
		userDao.delete(entity);
		
	}
	@Override
	public void delete(JSolutionEntity entity, User loginUser) {
		entity=userDao.read(entity.getId(), loginUser);
		userDao.delete(entity);
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll(User loginUser) {
		return (List<User>) userDao.getAll(loginUser);
	}
}
