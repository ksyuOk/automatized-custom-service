package acs.persistence.dao.impl;

import acs.persistence.dao.IOrderItemDAO;
import acs.persistence.model.OrderItem;
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
 * Created with IntelliJ IDEA.
 * User: oksana
 * Date: 24.05.14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:persistence-config-test.xml"})
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class OrderItemDAOImplTest {
    @Autowired
    IOrderItemDAO orderItemDao;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testGetOrderItem(){
        OrderItem orderItem = orderItemDao.read(new Integer(1));
        assertNotNull("Expected order", orderItem);
    }

}
