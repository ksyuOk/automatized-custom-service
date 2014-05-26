package acs.persistence.dao.impl;

import acs.persistence.dao.IDishDAO;
import acs.persistence.model.Dish;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: oksana
 * Date: 14.05.14
 */
@Repository
public class DishDAOImpl extends BaseDao<Dish> implements IDishDAO {
    public DishDAOImpl() {
        super(Dish.class);
    }

    @Override
    public List<Dish> getDishesByCategory(int idCategory) {
        Query query = this.em.createQuery("SELECT dish FROM Dish dish WHERE dish.categoryMenu.id = :idCategory", Dish.class);
        query.setParameter("idCategory", idCategory);
        List<Dish> result = query.getResultList();
        return result;
    }
}
