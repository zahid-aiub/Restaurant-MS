package com.workspaceit.controller.webview;

import com.workspaceit.entity.FoodItems;
import com.workspaceit.pojo.wraper.ApiStatus;
import com.workspaceit.service.FoodItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/burger")
public class BurgerItemsApi {

    @Autowired
    private FoodItemsService foodItemsService;

    @ResponseBody
    @RequestMapping(value = "/burger-item-list")
    public List<FoodItems> burgerItems () {

        String category = "Burger";
        List<FoodItems> foodItems = this.foodItemsService.getAllByCategory(category);
        return foodItems;
    }
}
