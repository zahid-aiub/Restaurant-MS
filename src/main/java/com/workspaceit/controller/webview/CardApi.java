package com.workspaceit.controller.webview;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.workspaceit.entity.Cart;
import com.workspaceit.entity.Customer;
import com.workspaceit.pojo.wraper.ApiStatus;
import com.workspaceit.service.CartService;
import com.workspaceit.service.FoodItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping(value = "/cart")
public class CardApi {

    @Autowired
    private FoodItemsService foodItemsService;

    @Autowired
    private CartService cartService;

    @RequestMapping(value = "/confirm-add-to-cart")
    public ApiStatus confirmAddToCard (HttpServletRequest request,
                                       @RequestParam("userId") int uid,
                                       @RequestParam("foodId") int foodTypeId,
                                       @RequestParam("quantity") int quantity,
                                       @RequestParam("tprice") int totalPrice
                                       ) {

        System.out.println(uid+"----"+foodTypeId+"----"+ quantity+"----"+totalPrice);
        Cart cart = new Cart();
        cart.setCustomerId(uid);
        cart.setFoodTypeId(foodTypeId);
        cart.setQuantity(quantity);
        cart.setTotalPrice(totalPrice);

        int dbQuantity = this.foodItemsService.getQuantity(foodTypeId);
        System.out.println("Database Food quantity: "+dbQuantity);

        this.foodItemsService.updateQuantity(dbQuantity-quantity, foodTypeId);

        Boolean res = this.cartService.addToCart(cart);
        if (res){
            System.out.println("added");
            return new ApiStatus(200, "successfully add to cart");
        }
        else {
            System.out.println("failed to add");
            return new ApiStatus(400,"Failed to add cart");
        }
    }


    @ResponseBody
    @RequestMapping(value = "/userCartDetails")
    public Object cartDetails (HttpServletRequest request) {

        HttpSession session = request.getSession();
        Customer customer =(Customer) session.getAttribute("user");
        Object obj = this.cartService.userCartDetails(customer.getId());
        String jsonStr="";

        ObjectMapper objectMapper = new ObjectMapper();
        try {

            jsonStr = objectMapper.writeValueAsString(obj);

            System.out.println(jsonStr);
        }

        catch (IOException e) {
            e.printStackTrace();
        }


        /*Class<?> clazz = obj.getClass();
        for(Field field : clazz.getDeclaredFields()) {

            System.out.println(field.getName());
        }*/

        if (obj != null){
            System.out.println("****************** "+obj.toString()+"----");
        }

        return jsonStr;
    }

}
