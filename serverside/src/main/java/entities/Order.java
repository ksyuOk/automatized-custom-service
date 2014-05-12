package entities;

import javax.persistence.*;
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
    String responceDescription;

    @Column(name = "status", nullable = false)
    String status;

    @ManyToOne
    @JoinColumn(name = "client_id")
    public Client getClient(){

    }

    @OneToMany
    @JoinColumn(name = "")


    public String getResponceDescription() {
        return responceDescription;
    }

    public void setResponceDescription(String responce_description) {
        this.responceDescription = responce_description;
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

    @Override
    public int hashCode(){
        int hash = 0;
        hash += (this.orderId != null ? this.orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object){
        if (!(object instanceof Order)){
            return false;
        }
        Order other = (Order) object;
        if(this.orderId != other.orderId && (this.orderId == null || !this.orderId.equals(other.orderId))){
            return false;
        }
        return true;
    }
}
