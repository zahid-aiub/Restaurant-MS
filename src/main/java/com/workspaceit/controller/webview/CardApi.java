package com.workspaceit.controller.webview;

import com.workspaceit.pojo.wraper.ApiStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/card")
public class CardApi {

    @RequestMapping(value = "/confirm-add-to-card")
    public ApiStatus confirmAddToCard (HttpServletRequest request, @RequestParam("foodTypeId") int foodTypeId,
                                       @RequestParam("quantity") int quantity,
                                       @RequestParam("tprice") int totalPrice
                                       ) {

        System.out.println(foodTypeId+"----"+ quantity+"----"+totalPrice);



        return new ApiStatus(200, "successfully add to card", null);
    }
}
