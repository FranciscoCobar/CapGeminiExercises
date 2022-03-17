package pt.restaurant.Entregas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.restaurant.Entregas.models.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer> {
}
