package com.workintech.S18D1.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workintech.S18D1.dao.BurgerDao;
import com.workintech.S18D1.entity.BreadType;
import com.workintech.S18D1.entity.Burger;

import jakarta.validation.constraints.Positive;

import java.util.List;

@RestController
@RequestMapping("/burger")
public class BurgerController {
    private BurgerDao BurgerDao;

    public BurgerController(BurgerDao BurgerDao) {
        this.BurgerDao = BurgerDao;
    }

    @PostMapping("/")
    public Burger save(@Validated @RequestBody Burger burger) {// @validated diyerek Burger de yazdığımız validasyon
                                                               // kurallarına bak diyoruz
        return BurgerDao.save(burger);
    }

    @GetMapping("/")
    public List<Burger> get() {
        return BurgerDao.findAll();
    }

    @GetMapping("/{id}")
    public Burger find(@Positive @RequestBody int id) {
        return BurgerDao.findById(id);
    }

    @GetMapping("/findByPrice/{price}")
    public List<Burger> findByPrice(@PathVariable int price) {
        return BurgerDao.findByPrice(price);
    }

    @PutMapping("/")
    public Burger update(@RequestBody Burger burger) {
        return BurgerDao.update(burger);
    }

    @DeleteMapping("/{id}")
    public Burger remove(@PathVariable int id) {
        Burger burger = find(id);
        BurgerDao.remove(burger);
        return burger;
    }

    @GetMapping("/findByBreadType/{breadType}")
    public List<Burger> findByBreadType(@PathVariable String breadType) {
        return BurgerDao.findByBreadType(BreadType.BURGER);
    }
}
