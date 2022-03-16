package utils;

import dtos.MenuDto;
import dtos.OrderDto;
import models.Menu;
import models.Order;

public class Converter {

	public Order orderDtotoModel(OrderDto orderDto, Order order) {
		order.setCustomer_name(orderDto.getCustomer_name());
		order.setOrder_delivery_address(orderDto.getOrder_delivery_adress());
		order.setOrder_status(orderDto.getOrder_status());
		return order;
	}

	public OrderDto ordertoModel(OrderDto orderDto, Order order) {
		orderDto.setCustomer_name(order.getCustomer_name());
		orderDto.setOrder_delivery_adress(order.getOrder_delivery_address());
		orderDto.setOrder_status(order.getOrder_status());
		return orderDto;
	}

	public Menu menuDtoToModel(MenuDto menuDto, Menu menu) {
		menu.setDish_availability(menuDto.getDish_availability());
		menu.setDish_name(menuDto.getDish_name());
		menu.setDish_on_sale(menuDto.getDish_on_sale());
		menu.setStarting_selling_period(menuDto.getDish_selling_period());
		return menu;
	}

	public MenuDto menuToModel(MenuDto menuDto, Menu menu) {
		menuDto.setDish_availability(menu.getDish_availability());
		menuDto.setDish_name(menu.getDish_name());
		menuDto.setDish_on_sale(menu.getDish_on_sale());
		menuDto.setDish_selling_period(menu.getStarting_selling_period());
		return menuDto;
	}
}
