package acs.persistence.dao;

import acs.persistence.model.Order;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vbiloshkurskyi on 5/13/14.
 */
public interface IOrderDao extends IBaseDao<Order> {

    List<Order> getOrderByClient(int clientId);

    void updateStatusOrder(int idOrder, String status);

    void updateRateOrder(int idOrder, int rate);
}
