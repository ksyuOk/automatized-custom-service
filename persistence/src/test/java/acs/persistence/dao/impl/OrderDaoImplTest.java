package acs.persistence.dao.impl;

import acs.persistence.dao.IOrderDao;
import acs.persistence.model.Order;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;

/**
 * Created by vbiloshkurskyi on 5/13/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:persistence-config-test.xml"})
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class OrderDaoImplTest {

    @Autowired
    private IOrderDao orderDao;

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testCRUD() {
        Order order = orderDao.read(new Integer(1));
        assertNotNull("Expected order", order);
    }
}
