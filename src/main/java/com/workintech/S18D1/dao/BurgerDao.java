package com.workintech.S18D1.dao;

import java.util.List;
import java.util.TreeSet;

import com.workintech.S18D1.entity.BreadType;
import com.workintech.S18D1.entity.Burger;

public interface BurgerDao {
    Burger save(Burger burger);

    Burger findById(int id);

    List<Burger> findAll();

    List<Burger> findByPrice(double price);

    List<Burger> findByBreadType(BreadType breadType);

    List<Burger> findByContent(String contents);

    Burger update(Burger burger);

    void remove(Burger burger);

}
