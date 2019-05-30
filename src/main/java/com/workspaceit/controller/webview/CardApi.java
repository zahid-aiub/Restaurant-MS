package com.workspaceit.controller.webview;

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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/cart")
public class CardApi {

    @Autowired
    private FoodItemsService foodItemsService;

    @Autowired
    private CartService cartService;

    @RequestMapping(value = "/confirm-add-to-cart")
    public ApiStatus confirmAddToCard (HttpServletRequest request, HttpServletResponse response,
                                       @RequestParam("userId") int uid,
                                       @RequestParam("foodId") int foodTypeId,
                                       @RequestParam("quantity") int quantity,
                                       @RequestParam("tprice") int totalPrice,
                                       @RequestParam("typeName") String typeName,
                                       @RequestParam("image") String image
                                       ) {

        System.out.println(uid+"----"+foodTypeId+"----"+ quantity+"----"+totalPrice);
        Cart cart = new Cart();
        cart.setCustomerId(uid);
        cart.setFoodTypeId(foodTypeId);
        cart.setQuantity(quantity);
        cart.setTotalPrice(totalPrice);
        cart.setFoodTypeName(typeName);
        cart.setImage(image);

        int dbQuantity = this.foodItemsService.getQuantity(foodTypeId);
        System.out.println("Database Food quantity: "+dbQuantity);

        Integer updateRes = this.foodItemsService.updateQuantity(dbQuantity-quantity, foodTypeId);

        Boolean res = this.cartService.addToCart(cart);
        if (res){
            return new ApiStatus(200, "successfully add to cart");
        }
        else {
            return new ApiStatus(400,"Failed to add cart");
        }
    }


    @ResponseBody
    @RequestMapping(value = "/userCartDetails")
    public Object cartDetails (HttpServletRequest request) {

        HttpSession session = request.getSession();
        Customer customer =(Customer) session.getAttribute("user");
        List<Cart> carts = this.cartService.userCartDetails(customer.getId());

        return carts;
    }

    @RequestMapping(value = "/removeFromCard")
    public ApiStatus removeFromCart(@RequestParam("uId") int uId,
                                    @RequestParam("foodId") int foodId ){
        System.out.println(uId+"---"+ foodId);
        Integer foodTypeId = this.cartService.getFoodTypeId(foodId);
        System.out.println("food type id---"+foodTypeId);
        Integer cartTableQuantity = this.cartService.getQuantity(foodId);
        System.out.println("Cart Table qty---"+cartTableQuantity);
        Integer foodTableQuantity = this.foodItemsService.getQuantity(foodTypeId);
        System.out.println("DB food type qty---"+foodTableQuantity);

        Integer isDelete = cartService.removeFromCart(foodId);
        System.out.println("Deleted"+ isDelete);
        if (isDelete==1){
            System.out.println("Removed from cart");
            Integer isUpdate =  this.foodItemsService.updateQuantity(foodTableQuantity+cartTableQuantity, foodId);
            if (isUpdate==1) {
                System.out.println("-------------------------------");
                return new ApiStatus(200,"remove from cart done");
            }
            else {
                return new ApiStatus(400, "failed to update food quantity after remove from cart");
            }
        }

        return new ApiStatus(200,"ok");
    }

}
