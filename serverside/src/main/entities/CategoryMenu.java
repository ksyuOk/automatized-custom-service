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
@Table(name = "category_menu")
public class CategoryMenu {

    @Id
    @Column(name = "category_id", nullable = false)
    Integer category_id;
    @Column(name = "category_name", nullable = false)
    String category_name;
    @Column(name = "image", nullable = false)
    Byte image;

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
}
