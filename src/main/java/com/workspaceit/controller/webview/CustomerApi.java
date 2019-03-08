package com.workspaceit.controller.webview;

import com.workspaceit.contents.URLPrefix;
import com.workspaceit.entity.Customer;
import com.workspaceit.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
//@RequestMapping(value = URLPrefix.API + "/customer")
public class CustomerApi {

    @Autowired
    CustomerService customerService;

    @RequestMapping("/registration")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user/registration");
        return mv;
    }


    @RequestMapping("/registrationProcess")
    public void registrationProcess(HttpServletRequest request, HttpServletResponse response){
        System.out.println("Inside....!");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String addres = request.getParameter("address");

        System.out.println(name +"-->>"+ password);

        Customer customer = new Customer();
        customer.setName(name);
        customer.setPhone(phone);
        customer.setPassword(password);
        customer.setAddress(addres);

        this.customerService.add(customer);


    }
}
