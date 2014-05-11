package src.main.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
    Integer order_item_id;

    @Column(name = "count", nullable = false)
    Integer count;

    @Column(name = "price", nullable = false)
    Integer price;

    public Integer getOrder_item_id() {
        return order_item_id;
    }

    public void setOrder_item_id(Integer order_item_id) {
        this.order_item_id = order_item_id;
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
}
