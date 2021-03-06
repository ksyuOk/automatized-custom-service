package acs.persistence.dao;

import acs.persistence.model.Dish;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: oksana
 * Date: 14.05.14
 */
public interface IDishDAO extends IBaseDao<Dish>{

    List<Dish> getDishesByCategory(int idCategory);

}
