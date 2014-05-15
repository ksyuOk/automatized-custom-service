package acs.persistence.service.impl;

import acs.persistence.dao.ICategoryMenuDAO;
import acs.persistence.model.CategoryMenu;
import acs.persistence.model.Dish;
import acs.persistence.service.CategoryMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: oksana
 * Date: 14.05.14
 */
@Service("categoryMenu")
public class CategoryMenuServiceImpl implements CategoryMenuService{

    @Autowired
    ICategoryMenuDAO categoryMenuDAO;

    @Override
    public void addCategory(String categoryName, byte[] image, Set<Dish> dishes) {
        CategoryMenu categoryMenu = new CategoryMenu();
        categoryMenu.setName(categoryName);
        categoryMenu.setImage(image);
        categoryMenu.setDishes(dishes);
        categoryMenuDAO.save(categoryMenu);
    }
}
