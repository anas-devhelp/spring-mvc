package com.jSolutions.services.security;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jSolutions.dao.security.RoleDao;
import com.jSolutions.entities.JSolutionEntity;
import com.jSolutions.entities.common.User;
import com.jSolutions.entities.security.Role;
import com.jSolutions.entities.security.RolePermission;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleDao roleDao;
	
	@Override
	public Role getByName(String name, User loginUser) {
		return roleDao.getByName(name, loginUser);
	}

	@Override
	public void create(JSolutionEntity entity, User loginUser) {
		entity.setDomainId(loginUser.getDomainId());
		roleDao.create(entity);
	}

	@Override
	public JSolutionEntity read(Integer id, User loginUser) {
		Role role=(Role)roleDao.read(id, loginUser);
		setPermissionsMap(role);
		return role;
	}

	@Override
	public void update(JSolutionEntity entity, User loginUser) {
		entity.setDomainId(loginUser.getDomainId());
		roleDao.update(entity);
		
	}

	@Override
	public void delete(Integer id, User loginUser) {
		JSolutionEntity entity=roleDao.read(id, loginUser);
		roleDao.delete(entity);
		
	}

	@Override
	public void delete(JSolutionEntity entity, User loginUser) {
		entity=roleDao.read(entity.getId(), loginUser);
		roleDao.delete(entity);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getAll(User loginUser) {
		List<Role> roles= (List<Role>) roleDao.getAll(loginUser);
		setPermissionsMap(roles);
		return roles;
	}

	@Override
	public boolean isNameUnique(String name, User loginUser){
		Role role = getByName(name, loginUser);
        return ( role == null || ((name != null) && (role.getName().equalsIgnoreCase(name))));
	}

	private void setPermissionsMap(List<Role> roles) {
		if(roles!=null && roles.size()>0) {
			for(Role role: roles) {
				setPermissionsMap(role);
			}
		}
		
	}
	private void setPermissionsMap(Role role) {
		if(role!=null && role.getPermissions()!=null && role.getPermissions().size()>0) {
			Map<String, RolePermission> permissionsMap=new HashMap<>();
			for(RolePermission permission: role.getPermissions()) {
				permissionsMap.put(permission.getEntityName(), permission);
			}
			role.setPermissionsMap(permissionsMap);
		}
	}
	
}
