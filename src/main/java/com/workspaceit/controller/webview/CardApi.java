package com.workspaceit.controller.webview;

import com.workspaceit.entity.Cart;
import com.workspaceit.pojo.wraper.ApiStatus;
import com.workspaceit.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/cart")
public class CardApi {

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

}
