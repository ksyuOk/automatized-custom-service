package acs.persistence.service.impl;

import acs.persistence.dao.IClientDAO;
import acs.persistence.model.Client;
import acs.persistence.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: oksana
 * Date: 14.05.14
 */
@Service("clientService")
public class ClientServiceImpl implements ClientService{

    @Autowired
    private IClientDAO clientDAO;

    @Override
    public void saveClient(String userName, String email) {
        Client client = new Client();
        client.setUserName(userName);
        client.setEmail(email);
        clientDAO.save(client);
    }

    @Override
    public void updateClient() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void deleteClient(int id) {
        clientDAO.delete(id);
    }
}
