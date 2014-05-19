package acs.persistence.dao.impl;

import acs.persistence.dao.IBaseDao;
import acs.persistence.model.BaseEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

/**
 * Created by vbiloshkurskyi on 5/13/14.
 */
public class BaseDao<T extends BaseEntity> implements IBaseDao<T> {

    private Class<T> entity;

    @PersistenceContext
    public EntityManager em;

    public BaseDao(Class<T> entity) {
        this.entity = entity;
    }

    @Override
    public T read(Serializable id) {
        return em.find(entity, id);
    }

    @Override
    public void delete(Serializable id) {
        T t = read(id);
        em.remove(t);
    }

    @Override
    public T save(T t) {
        em.persist(t);
        return t;
    }

    @Override
    public T update(T e) {
        return em.merge(e);
    }

    @Override
    public List<T> readAll(String tableName) {
        Query query = this.em.createQuery("select * from " + tableName + ";");
        List<T> allFields = query.getResultList();
        return allFields;
    }
}
