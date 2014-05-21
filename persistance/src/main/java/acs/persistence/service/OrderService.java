package acs.persistence.service;

import acs.persistence.model.Client;
import acs.persistence.model.Order;
import acs.persistence.model.OrderItem;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: oksana
 * Date: 14.05.14
 */
public interface OrderService {

    @Transactional
    void saveOrder(Client client, int tableNumber, double priceAllOrder, Date orderTimeCook, Date created, int rate, String responseDescription, String status, List<OrderItem> orderItems);

    @Transactional
    List<Order> getOrderByClient(int clientId);

    @Transactional
    void updateStatusOrder(int idOrder, String status);

    @Transactional
    void updateRateOrder(int idOrder, int rate);

    @Transactional
    void deleteOrder(int idOrder);
}
