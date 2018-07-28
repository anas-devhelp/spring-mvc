package com.jSolutions.dao.common;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.jSolutions.dao.JSolutionDaoImpl;
import com.jSolutions.entities.common.User;
@Repository("userDao")
public class UserDaoImpl extends JSolutionDaoImpl<Integer, User> implements UserDao{
	@Override
	public User getByEmail(String name, User loginUser) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("email", name));
		criteria.add(Restrictions.eq("domainId", loginUser.getDomainId()));
		User user=(User) criteria.list().get(0);
		return user;
	}
}
