package acs.persistence.service;

import acs.persistence.model.CategoryMenu;
import acs.persistence.model.Client;
import acs.persistence.model.Dish;
import acs.persistence.model.OrderItem;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: oksana
 * Date: 14.05.14
 */
public interface CategoryMenuService {

    @Transactional
    void addCategory(String categoryName, byte [] image, Set<Dish> dishes);

    @Transactional
    void updateCategory();

    @Transactional
    List<CategoryMenu> getAllCategories();

    @Transactional
    void deleteCategory(int id);

    byte[] getCategoryImage(int id);
}
