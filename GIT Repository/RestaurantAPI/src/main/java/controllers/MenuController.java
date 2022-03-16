package controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import dtos.MenuDto;
import models.Menu;
import services.MenuService;
import utils.Converter;
import utils.MenuReturns;

@RestController
@RequestMapping("/api/v1/Menu")
public class MenuController {

	@Autowired
	final MenuService menuService;

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
		MenuReturns retValues = new MenuReturns();
		Converter converter = new Converter();
		Menu menuModel = new Menu();
		try {

			menuService.save(converter.menuDtoToModel(menuDto, menuModel));

			retValues.setMsg("Order added successfully");
			retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
			retValues.setStatus("OK");
			retValues.setStatusCode("200");
			retValues.setResValues(menuModel);
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

	@PostMapping
	@RequestMapping("/updateMenu/{id}")
	public MenuReturns updateMenu(@PathVariable(value = "id") Integer id, @RequestBody MenuDto menuDto) {

		Optional<Menu> currentOptional = menuService.findById(id);
		MenuReturns retValues = new MenuReturns();
		Converter converter = new Converter();

		try {
			if (currentOptional.isEmpty()) {

				retValues.setStatus("NOK");
				retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
				retValues.setStatusCode("500");
				retValues.setMsg("Menu ID was not found");

			}
			Menu menuModel = currentOptional.get();
			menuService.save(converter.menuDtoToModel(menuDto, menuModel));

			retValues.setStatus("OK");
			retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
			retValues.setStatusCode("200");
			retValues.setMsg("Order updated succesfully!");
			retValues.setResValues(menuModel);

			return retValues;
		} catch (Exception e) {
			e.getMessage();
		}
		return retValues;
	}

	@DeleteMapping("/{id}")
	public MenuReturns deleteMenu(@PathVariable(value = "id") @RequestBody Integer id){
		MenuReturns retValues = new MenuReturns();
		Optional<Menu> menuOptional = menuService.findById(id);

		if (menuOptional.isEmpty()) {
			retValues.setStatus("NOK");
			retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
			retValues.setStatusCode("500");
			retValues.setMsg("Could not find the ID you provided.");
			return retValues;
		}
		menuService.delete(menuOptional.get());
		retValues.setStatus("OK");
		retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
		retValues.setStatusCode("200");
		retValues.setMsg("Your menu was succesfully canceled.");
		return retValues;
	}
}
