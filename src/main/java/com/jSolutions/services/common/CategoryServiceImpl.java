package com.jSolutions.services.common;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.jSolutions.entities.JSolutionEntity;
import com.jSolutions.entities.common.Category;
import com.jSolutions.entities.common.User;

@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService{

	
	@Override
	public void create(JSolutionEntity entity, User loginUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JSolutionEntity read(Integer id, User loginUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(JSolutionEntity entity, User loginUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id, User loginUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(JSolutionEntity entity, User loginUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<? extends JSolutionEntity> getAll(User loginUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category getByName(String name, User loginUser) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
