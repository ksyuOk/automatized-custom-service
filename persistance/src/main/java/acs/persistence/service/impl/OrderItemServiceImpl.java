package acs.persistence.service.impl;

import acs.persistence.dao.IOrderItemDAO;
import acs.persistence.model.Order;
import acs.persistence.model.OrderItem;
import acs.persistence.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: oksana
 * Date: 14.05.14
 */
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    IOrderItemDAO orderItemDAO;


    @Override
    public void addItemOrder(Order order, int dishId, int count, int price) {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setCount(count);
        orderItem.setPrice(price);
        orderItemDAO.save(orderItem);
    }

    @Override
    public void deleteItemOrder(int idItemOrder) {
        orderItemDAO.delete(idItemOrder);
    }
}
