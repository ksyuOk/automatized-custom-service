package acs.persistence.service;

import acs.persistence.model.Order;

/**
 * Created with IntelliJ IDEA.
 * User: oksana
 * Date: 14.05.14
 */
public interface OrderItemService {

    void addItemOrder(Order order, int dishId, int count, int price);

    void deleteItemOrder(int idItemOrder);
}
