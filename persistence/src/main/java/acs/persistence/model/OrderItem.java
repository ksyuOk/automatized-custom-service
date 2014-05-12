package acs.persistence.model;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: oksana
 * Date: 09.05.14
 */

@Entity
@Table(name = "order_item")
public class OrderItem extends BaseEntity {

    @Id
    @Column(name = "order_item_id", nullable = false)
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "dish_id", nullable = false)
    Integer dishId;

    @Column(name = "count", nullable = false)
    Integer count;

    @Column(name = "price", nullable = false)
    Integer price;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        hash += (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object){
        if (!(object instanceof OrderItem)){
            return false;
        }
        OrderItem other = (OrderItem) object;
        if(this.id != other.id && (this.id == null || !this.id.equals(other.id))){
            return false;
        }
        return true;
    }
}
