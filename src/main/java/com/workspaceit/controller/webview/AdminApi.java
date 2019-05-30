package com.workspaceit.controller.webview;

import com.workspaceit.entity.Admin;
import com.workspaceit.entity.Customer;
import com.workspaceit.entity.FoodItems;
import com.workspaceit.pojo.wraper.ApiStatus;
import com.workspaceit.service.AdminService;
import com.workspaceit.service.FoodItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

@RestController
@RequestMapping(value = "/admin")
public class AdminApi {

    @Autowired
    ServletContext servletContext;

    @Autowired
    private AdminService adminService;

    @Autowired
    private FoodItemsService foodItemsService;

    @RequestMapping(value = "/loginProcess")
    public ApiStatus userLoginProcess(HttpServletRequest request, @RequestParam(value = "uname") String username,
                                      @RequestParam(value = "pass") String password
    )
    {
        System.out.println("login process..."+username+password);
        if (!username.equals("") && !password.equals("")) {
            Admin admin = this.adminService.checkLogin(username, password);
            if (admin!=null) {
                int id = admin.getId();
                String name = admin.getName();
                System.out.println(id+ " --- "+ name);

                HttpSession session = request.getSession();
                session.setAttribute("admin", admin);

                System.out.println("login successfull");
                return new ApiStatus(200,"successfull", admin);

            } else {
                System.out.println("Failed to login");
                return new ApiStatus(400,"Failed to Login");
            }
        }

        return null;
    }


    @RequestMapping(value = "/changeProductStatus")
    public void changeProductStatusByAdmin (@RequestParam("status") String status, @RequestParam("foodId") String foodItemId) {
        Integer st =Integer.parseInt(status);
        Integer foodId =Integer.parseInt(foodItemId);
        if ((st == 1 || st == 0) && foodId != null){
            System.out.println("-------"+ st + "-----"+ foodId);
            Integer res = this.foodItemsService.updateStatus(st, foodId);
            System.out.println(res+ " -----------------------");
        }

    }

    @RequestMapping(value = "/addFoodItem")
    public Boolean addFoodItems (@RequestParam("name") String name, @RequestParam("category") String category,
                                 @RequestParam("quantity") String quantity, @RequestParam("price") String price,
                                 @RequestParam("status") String status, @RequestParam("description") String description,
                                 @RequestParam("imageUrl") String file
                                 ) {

        System.out.println("--------------"+file);

        String webappRoot = servletContext.getRealPath("/");
        String uploadDir = File.separator + "resources" + File.separator
                + "images" + File.separator + category + File.separator;
       // String filename = webappRoot + uploadDir
            //    + file.getOriginalFilename();
        System.out.println("------------"+ uploadDir);

        return true;
    }

    //selectedFoodItemId

    @RequestMapping(value = "/fetchProductById")
    public ApiStatus fetchProductById (@RequestParam("foodId") String foodId) {
        Integer fId =Integer.parseInt(foodId);
        if (foodId != null){
            System.out.println( "-----"+ foodId);
            FoodItems foodItems = this.foodItemsService.fetchProductById(fId);
            return new ApiStatus(200,"OK",foodItems );
        }

        return null;
    }

    //updateBatchProduct

    @RequestMapping(value = "/updateBatchProduct")
    public int updateBatch (@RequestParam("foodId") String foodId,
                            @RequestParam("quantity") String quantity,
                            @RequestParam("price") String price,
                            @RequestParam("desc") String desc
                            ) {
        Integer fId =Integer.parseInt(foodId);
        Integer qty =Integer.parseInt(quantity);
        Integer pric =Integer.parseInt(price);

        if (foodId != null){
            System.out.println( "-----"+ foodId);
            Integer res = this.foodItemsService.updateBatch(fId, qty, pric, desc);
            return 1;
        }

        return 0;
    }

}
