package com.club_HR.presentation;

import com.club_HR.business.IMemberService;
import com.club_HR.business.dto.MemberDto;
import com.club_HR.presentation.dto.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthenticationController {

    IMemberService iMemberService;

    @Autowired
    public AuthenticationController(IMemberService iMemberService) {
        this.iMemberService = iMemberService;
    }


    //Check for Credentials
//    @PostMapping("/login")
//    public String login(@ModelAttribute(name = "memberLoginForm") MemberLoginForm memberLoginForm, Model m) {
//        String email = memberLoginForm.getEmail();
//        String pass = memberLoginForm.getPassword();
//        if (email.equals("Admin@gmail.com") && pass.equals("Admin@123")) {
//            m.addAttribute("email", email);
//            m.addAttribute("pass", pass);
//            return "homeDashPage";
//        }
//        m.addAttribute("error", "Incorrect Username & Password");
//        return "loginPage";
//
//    }

    @PostMapping(value = {"/login"})
    public String login(@ModelAttribute(name = "loginForm") LoginForm loginForm, Model model) {

        String email = loginForm.getEmail();
        String password = loginForm.getPassword();
        MemberDto memberFound = iMemberService.getMemberByEmail(email);
        if (memberFound != null) {
            if (memberFound.getPassword().equals(password)) {
                model.addAttribute("email", email);
                model.addAttribute("password", password);
                return "redirect:dash";
            }
        }
        return "redirect:login";
    }
}
