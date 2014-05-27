package acs.persistence.dao.impl;

import acs.persistence.dao.ICategoryMenuDAO;
import acs.persistence.model.CategoryMenu;
import acs.persistence.model.Dish;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        List<CategoryMenu> allCategories = categoryMenuDAO.readAll("CategoryMenu");
        assertEquals("Expected result", true, allCategories.size()>0);
    }

    @Test
    public void testAddNewCategory() {
        CategoryMenu categoryMenu = new CategoryMenu();
        categoryMenu.setName("Обеды");

//        Set<Dish> dishes = new HashSet<Dish>();
//        Dish dish = new Dish();
//        dish.setDishName("Карпачо");
//        dish.setPrice(45.0);
//        dish.setCategoryMenu(categoryMenu);
//        dishes.add(dish);
//
//        categoryMenu.setDishes(dishes);
        List<CategoryMenu> allCategories = categoryMenuDAO.readAll("CategoryMenu");
        int size = allCategories.size();
        categoryMenuDAO.save(categoryMenu);
        List<CategoryMenu> allCategoriesUpdate = categoryMenuDAO.readAll("CategoryMenu");
        int sizeUpdate = allCategories.size();
        assertEquals("Expected result", true, sizeUpdate > size);
    }

    @Test
    public void testDeleteCategory(){
        List<CategoryMenu> allCategories = categoryMenuDAO.readAll("CategoryMenu");
        int size = allCategories.size();
        categoryMenuDAO.delete(2);
        List<CategoryMenu> allCategories2 = categoryMenuDAO.readAll("CategoryMenu");
        int size2 = allCategories.size();
        assertEquals("Expected result", true, size2 > size);
    }
}
