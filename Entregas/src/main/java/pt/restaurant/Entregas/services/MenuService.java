package pt.restaurant.Entregas.services;

import org.springframework.stereotype.Service;
import pt.restaurant.Entregas.models.Menu;
import pt.restaurant.Entregas.models.Order;
import pt.restaurant.Entregas.repositories.MenuRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MenuService {
    final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }
    @Transactional
    public Menu save(Menu menu) {
        return menuRepository.saveAndFlush(menu);
    }
    public List<Menu> findAll() {
        return menuRepository.findAll();
    }
    public Optional<Menu> findById(Integer id) {
        return menuRepository.findById(id);
    }
    @Transactional
    public void delete(Menu menu) {
        menuRepository.delete(menu);
    }
    public Menu getByDish(Menu menu){
        for(Menu itMenu :menuRepository.findAll()){
            if(Objects.equals(menu.getDish_name(), itMenu.getDish_name())){
                return menu;
            }
        }
        return menu;
    }

}