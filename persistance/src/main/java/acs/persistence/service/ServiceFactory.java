package acs.persistence.service;

import acs.persistence.service.impl.*;

/**
 * Created with IntelliJ IDEA.
 * User: oksana
 * Date: 28.05.14
 */
public class ServiceFactory{

    private static CategoryMenuService categoryMenuService;
    private static ClientService clientService;
    private static DishService dishService;
    private static OrderService orderService;
    private static OrderItemService orderItemService;

    public static CategoryMenuService getCategoryMenuService() {
        if(categoryMenuService == null){
            return new CategoryMenuServiceImpl();
        }
        return categoryMenuService;
    }

    public ClientService getClientService() {
        if(clientService == null){
            return new ClientServiceImpl();
        }
        return clientService;
    }

    public DishService getDishService() {
        if(dishService == null){
            return new DishServiceImpl();
        }
        return dishService;
    }

    public OrderService getOrderService() {
        if(orderService == null){
            return new OrderServiceImpl();
        }
        return orderService;
    }

    public OrderItemService getOrderItemService(){
        if(orderItemService == null){
            return new OrderItemServiceImpl();
        }
        return orderItemService;
    }
}
