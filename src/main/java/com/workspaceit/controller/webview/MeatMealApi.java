package com.workspaceit.controller.webview;

import com.workspaceit.entity.FoodItems;
import com.workspaceit.service.FoodItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/meatMeal")
public class MeatMealApi {

    @Autowired
    private FoodItemsService foodItemsService;

    @ResponseBody
    @RequestMapping(value = "/meatMeal-item-list")
    public List<FoodItems> burgerItems () {

        String category = "MeatMeal";
        List<FoodItems> foodItems = this.foodItemsService.getAllByCategory(category);
        for (FoodItems item : foodItems ){
            System.out.println(item.getTypeName());
        }

        return foodItems;
    }
}


