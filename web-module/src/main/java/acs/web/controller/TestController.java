package acs.web.controller;

import acs.persistence.model.CategoryMenu;
import acs.persistence.model.Dish;
import acs.persistence.model.OrderItem;
import acs.persistence.service.CategoryMenuService;
import acs.persistence.service.ServiceFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by vbiloshkurskyi on 5/14/14.
 */
@Controller
public class TestController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String message(@RequestParam(value="message", required=false) String name, Model model) {
        model.addAttribute("message", name);
        return "test";
    }

    @RequestMapping(value = "/service/message/{id}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public OrderItem getOrderItem(@PathVariable(value = "id") Integer id, Model model) {
        OrderItem orderItem = new OrderItem();
        orderItem.setId(id);
        orderItem.setCount(2);
        orderItem.setPrice(10);
        return orderItem;
    }

    @RequestMapping(value = "/service/categories/all", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public List<CategoryMenu> getAllCategories(){
        List<CategoryMenu> allCategoriesMenu = new LinkedList<CategoryMenu>();

        CategoryMenu categorySnacks = new CategoryMenu();
        categorySnacks.setName("Snacks");
        Set<Dish> dishSetOfSnacks = new HashSet<Dish>();

        Dish caesar = new Dish();
        caesar.setDishName("Caesar");
        caesar.setCategoryMenu(categorySnacks);
        caesar.setDescription("Caesar includes different delicious ingredients");
        caesar.setPrice(45.0);
        caesar.setTimeCook(new Date(20));
        dishSetOfSnacks.add(caesar);
        categorySnacks.getDishes().add(caesar);

        allCategoriesMenu.add(categorySnacks);
        return allCategoriesMenu;
    }
}
