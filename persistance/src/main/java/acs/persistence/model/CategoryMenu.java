package acs.persistence.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: oksana
 * Date: 09.05.14
 */

@Entity
@Table(name = "category_menu")
public class CategoryMenu extends BaseEntity {

    @Id
    @Column(name = "category_id", nullable = false)
    Integer id;

    @Column(name = "category_name", nullable = false)
    String name;

    @Column(name = "image", nullable = true)
    byte[] image;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private Set<Dish> dishes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(Set<Dish> dishes) {
        this.dishes = dishes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public int hashCode(){
        int hash = 0;
        hash += (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object){
        if (!(object instanceof CategoryMenu)){
            return false;
        }
        CategoryMenu other = (CategoryMenu) object;
        if(this.id != other.id && (this.id == null || !this.id.equals(other.id))){
            return false;
        }
        return true;
    }
}
