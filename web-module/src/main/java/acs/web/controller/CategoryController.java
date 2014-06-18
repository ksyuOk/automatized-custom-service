package acs.web.controller;

import acs.persistence.model.CategoryMenu;
import acs.persistence.model.Dish;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.*;

/**
 * Created by vbiloshkurskyi on 6/13/14.
 */
@Controller("")
public class CategoryController {

//    @Autowired
//    private CategoryMenuService categoryMenuService;

    @RequestMapping(value = "/service/categories", method = RequestMethod.GET, produces = {"application/json"})
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

    @RequestMapping(value = "/service/categories/image/{categoryId}.png", method = RequestMethod.GET, produces = {MediaType.IMAGE_PNG_VALUE})
    @ResponseBody
    public byte[] getCategoryImage(@PathVariable int categoryId) throws IOException {

        return IOUtils.toByteArray(CategoryController.class.getResourceAsStream("/img/men.png"));


//        return categoryMenuService.getCategoryImage(categoryId);
    }
}
