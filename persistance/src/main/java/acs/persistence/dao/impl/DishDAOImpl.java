package acs.persistence.dao.impl;

import acs.persistence.dao.IDishDAO;
import acs.persistence.model.Dish;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: oksana
 * Date: 14.05.14
 */
@Repository
public class DishDAOImpl extends BaseDao<Dish> implements IDishDAO {
    public DishDAOImpl(Class<Dish> entity) {
        super(entity);
    }
}
