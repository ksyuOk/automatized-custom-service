package acs.persistence.dao.impl;

import acs.persistence.dao.ICategoryMenuDAO;
import acs.persistence.model.CategoryMenu;
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

/**
 * Created with IntelliJ IDEA.
 * User: oksana
 * Date: 24.05.14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:persistence-config-test.xml"})
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class CategoryMenuDAOImplTest {
    @Autowired
    ICategoryMenuDAO categoryMenuDAO;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testGetAllCategories() {
        List<CategoryMenu> allCategories = categoryMenuDAO.readAll();
        assertEquals("Expected result", true, allCategories.size()>0);
    }

    @Test
    public void testAddNewCategory() {
        CategoryMenu categoryMenu = new CategoryMenu();
        categoryMenu.setName("Обеды");

        List<CategoryMenu> allCategories = categoryMenuDAO.readAll();
        int size = allCategories.size();
        categoryMenuDAO.save(categoryMenu);
        List<CategoryMenu> allCategoriesUpdate = categoryMenuDAO.readAll();
        int sizeUpdate = allCategoriesUpdate.size();
        assertEquals("Expected result", size + 1, sizeUpdate > size);
    }

    @Test
    public void testDeleteCategory(){
        List<CategoryMenu> allCategories = categoryMenuDAO.readAll();
        int size = allCategories.size();
        categoryMenuDAO.delete(2);
        List<CategoryMenu> allCategories2 = categoryMenuDAO.readAll();
        int size2 = allCategories.size();
        assertEquals("Expected result", true, size2 > size);
    }
}
