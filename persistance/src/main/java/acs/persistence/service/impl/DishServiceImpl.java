package acs.persistence.service.impl;

import acs.persistence.dao.IDishDAO;
import acs.persistence.model.Dish;
import acs.persistence.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: oksana
 * Date: 14.05.14
 */
@Service("dish")
public class DishServiceImpl implements DishService{

    @Autowired
    IDishDAO dishDAO;

    @Override
    public void addNewDish(String name, String description, Date timeCook, Double price, byte[] imageDish, byte[] largeImageDish) {
        Dish dish = new Dish();
        dish.setDishName(name);
        dish.setDescription(description);
        dish.setTimeCook(timeCook);
        dish.setPrice(price);
        dish.setImageDish(imageDish);
        dish.setLargeImageDish(largeImageDish);
        dishDAO.save(dish);
    }

    @Override
    public Dish updateDish(int id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Dish> getAllDishes() {
        String nameTable = "dish";
        return dishDAO.readAll();
    }

    @Override
    public List<Dish> getDishesByCategory(int idCategory) {
        return dishDAO.getDishesByCategory(idCategory);
    }

    @Override
    public void deleteDish(int id) {
        dishDAO.delete(id);
    }
}
