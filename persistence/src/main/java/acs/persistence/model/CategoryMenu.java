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
    @Column(name = "categoryId", nullable = false)
    Integer id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "image", nullable = false)
    byte[] image;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private Set<Dish> dishs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Dish> getDishs() {
        return dishs;
    }

    public void setDishs(Set<Dish> dishs) {
        this.dishs = dishs;
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
