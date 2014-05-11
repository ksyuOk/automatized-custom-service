package src.main.entities;

import org.hibernate.annotations.Tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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

}
