package entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: oksana
 * Date: 09.05.14
 */

@Entity
@Table(name = "category_menu")
public class CategoryMenu {

    @Id
    @Column(name = "category_id", nullable = false)
    Integer category_id;

    @Column(name = "category_name", nullable = false)
    String category_name;

    @Column(name = "image", nullable = false)
    Byte image;

    @OneToMany(mappedBy = "")
    public Set<Dish> getDishes(){

    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public Byte getImage() {
        return image;
    }

    public void setImage(Byte image) {
        this.image = image;
    }

    @Override
    public int hashCode(){
        int hash = 0;
        hash += (this.category_id != null ? this.category_id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object){
        if (!(object instanceof CategoryMenu)){
            return false;
        }
        CategoryMenu other = (CategoryMenu) object;
        if(this.category_id != other.category_id && (this.category_id == null || !this.category_id.equals(other.category_id))){
            return false;
        }
        return true;
    }
}
