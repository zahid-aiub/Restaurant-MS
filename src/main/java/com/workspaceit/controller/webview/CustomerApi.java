package com.workspaceit.controller.webview;

import com.workspaceit.entity.Customer;
import com.workspaceit.pojo.wraper.ApiStatus;
import com.workspaceit.service.CustomerService;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/user")
public class CustomerApi {

    @Autowired
    CustomerService customerService;

    HttpSession session;

    @RequestMapping("/registration")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user/registration");
        return mv;
    }


    @RequestMapping("/registrationProcess")
    public ApiStatus registrationProcess( HttpServletRequest request,HttpServletResponse response,
                                         @RequestParam("name") String name, @RequestParam("phone") String phone,
                                         @RequestParam("password") String password, @RequestParam("address") String address

                                    ){
        System.out.println(name +"-->>"+ password);

        Customer customer = new Customer();
        customer.setName(name);
        customer.setPhone(phone);
        customer.setPassword(password);
        customer.setAddress(address);

        this.customerService.add(customer);
        return new ApiStatus(200,"successfully registred", "");
    }

//    @ResponseBody
    @RequestMapping(value = "/loginProcess")
    public ApiStatus userLoginProcess(HttpServletRequest request,@RequestParam(value = "uname") String username,
                                 @RequestParam(value = "pass") String password
                                 )
    {
        /*String username = request.getParameter("phoneNumb");
        String password = request.getParameter("pass");*/

        System.out.println("login process..."+username+password);
        if (!username.equals("") && !password.equals("")) {
            Customer customer = this.customerService.checkLogin(username, password);
            if (customer!=null) {
                int id = customer.getId();
                String name = customer.getName();
                System.out.println(id+ " --- "+ name);

                HttpSession session = request.getSession();
                session.setAttribute("user", customer);

                System.out.println("login successfull");
                return new ApiStatus(200,"successfull", customer);

            } else {
                System.out.println("Failed to login");
                return new ApiStatus(400,"successfull");
            }
        }

        return null;
    }

}
