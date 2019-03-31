package com.workspaceit.controller.webview;

import com.workspaceit.entity.FoodItems;
import com.workspaceit.service.FoodItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/pizza")
public class PizzaItemApi {

    @Autowired
    private FoodItemsService foodItemsService;

    @ResponseBody
    @RequestMapping(value = "/pizza-item-list")
    public List<FoodItems> pizzaItems () {

        String category = "Pizza";
        List<FoodItems> foodItems = this.foodItemsService.getAllByCategory(category);
        return foodItems;
    }
}
