package entities;

import org.hibernate.annotations.Tables;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: oksana
 * Date: 09.05.14
 */

@Entity
@Table(name = "dish")
public class Dish {

    @Id
    @Column(name = "dish_id", nullable = false)
    Integer dishId;

    @Column(name = "category_id", nullable = false)
    Integer category_id;

    @Column(name = "dish_name", nullable = false)
    String dishName;

    @Column(name = "description", nullable = true)
    String description;

    @Column(name = "time_cook", nullable = true)
    Date timeCook;

    @Column(name = "price", nullable = false)
    Double price;

    @Column(name = "large_image_dish", nullable = false)
    Byte largeImageDish;

    @Column(name = "image_dish", nullable = false)
    Byte imageDish;

    @ManyToOne
    @JoinColumn(name = "category_id")
    public CategoryMenu getCategoryMenu(){

    }

    public Integer getDishId() {
        return dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTimeCook() {
        return timeCook;
    }

    public void setTimeCook(Date timeCook) {
        this.timeCook = timeCook;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Byte getLargeImageDish() {
        return largeImageDish;
    }

    public void setLargeImageDish(Byte largeImageDish) {
        this.largeImageDish = largeImageDish;
    }

    public Byte getImageDish() {
        return imageDish;
    }

    public void setImageDish(Byte imageDish) {
        this.imageDish = imageDish;
    }

    @Override
    public int hashCode(){
        int hash = 0;
        hash += (this.dishId != null ? this.dishId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object){
        if (!(object instanceof Dish)){
            return false;
        }
        Dish other = (Dish) object;
        if(this.dishId != other.dishId && (this.dishId == null || !this.dishId.equals(other.dishId))){
            return false;
        }
        return true;
    }
}
