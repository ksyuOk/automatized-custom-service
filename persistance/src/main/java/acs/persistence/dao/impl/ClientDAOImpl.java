package acs.persistence.dao.impl;

import acs.persistence.dao.IClientDAO;
import acs.persistence.model.Client;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: oksana
 * Date: 14.05.14
 */
@Repository
public class ClientDAOImpl extends BaseDao<Client> implements IClientDAO {

    public ClientDAOImpl() {
        super(Client.class);
    }

    @Override
    public Client getClientIdByEmail(String email) {
        Query query = em.createQuery("select client from Client client where client.email = :email");
        query.setParameter("email", email);
        List<Client> resultList = query.getResultList();
        if(!resultList.isEmpty() && resultList.size() == 0){
            return resultList.get(0);
        }
        return null;
    }

    @Override
    public void updateEmail(int idClient, String newEmail) {
        Query query = em.createQuery("update Client client set client.email = :newEmail");
        query.setParameter("newEmail", newEmail);
    }

}
