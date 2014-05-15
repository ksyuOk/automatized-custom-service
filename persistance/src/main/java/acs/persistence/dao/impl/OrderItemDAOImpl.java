package acs.persistence.dao.impl;

import acs.persistence.dao.IOrderItemDAO;
import acs.persistence.model.Order;
import acs.persistence.model.OrderItem;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: oksana
 * Date: 14.05.14
 */
@Repository
public class OrderItemDAOImpl extends BaseDao<OrderItem> implements IOrderItemDAO{
    public OrderItemDAOImpl() {
        super(OrderItem.class);
    }
}
