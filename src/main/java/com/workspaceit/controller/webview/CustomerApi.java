package com.workspaceit.controller.webview;

import com.workspaceit.contents.URLPrefix;
import com.workspaceit.entity.Customer;
import com.workspaceit.pojo.wraper.ApiStatus;
import com.workspaceit.service.CustomerService;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

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
    @RequestMapping(value = "/loginProcess",method = RequestMethod.POST)
    public ApiStatus userLoginProcess(@RequestParam(value = "uname") String username, @RequestParam(value = "pass") String password, HttpServletRequest request) {

        System.out.println("login process...");
        if (!username.equals("") && !password.equals("")) {
            List<Object> customer = this.customerService.checkLogin(username, password);
            if (customer!=null) {
                /*HttpSession session = request.getSession();
                session.setAttribute(username, "uname");
                session.setAttribute(password, "upass");
*/
                System.out.println("Login successful...!!");
                try{
                    return new ApiStatus(200,"successfull",null);
                }catch (Exception e){
                    e.printStackTrace();
                }
//                return (ApiStatus) new Object();
            } else {
                System.out.println("Failed to login");
                return new ApiStatus(401,"Failed",null);

            }
        }

        return new ApiStatus(200,"jhugfytgfhj");
    }

}
