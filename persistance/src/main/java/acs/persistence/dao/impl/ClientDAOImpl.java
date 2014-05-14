package acs.persistence.dao.impl;

import acs.persistence.dao.IClientDAO;
import acs.persistence.model.Client;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: oksana
 * Date: 14.05.14
 */
@Repository
public class ClientDAOImpl extends BaseDao<Client> implements IClientDAO {
    public ClientDAOImpl(Class<Client> entity) {
        super(entity);
    }
}
