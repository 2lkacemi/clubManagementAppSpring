package com.club_HR.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {
//    @GetMapping("/login")
//    public String viewLoginPage() {
//        return "loginPage";
//    }
//
//    @GetMapping("/")
//    public String hello() {
//        return "homePage";
//    }

     //Check for Credentials
//    @PostMapping("/login")
//    public String login(@ModelAttribute(name="memberLoginForm") MemberLoginForm memberLoginForm, Model m) {
//        String email = memberLoginForm.getEmail();
//        String pass = memberLoginForm.getPassword();
//        if(email.equals("Admin@gmail.com") && pass.equals("Admin@123")) {
//            m.addAttribute("email", email);
//            m.addAttribute("pass", pass);
//            return "homeDashPage";
//        }
//        m.addAttribute("error", "Incorrect Username & Password");
//        return "loginPage";
//
//    }


}
