package acs.persistence.dao.impl;

import acs.persistence.dao.IDishDAO;
import acs.persistence.model.Dish;

/**
 * Created with IntelliJ IDEA.
 * User: oksana
 * Date: 14.05.14
 */
public class DishDAOImpl extends BaseDao<Dish> implements IDishDAO {
    public DishDAOImpl(Class<Dish> entity) {
        super(entity);
    }
}
