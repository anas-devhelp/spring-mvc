package com.jSolutions.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.services.kms.model.NotFoundException;
import com.jSolutions.entities.JSolutionEntity;
import com.jSolutions.entities.common.User;
import com.jSolutions.exceptions.NotBelongsToDomainException;

public class JSolutionDaoImpl<PK extends Serializable,E extends JSolutionEntity> implements JSolutionDao{

	private final Class<JSolutionEntity> persistentClass;

	@SuppressWarnings("unchecked")
	public JSolutionDaoImpl(){
		this.persistentClass =(Class<JSolutionEntity>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	protected Criteria createEntityCriteria(){
		return getSession().createCriteria(persistentClass);
	}

	@Override
	public void create(JSolutionEntity entity, User loginUser) {
		entity.setDomainId(loginUser.getDomainId());
		getSession().persist(entity);
	}

	@Override
	public JSolutionEntity read(Integer id, User loginUser) throws NotFoundException,NotBelongsToDomainException{
		Criteria criteria= createEntityCriteria();
		criteria.add(Restrictions.eq("id", id));
		criteria.add(Restrictions.eq("domainId", loginUser.getDomainId()));
		return (JSolutionEntity) criteria.uniqueResult();
	}

	@Override
	public void update(JSolutionEntity entity, User loginUser) throws NotFoundException,NotBelongsToDomainException{
		if(entity.getDomainId()==loginUser.getDomainId()) {
			getSession().merge(entity);
		}
	}

	@Override
	public void delete(JSolutionEntity entity, User loginUser) throws NotFoundException,NotBelongsToDomainException{
		if(entity.getDomainId()==loginUser.getDomainId()) {
			getSession().delete(entity);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<? extends JSolutionEntity> getAll(User loginUser) {
		Criteria criteria= createEntityCriteria();
		criteria.add(Restrictions.eq("domainId", loginUser.getDomainId()));
		return criteria.list();
	}
}
