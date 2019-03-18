package com.workspaceit.controller.api;

import com.workspaceit.entity.FoodItems;
import com.workspaceit.service.FoodItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageControllerApi {

    @Autowired
    FoodItemsService foodItemsService;

    @RequestMapping(value = "/")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home/index");
        return mv;
    }

    @RequestMapping(value = "/home")
    public ModelAndView homePage (){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home/index");
        mv.addObject("userClickHome", true);
        return mv;
    }

    @RequestMapping(value = "/meat-meal")
    public ModelAndView meatMealPage (){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home/index");
        mv.addObject("userClickMeatMeal", true);
        return mv;
    }

    @RequestMapping(value = "/burger")
    public ModelAndView burgerPage (){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home/index");
        mv.addObject("userClickBurger", true);
        return mv;
    }

    @RequestMapping(value = "/pizza")
    public ModelAndView pizzaPage (){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home/index");
        mv.addObject("userClickPizza", true);
        return mv;
    }

    @RequestMapping(value = "/rice-meal")
    public ModelAndView riceMealPage (){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home/index");
        mv.addObject("userClickRiceMeal", true);
        return mv;
    }

    @RequestMapping(value = "/snack")
    public ModelAndView snackPage (){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home/index");
        mv.addObject("userClickSnack", true);
        return mv;
    }

    @RequestMapping(value = "/drink")
    public ModelAndView drinkPage (){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home/index");
        mv.addObject("userClickDrink", true);
        return mv;
    }

    @RequestMapping(value = "/burger/{id}/single-item")
    public ModelAndView getSingleItemDetails(@PathVariable int id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home/index");
        FoodItems foodItem = this.foodItemsService.getItemByid(id);
        mv.addObject("userClickSingleItem", true);
        mv.addObject("foodItem", foodItem);

        System.out.println(foodItem.getTypeName());

        return mv;
    }


    /*@RequestMapping(value = "/single-item/{id}/add-to-card")
    public ModelAndView addToCard (@PathVariable int id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home/index");
        mv.addObject("userClickAddToCard", true);

        return mv;
    }*/
}
