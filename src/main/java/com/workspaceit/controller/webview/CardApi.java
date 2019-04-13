package com.workspaceit.controller.webview;

import com.workspaceit.entity.Cart;
import com.workspaceit.entity.Customer;
import com.workspaceit.entity.FoodItems;
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
import java.lang.reflect.Field;
import java.util.List;

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

    //userCartDetails
    @ResponseBody
    @RequestMapping(value = "/userCartDetails")
    public List<Object> cartDetails (HttpServletRequest request) {

        HttpSession session = request.getSession();
        Customer customer =(Customer) session.getAttribute("user");
        List<Object> obj = this.cartService.userCartDetails(customer.getId());

        Class<?> clazz = obj.getClass();

        for(Field field : clazz.getDeclaredFields()) {

            System.out.println(field.getName());
        }
        /*for (Object ob : obj){
            System.out.println("****************** "+ob.+"----");
        }*/

        return null;
    }

}
