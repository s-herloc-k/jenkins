package com.restaurant.my.controllers;

import com.restaurant.my.models.Menu;
import com.restaurant.my.rep.MenuRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class RestaurantController {
    @Autowired
    private MenuRep menuRepository;

    @GetMapping("/menu")
    public String menu(Model model) {
        Iterable<Menu> menu = menuRepository.findAll();
        model.addAttribute("menu", menu);
        return "menu";
    }

    @GetMapping("/menu/add")
    public String menuAdd(Model model) {
        return "menu-add";
    }

    @PostMapping("/menu/add")
    public String menuDishAdd(@RequestParam String name, @RequestParam String description, @RequestParam String category, @RequestParam int price, @RequestParam int weight, Model model) {
        Menu dish = new Menu(name, description, category, price, weight);
        menuRepository.save(dish);
        return "redirect:/menu";
    }

    @GetMapping("/menu/{id}/edit")
    public String dishEdit(@PathVariable(value = "id") long id, Model model) {
        if(!menuRepository.existsById(id)) {
            return "redirect:/menu";
        }
        Optional<Menu> dish = menuRepository.findById(id);
        ArrayList<Menu> res = new ArrayList<>();
        dish.ifPresent(res::add);
        model.addAttribute("menu", res);
        return "menu-edit";
    }

    @PostMapping("/menu/{id}/edit")
    public String menuDishUpdate(@PathVariable(value = "id") long id, @RequestParam String name, @RequestParam String description, @RequestParam String category, @RequestParam int price, @RequestParam int weight, Model model) {
        Menu menu = menuRepository.findById(id).orElseThrow();
        menu.setName(name);
        menu.setCategory(category);
        menu.setDescription(description);
        menu.setWeight(weight);
        menu.setPrice(price);
        menuRepository.save(menu);
        return "redirect:/menu";
    }

    @PostMapping("/menu/{id}/remove")
    public String menuDishDelete(@PathVariable(value = "id") long id, Model model) {
        Menu menu = menuRepository.findById(id).orElseThrow();
        menuRepository.delete(menu);
        return "redirect:/menu";
    }

    public void setMenuRepository(MenuRep menuRepository) {
    }
}
