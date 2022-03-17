package pt.restaurant.Entregas.services;

import org.springframework.stereotype.Service;
import pt.restaurant.Entregas.models.Order;
import pt.restaurant.Entregas.repositories.OrderRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {

    final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    public Order save(Order order) {
        order.setTransactionID(UUID.randomUUID().toString());
        return orderRepository.saveAndFlush(order);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Optional<Order> findById(Integer id) {
        return orderRepository.findById(id);
    }

    public Order findByIdOrder(Integer id) {
        return orderRepository.getById(id);
    }

    @Transactional
    public void delete(Order order) {
        orderRepository.delete(order);
    }

    public Order getByTransaction(Order order){
        for(Order itOrder :orderRepository.findAll()){
            if(Objects.equals(order.getTransactionID(), itOrder.getTransactionID())){
                return order;
            }
        }
        return order;
    }

    /*public void statusUpdate() {

        orderReturns.setFoodStatus(FoodStatus.ACCEPTED);
        orderReturns.setFoodStatus(FoodStatus.AWAITINGDELIVERY);
        orderReturns.setFoodStatus(FoodStatus.COOKING);
        orderReturns.setFoodStatus(FoodStatus.INROUTE);
        orderReturns.setFoodStatus(FoodStatus.DELIVERED);
    }*/
}
