package com.restaurant.my.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    @Test
    void getId() {

        Menu menu = new Menu();
        Long id = 1L;
        menu.setId(id);

        Long result = menu.getId();

        assertEquals(id, result);
    }

    @Test
    void getName() {

        Menu menu = new Menu();
        String name = "Dish1";
        menu.setName(name);

        String result = menu.getName();

        assertEquals(name, result);
    }

    @Test
    void setPrice() {

        Menu menu = new Menu();
        int price = 10;

        menu.setPrice(price);

        assertEquals(price, menu.getPrice());
    }

    @Test
    void testConstructorWithParameters() {

        String name = "Dish1";
        String description = "Description1";
        String category = "Category1";
        int price = 10;
        int weight = 100;

        Menu menu = new Menu(name, description, category, price, weight);

        assertEquals(name, menu.getName());
        assertEquals(description, menu.getDescription());
        assertEquals(category, menu.getCategory());
        assertEquals(price, menu.getPrice());
        assertEquals(weight, menu.getWeight());
    }
}