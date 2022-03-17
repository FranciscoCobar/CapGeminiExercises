package pt.restaurant.Entregas.utils;

import pt.restaurant.Entregas.dtos.MenuDto;
import pt.restaurant.Entregas.dtos.OrderDto;
import pt.restaurant.Entregas.models.Menu;
import pt.restaurant.Entregas.models.Order;

public class Converter {

    public Order orderDtotoModel(OrderDto orderDto, Order order) {
        order.setCustomer_name(orderDto.getCustomer_name());
        order.setOrder_delivery_address(orderDto.getOrder_delivery_address());
        order.setQuantity(orderDto.getQuantity());
        order.setDish_name(orderDto.getDish_name());
        return order;
    }

    public Menu menuDtoToModel(MenuDto menuDto, Menu menu) {
        menu.setDish_availability(menuDto.getDish_availability());
        menu.setDish_name(menuDto.getDish_name());
        menu.setDish_on_sale(menuDto.getDish_on_sale());
        menu.setStarting_selling_period(menuDto.getStarting_selling_period());
        menu.setEnd_selling_period(menuDto.getEnd_selling_period());
        return menu;
    }

}