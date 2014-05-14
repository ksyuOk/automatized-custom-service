package acs.persistence.dao.impl;

import acs.persistence.dao.IOrderDao;
import acs.persistence.model.Order;
import org.springframework.stereotype.Repository;

/**
 * Created by vbiloshkurskyi on 5/13/14.
 */
@Repository
public class OrderDaoImpl extends BaseDao<Order> implements IOrderDao {
    public OrderDaoImpl() {
        super(Order.class);
    }
}
