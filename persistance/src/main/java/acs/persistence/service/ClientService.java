package acs.persistence.service;

import acs.persistence.model.Client;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: oksana
 * Date: 14.05.14
 */
public interface ClientService {

    @Transactional
    void saveClient(String userName, String email);

    @Transactional
    Client getIdClientByEmail(String email);

    @Transactional
    void deleteClient(int id);
}
