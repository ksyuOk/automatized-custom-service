package acs.persistence.service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: oksana
 * Date: 14.05.14
 */
public interface ClientService {

    @Transactional
    void saveClient(String userName, String email);

    void updateClient();

    void deleteClient(int id);
}
