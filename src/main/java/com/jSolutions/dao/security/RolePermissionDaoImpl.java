package com.jSolutions.dao.security;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.jSolutions.dao.JSolutionDaoImpl;
import com.jSolutions.entities.common.User;
import com.jSolutions.entities.security.RolePermission;

@Repository("rolePermissionDao")
public class RolePermissionDaoImpl extends JSolutionDaoImpl<Integer, RolePermission> implements RolePermissionDao{

	@Override
	public RolePermission getByName(String entityName, User loginUser) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("entityName", entityName));
		criteria.add(Restrictions.eq("domainId", loginUser.getDomainId()));
		RolePermission rolePermission=(RolePermission) criteria.uniqueResult();
		return rolePermission;
	}

	@Override
	public RolePermission readByNameAndRoleId(String entityName, Integer roleId, User loginUser) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("entityName", entityName));
		criteria.add(Restrictions.eq("roleId", roleId));
		criteria.add(Restrictions.eq("domainId", loginUser.getDomainId()));
		RolePermission rolePermission=(RolePermission) criteria.uniqueResult();
		return rolePermission;
	}

}
