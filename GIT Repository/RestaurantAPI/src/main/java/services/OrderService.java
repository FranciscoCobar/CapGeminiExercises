package services;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import models.Order;
import repositories.OrderRepository;
import utils.FoodStatus;
import utils.OrderReturns;

@Service
public class OrderService{

	
	final OrderRepository orderRepository;
	final OrderReturns orderReturns;
	
	public OrderService(OrderRepository orderRepository, OrderReturns orderReturns) {
		this.orderRepository = orderRepository;
		this.orderReturns = orderReturns;
	}
	
	@Transactional
	public Order save(Order order) {
		return orderRepository.saveAndFlush(order);
	}
	
	public List<Order> findAll() {
		return orderRepository.findAll();
	}
	
	public Optional<Order> findById(Integer id) {
		return orderRepository.findById(id);
	}
	public Order findByIdOrder(Integer id){
		return orderRepository.getById(id);
	}
	@Transactional
	public void delete(Order order) {
		orderRepository.delete(order);
	}
	
	public void statusUpdate() {
		
		orderReturns.setFoodStatus(FoodStatus.ACCEPTED);
		orderReturns.setFoodStatus(FoodStatus.AWAITINGDELIVERY);
		orderReturns.setFoodStatus(FoodStatus.COOKING);
		orderReturns.setFoodStatus(FoodStatus.INROUTE);
		orderReturns.setFoodStatus(FoodStatus.DELIVERED);
	}
	
	
}
