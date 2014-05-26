package acs.persistence.dao;

import acs.persistence.model.BaseEntity;
import org.springframework.transaction.annotation.Transactional;

import javax.transaction.Transaction;
import java.io.Serializable;
import java.util.List;

/**
 * Created by vbiloshkurskyi on 5/13/14.
 */
public interface IBaseDao<T extends BaseEntity> {
    T read(Serializable id);

    void delete(Serializable id);

    T save(T e);

    T update (T e);

    List<T> readAll(String tableName);
}
