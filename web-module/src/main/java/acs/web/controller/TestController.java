package acs.web.controller;

import acs.persistence.model.OrderItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/service/message/{id}", method = RequestMethod.GET)
    @ResponseBody
    public OrderItem getOrderItem(@PathVariable(value = "id") Integer id, Model model) {
        OrderItem orderItem = new OrderItem();
        orderItem.setId(id);
        orderItem.setCount(2);
        orderItem.setPrice(10);
        return orderItem;
    }


}
