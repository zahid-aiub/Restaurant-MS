package com.workspaceit.controller.webview;

import com.workspaceit.entity.Admin;
import com.workspaceit.entity.Customer;
import com.workspaceit.pojo.wraper.ApiStatus;
import com.workspaceit.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;

@RestController
@RequestMapping(value = "/admin")
public class AdminApi {

    @Autowired
    ServletContext servletContext;

    @Autowired
    private AdminService adminService;

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
    public void changeProductStatusByAdmin (@RequestParam("status") String status) {
        Integer st =Integer.parseInt(status);
        System.out.println("-------"+ st);

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
}
