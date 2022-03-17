package pt.restaurant.Entregas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pt.restaurant.Entregas.dtos.MenuDto;
import pt.restaurant.Entregas.models.Menu;
import pt.restaurant.Entregas.services.MenuService;
import pt.restaurant.Entregas.utils.Converter;
import pt.restaurant.Entregas.utils.MenuReturns;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/Menu")
public class MenuController {

    @Autowired
    final MenuService menuService;

    //Logger log = LogFactory

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/getAll")
    public List<Menu> getAll() {
        return menuService.findAll();
    }

    @PostMapping
    @RequestMapping("/addMenu")
    public MenuReturns addMenu(@RequestBody MenuDto menuDto) {
        //public MenuReturns addMenu(@RequestBody Menu menu) {
        MenuReturns retValues = new MenuReturns();
        Converter converter = new Converter();
        Menu menuModel = new Menu();
        try {
            menuService.save(converter.menuDtoToModel(menuDto, menuModel));
            System.out.println("Menu :" + menuDto);
            retValues.setMsg("Order added successfully");
            retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
            retValues.setStatus("OK");
            retValues.setStatusCode("200");
            retValues.setResValues(menuModel);
            //return retValues;

        } catch (Exception e) {
            retValues.setMsg("ERROR: " + e.getMessage());
            retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
            retValues.setStatus("NOK");
            retValues.setStatusCode("400");
        }

        return retValues;
    }

    @PostMapping
    @RequestMapping("/updateMenu")
    public MenuReturns updateMenu( @RequestBody Menu menu) {

        Optional<Menu> currentOptional = menuService.findById(id);
        MenuReturns retValues = new MenuReturns();
        Converter converter = new Converter();

        try {
            if (currentOptional.isPresent()) {
                Menu menuModel = currentOptional.get();
                menuService.save(converter.menuDtoToModel(menuDto, menuModel));

                retValues.setStatus("OK");
                retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
                retValues.setStatusCode("200");
                retValues.setMsg("Order updated successfully!");
                retValues.setResValues(menuModel);
            }
        } catch (Exception e) {

            retValues.setStatus("ERROR: " + e.getMessage());
            retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
            retValues.setStatusCode("500");
            retValues.setMsg("Menu ID was not found");
        }
        return retValues;
    }

    @DeleteMapping("/{id}")
    public MenuReturns deleteMenu(@PathVariable(value = "id") @RequestBody Integer id) {
        MenuReturns retValues = new MenuReturns();
        Optional<Menu> menuOptional = menuService.findById(id);
        try {
            if (menuOptional.isPresent()) {

                menuService.delete(menuOptional.get());
                retValues.setStatus("OK");
                retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
                retValues.setStatusCode("200");
                retValues.setMsg("Your menu was successfully canceled.");

            }
        } catch (Exception e) {
            retValues.setStatus("NOK");
            retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
            retValues.setStatusCode("500");
            retValues.setMsg("Could not find the ID you provided.");

        }
        return retValues;
    }
}
