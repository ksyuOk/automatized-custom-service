package acs.persistence.service.impl;

import acs.persistence.dao.IOrderDao;
import acs.persistence.model.Client;
import acs.persistence.model.Order;
import acs.persistence.model.OrderItem;
import acs.persistence.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: oksana
 * Date: 14.05.14
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService{

    @Autowired
    IOrderDao orderDao;

    @Override
    public void saveOrder(Client client, int tableNumber, double priceAllOrder, Date orderTimeCook, Date created,
                          int rate, String responseDescription, String status, List<OrderItem> orderItems) {

        Order order = new Order();
        order.setClient(client);
        order.setTableNumber(tableNumber);
        order.setPriceAllOrder(priceAllOrder);
        order.setGeneralTimeCook(orderTimeCook);
        order.setCreated(created);
        order.setOrderRate(rate);
        order.setResponceDescription(responseDescription);
        order.setStatus(status);
        order.setOrderItems(orderItems);

        orderDao.save(order);
    }

    @Override
    public List<Order> getOrderByClient(int clientId) {
        return orderDao.getOrderByClient(clientId);
    }

    @Override
    public void updateStatusOrder(int idOrder, String status) {
        orderDao.updateStatusOrder(idOrder, status);
    }

    @Override
    public void updateRateOrder(int idOrder, int rate) {
        orderDao.updateRateOrder(idOrder, rate);
    }

    @Override
    public void deleteOrder(int idOrder) {
        orderDao.delete(idOrder);
    }
}
