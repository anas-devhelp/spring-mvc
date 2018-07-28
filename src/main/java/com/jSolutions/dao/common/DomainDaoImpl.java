package com.jSolutions.dao.common;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.jSolutions.dao.JSolutionDaoImpl;
import com.jSolutions.entities.JSolutionEntity;
import com.jSolutions.entities.common.Domain;
import com.jSolutions.entities.common.User;

@Repository("domainDao")
public class DomainDaoImpl extends JSolutionDaoImpl<Integer, Domain> implements DomainDao{
	@Override
	public Domain getByName(String name) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("name", name));
		Domain domain=(Domain) criteria.list().get(0);
		return domain;
	}

	@Override
	public Domain read(Integer id) {
		Criteria criteria= createEntityCriteria();
		criteria.add(Restrictions.eq("id", id));
		return (Domain) criteria.uniqueResult();
	}
	
	@Override
	public Domain read(Integer id, User loginUser) {
		Criteria criteria= createEntityCriteria();
		criteria.add(Restrictions.eq("id", id));
		return (Domain) criteria.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Domain> getAll(User loginUser) {
		Criteria criteria= createEntityCriteria();
		criteria.add(Restrictions.eq("id", loginUser.getDomainId()));
		return criteria.list();
	}
}
