package acs.persistence.dao.impl;

import acs.persistence.dao.IClientDAO;
import acs.persistence.model.Client;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: oksana
 * Date: 24.05.14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:persistence-config-test.xml"})
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class ClientDaoImplTest {
    @Autowired
    private IClientDAO clientDAO;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testGetClientIdByEmail() {
        Client client = clientDAO.getClientIdByEmail("oksana.mazurova964@gmail.com");
        Integer id = client.getId();
        assertEquals("Expected dishes", true, client != null);
    }

    @Test
    public void testUpdateEmail(){
        Client client = clientDAO.read(1);
        String emailClient = client.getEmail();
        clientDAO.updateEmail(1, "cocosha@mail.ru");
        Client updateClient = clientDAO.read(1);
        String newEmailClient = client.getEmail();
        assertEquals("Expected client", false, emailClient.equals(newEmailClient));
    }
}
