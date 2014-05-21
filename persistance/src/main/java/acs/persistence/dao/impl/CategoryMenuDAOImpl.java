package acs.persistence.dao.impl;

import acs.persistence.dao.ICategoryMenuDAO;
import acs.persistence.model.CategoryMenu;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: oksana
 * Date: 14.05.14
 */
@Repository
public class CategoryMenuDAOImpl extends BaseDao<CategoryMenu> implements ICategoryMenuDAO {
    public CategoryMenuDAOImpl() {
        super(CategoryMenu.class);
    }

    @Override
    public List<CategoryMenu> getAllCategories() {
        Query query = this.em.createQuery("select category from  CategoryMenu category");
        List<CategoryMenu> allFields = query.getResultList();
        return null;
    }
}
