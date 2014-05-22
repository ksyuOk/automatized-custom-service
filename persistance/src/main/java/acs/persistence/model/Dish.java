package acs.persistence.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: oksana
 * Date: 09.05.14
 */

@Entity
@Table(name = "dish")
public class Dish extends BaseEntity {

    @Id
    @Column(name = "dish_id", nullable = false)
    Integer id;

    @Column(name = "dish_name", nullable = false)
    String dishName;

    @Column(name = "description", nullable = true)
    String description;

    @Column(name = "time_cook", nullable = true)
    Date timeCook;

    @Column(name = "price", nullable = false)
    Double price;

    @Column(name = "large_image_dish", nullable = false)
    byte [] largeImageDish;

    @Column(name = "image_dish", nullable = false)
    byte [] imageDish;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryMenu categoryMenu;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public byte[] getLargeImageDish() {
        return largeImageDish;
    }

    public void setLargeImageDish(byte[] largeImageDish) {
        this.largeImageDish = largeImageDish;
    }

    public byte[] getImageDish() {
        return imageDish;
    }

    public void setImageDish(byte[] imageDish) {
        this.imageDish = imageDish;
    }

    public CategoryMenu getCategoryMenu() {
        return categoryMenu;
    }

    public void setCategoryMenu(CategoryMenu categoryMenu) {
        this.categoryMenu = categoryMenu;
    }

    @Override
    public int hashCode(){
        int hash = 0;
        hash += (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object){
        if (!(object instanceof Dish)){
            return false;
        }
        Dish other = (Dish) object;
        if(this.id != other.id && (this.id == null || !this.id.equals(other.id))){
            return false;
        }
        return true;
    }
}
