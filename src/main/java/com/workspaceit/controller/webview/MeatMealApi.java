package com.workspaceit.controller.webview;

import com.workspaceit.entity.FoodItems;
import com.workspaceit.service.FoodItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/meatMeal")
public class MeatMealApi {

    @Autowired
    private FoodItemsService foodItemsService;

    @ResponseBody
    @RequestMapping(value = "/meatMeal-item-list")
    public List<FoodItems> burgerItems (HttpServletRequest request) {

        String userType = "";
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null){
            userType = "customer";
        }
        if (session.getAttribute("admin")!= null){
            userType = "admin";
        }

        String category = "MeatMeal";

        List<FoodItems> foodItems = this.foodItemsService.getAllByCategory(category, userType);
        return foodItems;
    }
}


