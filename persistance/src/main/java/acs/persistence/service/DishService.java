package acs.persistence.service;

import acs.persistence.model.Dish;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: oksana
 * Date: 14.05.14
 */
public interface DishService {

    @Transactional
    void addNewDish(String name, String description, Date timeCook, Double price, byte [] imageDish, byte [] largeImageDish);

    @Transactional
    Dish updateDish(int id);

    @Transactional
    List<Dish> getAllDishes();

    @Transactional
    List<Dish> getDishesByCategory(int idCategory);

    @Transactional
    void deleteDish(int id);

}
