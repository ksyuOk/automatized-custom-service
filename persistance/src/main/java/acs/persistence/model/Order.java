package acs.persistence.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: oksana
 * Date: 09.05.14
 */

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    @Id
    @Column(name = "order_id", nullable = false)
    Integer id;

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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order",  cascade = {CascadeType.ALL})
    private List<OrderItem> orderItems;

    @ManyToOne()
    @JoinColumn(name = "client_id")
    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode(){
        int hash = 0;
        hash += (this.id!= null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object){
        if (!(object instanceof Order)){
            return false;
        }
        Order other = (Order) object;
        if(this.id != other.id && (this.id == null || !this.id.equals(other.id))){
            return false;
        }
        return true;
    }
}
