package acs.persistence.dao.impl;

import acs.persistence.dao.IOrderDao;
import acs.persistence.model.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by vbiloshkurskyi on 5/13/14.
 */
@Repository
public class OrderDaoImpl extends BaseDao<Order> implements IOrderDao {
    public OrderDaoImpl() {
        super(Order.class);
    }

    @Override
    public List<Order> getOrderByClient(int clientId) {
        Query query = em.createQuery("select orders from Order orders where orders.clientId = :id");
        query.setParameter("id", clientId);
        return query.getResultList();
    }

    @Override
    public void updateStatusOrder(int idOrder, String status) {
        Query query = em.createQuery("update Order orders set orders.status = :newStatus where orders.id = :idOrder");
        query.setParameter("newStatus", status);
        query.setParameter("idOrder", idOrder);
        query.executeUpdate();
    }

    @Override
    public void updateRateOrder(int idOrder, int rate) {
        Query query = em.createQuery("update Order orders set orders.rate = :rate where orders.id = :idOrder");
        query.setParameter("rate", rate);
        query.setParameter("idOrder", idOrder);
        query.executeUpdate();
    }
}
