package entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: oksana
 * Date: 09.05.14
 */

@Entity
@Table(name = "order_item")
public class OrderItem {

    @Id
    @Column(name = "order_item_id", nullable = false)
    Integer orderItemId;

    @Column(name = "order_id", nullable = false)
    Integer orderId;

    @Column(name = "dish_id", nullable = false)
    Integer dishId;

    @Column(name = "count", nullable = false)
    Integer count;

    @Column(name = "price", nullable = false)
    Integer price;

    @ManyToOne
    @JoinColumn(name = "order_id")
    public Order getOrder(){

    }

    @OneToOne(mappedBy = "")

    public Integer getOrder_item_id() {
        return orderItemId;
    }

    public void setOrder_item_id(Integer order_item_id) {
        this.orderItemId = order_item_id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public int hashCode(){
        int hash = 0;
        hash += (this.orderItemId != null ? this.orderItemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object){
        if (!(object instanceof OrderItem)){
            return false;
        }
        OrderItem other = (OrderItem) object;
        if(this.orderItemId != other.orderItemId && (this.orderItemId == null || !this.orderItemId.equals(other.orderItemId))){
            return false;
        }
        return true;
    }
}
