package pt.restaurant.Entregas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pt.restaurant.Entregas.dtos.OrderDto;
import pt.restaurant.Entregas.models.Order;
import pt.restaurant.Entregas.services.OrderService;
import pt.restaurant.Entregas.utils.Converter;
import pt.restaurant.Entregas.utils.OrderReturns;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

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
    public OrderReturns getById(@PathVariable(value = "id") Integer id) {
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

        } catch (Exception e) {
            retValues.setMsg("Order not added: " + e.getMessage());
            retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
            retValues.setStatus("NOK");
            retValues.setStatusCode("400");
        }
        return retValues;
    }


    @PostMapping("/updateOrder")
    public OrderReturns updateOrder(@RequestBody Order order) {
        OrderReturns retValues = new OrderReturns();
        Order newOrder;

        try {

            newOrder = orderService.getByTransaction(order);
            orderService.save(newOrder);

            retValues.setStatus("OK");
            retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
            retValues.setStatusCode("200");
            retValues.setMsg("Order updated successfully!");
            retValues.setResValues(order);


        } catch (Exception e) {

            retValues.setStatus("ERROR: " + e.getMessage());
            retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
            retValues.setStatusCode("500");
            retValues.setMsg("Menu ID was not found");
        }
        return retValues;
    }

    @DeleteMapping("/{id}")
    public OrderReturns deleteMenu(@PathVariable(value = "id") @RequestBody Integer id) {
        OrderReturns retValues = new OrderReturns();
        Optional<Order> orderOptional = orderService.findById(id);

        try {

            if (orderOptional.isPresent()) {
                orderService.delete(orderOptional.get());
                retValues.setStatus("OK");
                retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
                retValues.setStatusCode("200");
                retValues.setMsg("Your order was successfully canceled.");

            }
        } catch (Exception e) {

            retValues.setStatus("ERROR: " + e.getMessage());
            retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
            retValues.setStatusCode("500");
            retValues.setMsg("Could not find the ID you provided.");
        }
        return retValues;
    }
}