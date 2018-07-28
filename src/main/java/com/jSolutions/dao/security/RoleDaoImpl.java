package com.jSolutions.dao.security;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.jSolutions.dao.JSolutionDaoImpl;
import com.jSolutions.entities.common.User;
import com.jSolutions.entities.security.Role;

@Repository("roleDao")
public class RoleDaoImpl extends JSolutionDaoImpl<Integer, Role> implements RoleDao{
	@Override
	public Role getByName(String name, User loginUser) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("name", name));
		criteria.add(Restrictions.eq("domainId", loginUser.getDomainId()));
		Role role=(Role) criteria.uniqueResult();
		return role;
	}
}
