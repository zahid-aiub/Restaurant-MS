package com.workspaceit.controller.webview;

import com.workspaceit.entity.Admin;
import com.workspaceit.entity.Customer;
import com.workspaceit.pojo.wraper.ApiStatus;
import com.workspaceit.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/admin")
public class AdminApi {

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
    public void changeProductStatusByAdmin (@RequestParam("status") String ststus) {
        Integer st =Integer.parseInt(ststus);
        System.out.println("-------"+ st);

    }
}
