package com.anmi.mailclient.core.dao.impl;

import com.anmi.mailclient.core.dao.BaseDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractBaseDao<T> implements BaseDao<T> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public T get(Long id) {
        return (T) currentSession().get(getEntityClass(), id);
    }

    @Override
    public void add(T entity) {
        currentSession().saveOrUpdate(entity);
    }

    @Override
    public List<T> getAll() {
        return getAllCriteria().list();
    }

    @Override
    public void deleteById(Long id) {
        T entity = get(id);
        if (entity != null) {
            currentSession().delete(entity);
        }
    }

    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    protected abstract Class<T> getEntityClass();

    protected Criteria getAllCriteria() {
        return currentSession().createCriteria(getEntityClass()).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    }
}
