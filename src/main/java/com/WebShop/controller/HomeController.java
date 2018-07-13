package com.WebShop.controller;

import com.WebShop.dao.ProductDao;
import com.WebShop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
public class HomeController {


    @RequestMapping("/")
    public String home(){

        return "home";
    }

    @RequestMapping("/login")
    public String login(@RequestParam(value="error", required = false) String error,
                        @RequestParam (value="logout", required = false) String logout, Model model
    ) {

        if(error != null) {
            model.addAttribute("error", "Invalid username and password!");
        }

        if(logout!= null) {
            model.addAttribute("msg", "You have been logged out successfully.");
        }

        return "login";
    }
}
