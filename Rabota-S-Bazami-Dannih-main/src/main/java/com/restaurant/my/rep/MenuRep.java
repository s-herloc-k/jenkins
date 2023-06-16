package com.restaurant.my.rep;

import com.restaurant.my.models.Menu;
import org.springframework.data.repository.CrudRepository;

public interface MenuRep extends CrudRepository<Menu, Long> {

}
