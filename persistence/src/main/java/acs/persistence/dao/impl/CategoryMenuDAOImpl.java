package acs.persistence.dao.impl;

import acs.persistence.dao.ICategoryMenuDAO;
import acs.persistence.model.CategoryMenu;

/**
 * Created with IntelliJ IDEA.
 * User: oksana
 * Date: 14.05.14
 */
public class CategoryMenuDAOImpl extends BaseDao<CategoryMenu> implements ICategoryMenuDAO {
    public CategoryMenuDAOImpl(Class<CategoryMenu> entity) {
        super(entity);
    }
}
