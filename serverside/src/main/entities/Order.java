package src.main.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: oksana
 * Date: 09.05.14
 */

@Entity
@Table(name = "order")
public class Order implements Serializable {

    @Id
    @Column(name = "order_id", nullable = false)
    Integer orderId;

    @Column(name = "client_id", nullable = false)
    Integer clientId;

    @Column(name = "table_number", nullable = false)
    Integer tableNumber;

    @Column(name = "price_all_order", nullable = false)
    Double priceAllOrder;

    @Column(name = "general_time_cook", nullable = false)
    Date generalTimeCook;

    @Column(name = "created", nullable = false)
    Date created;

    @Column(name = "order_rate", nullable = false)
    Integer orderRate;

    @Column(name = "responce_description", nullable = true)
    String responce_description;

    @Column(name = "status", nullable = false)
    String status;

    public String getResponceDescription() {
        return responce_description;
    }

    public void setResponceDescription(String responce_description) {
        this.responce_description = responce_description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getOrderRate() {
        return orderRate;
    }

    public void setOrderRate(Integer order_rate) {
        this.orderRate = order_rate;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getGeneralTimeCook() {
        return generalTimeCook;
    }

    public void setGeneralTimeCook(Date generalTimeCook) {
        this.generalTimeCook = generalTimeCook;
    }

    public Double getPriceAllOrder() {
        return priceAllOrder;
    }

    public void setPriceAllOrder(Double priceAllOrder) {
        this.priceAllOrder = priceAllOrder;
    }

    public Integer getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(Integer tableNumber) {
        this.tableNumber = tableNumber;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}
