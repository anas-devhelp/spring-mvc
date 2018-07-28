package com.jSolutions.services.security;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jSolutions.dao.security.RolePermissionDao;
import com.jSolutions.entities.JSolutionEntity;
import com.jSolutions.entities.common.User;
import com.jSolutions.entities.security.RolePermission;

@Service("rolePermissionService")
@Transactional
public class RolePermissionServiceImpl implements RolePermissionService{

	@Autowired
	RolePermissionDao rolePermissionDao;
	
	@Override
	public void create(JSolutionEntity entity, User loginUser) {
		entity.setDomainId(loginUser.getDomainId());
		rolePermissionDao.create(entity);
		
	}

	@Override
	public RolePermission read(Integer id, User loginUser) {
		return (RolePermission) rolePermissionDao.read(id, loginUser);
	}
	
	@Override
	public RolePermission readByNameAndRoleId(String entityName, Integer roleId, User loginUser) {
		return (RolePermission) rolePermissionDao.readByNameAndRoleId(entityName, roleId, loginUser);
	}

	@Override
	public void update(JSolutionEntity entity, User loginUser) {
		rolePermissionDao.update(entity);
		
	}

	@Override
	public void delete(Integer id, User loginUser) {
		JSolutionEntity entity=rolePermissionDao.read(id, loginUser);
		delete(entity, loginUser);
	}

	@Override
	public void delete(JSolutionEntity entity, User loginUser) {
		entity=rolePermissionDao.read(entity.getId(), loginUser);
		rolePermissionDao.delete(entity);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RolePermission> getAll(User loginUser) {
		return (List<RolePermission>) rolePermissionDao.getAll(loginUser);
	}
	
	
	@Override
	public RolePermission getByName(String name, User loginUser) {
		return rolePermissionDao.getByName(name, loginUser);
	}

	@Override
	public boolean isNameUnique(String name, User loginUser) {
		RolePermission rolePermission = getByName(name, loginUser);
        return ( rolePermission == null || ((name != null) && (rolePermission.getEntityName().equalsIgnoreCase(name))));
	}

	@Override
	public void saveOrUpdate(RolePermission entity, User loginUser) {
		RolePermission rolePermission = rolePermissionDao.readByNameAndRoleId(entity.getEntityName(), entity.getRoleId(), loginUser);
		rolePermission.setCanCreate(entity.getCanCreate());
		rolePermission.setCanRead(entity.getCanCreate());
		rolePermission.setCanUpdate(entity.getCanUpdate());
		rolePermission.setCanDelete(entity.getCanDelete());
	}
	
}
