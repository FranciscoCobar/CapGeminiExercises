package pt.restaurant.Entregas.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import pt.restaurant.Entregas.models.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
