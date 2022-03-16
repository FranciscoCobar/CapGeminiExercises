package controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import models.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import dtos.OrderDto;
import models.Order;
import services.OrderService;
import utils.MenuReturns;
import utils.OrderReturns;
import utils.Converter;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

	@Autowired
	final OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@GetMapping("/getAll")
	public List<Order> getAll() {
		return orderService.findAll();
	}

	@PostMapping("/getById/{id}")
	public OrderReturns getById(@PathVariable(value = "id") Integer id){
		OrderReturns retValues = new OrderReturns();
		retValues.setResValues(orderService.findByIdOrder(id));
		return retValues;
	}

	@PostMapping("/addOrder")
	public OrderReturns addOrder(@RequestBody OrderDto orderDto) {
		OrderReturns retValues = new OrderReturns();
		Converter converter = new Converter();
		Order orderModel = new Order();

		try {
			orderService.save(converter.orderDtotoModel(orderDto, orderModel));

			retValues.setMsg("Order added successfully");
			retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
			retValues.setStatus("OK");
			retValues.setStatusCode("200");
			retValues.setResValues(orderModel);

			return retValues;
		} catch (Exception e) {
			e.getMessage();
		}

		retValues.setMsg("Order not added");
		retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
		retValues.setStatus("NOK");
		retValues.setStatusCode("400");

		return retValues;
	}


	@PostMapping("/updateOrder/{id}")
	public OrderReturns updateOrder(@PathVariable(value = "id") Integer id, @RequestBody OrderDto orderDto) {
		Optional<Order> currentOptional = orderService.findById(id);
		OrderReturns retValues = new OrderReturns();
		Converter converter = new Converter();

		try {
			if (currentOptional.isEmpty()) {

				retValues.setStatus("NOK");
				retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
				retValues.setStatusCode("500");
				retValues.setMsg("Menu ID was not found");

			}
			Order orderModel = currentOptional.get();
			orderService.save(converter.orderDtotoModel(orderDto, orderModel));

			retValues.setStatus("OK");
			retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
			retValues.setStatusCode("200");
			retValues.setMsg("Order updated succesfully!");
			retValues.setResValues(orderModel);

			return retValues;
		} catch (Exception e) {
			e.getMessage();
		}
		return retValues;
	}

	@DeleteMapping("/{id}")
	public OrderReturns deleteMenu(@PathVariable(value = "id") @RequestBody Integer id){
		OrderReturns retValues = new OrderReturns();
		Optional<Order> orderOptional = orderService.findById(id);

		if (orderOptional.isEmpty()) {
			retValues.setStatus("NOK");
			retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
			retValues.setStatusCode("500");
			retValues.setMsg("Could not find the ID you provided.");
			return retValues;
		}
		orderService.delete(orderOptional.get());
		retValues.setStatus("OK");
		retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
		retValues.setStatusCode("200");
		retValues.setMsg("Your order was succesfully canceled.");
		return retValues;
	}
}
