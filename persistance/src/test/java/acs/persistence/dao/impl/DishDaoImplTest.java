package acs.persistence.dao.impl;

import acs.persistence.dao.IDishDAO;
import acs.persistence.dao.IOrderDao;
import acs.persistence.model.Dish;
import acs.persistence.model.Order;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by vbiloshkurskyi on 5/13/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:persistence-config-test.xml"})
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class DishDaoImplTest {

    @Autowired
    private IDishDAO dishDAO;

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testGetDishByCategory() {
        List<Dish> dishesByCategory = dishDAO.getDishesByCategory(1);
        assertEquals("Expected dishes", false, dishesByCategory.isEmpty());
    }
}
