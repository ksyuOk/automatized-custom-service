package acs.persistence.dao.impl;

import acs.persistence.dao.IOrderItemDAO;
import acs.persistence.model.Order;
import acs.persistence.model.OrderItem;

/**
 * Created with IntelliJ IDEA.
 * User: oksana
 * Date: 14.05.14
 */
public class OrderItemDAOImpl extends BaseDao<OrderItem> implements IOrderItemDAO{
    public OrderItemDAOImpl(Class<OrderItem> entity) {
        super(entity);
    }
}
