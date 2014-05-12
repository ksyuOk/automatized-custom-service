package acs.persistence.dao.impl;

import acs.persistence.dao.IBaseDao;
import acs.persistence.model.BaseEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import java.io.Serializable;
import java.util.List;

/**
 * Created by vbiloshkurskyi on 5/13/14.
 */
public class BaseDao<T extends BaseEntity> implements IBaseDao<T> {

    private Class<T> entity;

    @PersistenceUnit
    private EntityManager em;

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
        return em.merge(t);
    }

    @Override
    public List<T> readAll() {
        return null;
    }
}
