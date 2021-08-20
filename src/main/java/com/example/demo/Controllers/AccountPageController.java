package com.example.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/myaccount")
public class AccountPageController {
    @GetMapping
    public String myAccountMainPage(){
        return "welcomne.html";
    }
}
