package acs.persistence.dao;

import acs.persistence.model.Client;

/**
 * Created with IntelliJ IDEA.
 * User: oksana
 * Date: 14.05.14
 */
public interface IClientDAO extends IBaseDao<Client> {

    void updateEmail(int idClient, String newEmail);

    Client getClientIdByEmail(String email);
}
