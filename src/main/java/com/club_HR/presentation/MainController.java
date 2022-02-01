package com.club_HR.presentation;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String welcome() {
        return "homePage";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "loginPage";
    }

    @GetMapping("/registration")
    public String showRegistrationForm() {
        return "registrationPage";
    }


}
