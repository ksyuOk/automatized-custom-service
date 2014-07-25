package acs.web.controller;

import acs.persistence.model.Dish;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class DishesController {

    @RequestMapping(value = "/service/category/{name}/dishes", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public List<Dish> getDishesByCategoryName(){
        List<Dish> dishes = new ArrayList<Dish>();

        Dish dish1 = new Dish();
        dish1.setId(1);
        dish1.setDishName("Ceaser");
        dish1.setPrice(48.0);
        dish1.setTimeCook(new Date(20));
        dish1.setDescription("Ingredients of this dish are: eggs, meat, meat, meat");

        Dish dish2 = new Dish();
        dish2.setId(2);
        dish2.setDishName("Ceaser");
        dish2.setPrice(48.0);
        dish2.setTimeCook(new Date(20));
        dish2.setDescription("Ingredients of this dish are: eggs, meat, meat, meat");
        Dish dish3 = new Dish();
        dish3.setId(3);
        dish3.setDishName("Ceaser");
        dish3.setPrice(48.0);
        dish3.setTimeCook(new Date(20));
        dish3.setDescription("Ingredients of this dish are: eggs, meat, meat, meat");
        Dish dish4 = new Dish();
        dish4.setId(4);
        dish4.setDishName("Ceaser");
        dish4.setPrice(48.0);
        dish4.setTimeCook(new Date(20));
        dish4.setDescription("Ingredients of this dish are: eggs, meat, meat, meat");
        Dish dish5 = new Dish();
        dish5.setId(5);
        dish5.setDishName("Ceaser");
        dish5.setPrice(48.0);
        dish5.setTimeCook(new Date(20));
        dish5.setDescription("Ingredients of this dish are: eggs, meat, meat, meat");
        Dish dish6 = new Dish();
        dish6.setId(6);
        dish6.setDishName("Ceaser");
        dish6.setPrice(48.0);
        dish6.setTimeCook(new Date(20));
        dish6.setDescription("ingredients of this dish are: eggs, meat, meat, meat");

        dishes.add(dish1);
        dishes.add(dish2);
        dishes.add(dish3);
        dishes.add(dish4);
        dishes.add(dish5);
        dishes.add(dish6);

        return dishes;
    }
}
