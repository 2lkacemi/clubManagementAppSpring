package com.club_HR.presentation;


import com.club_HR.business.IMemberService;
import com.club_HR.business.dto.MemberDto;
import com.club_HR.presentation.dto.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class MemberLoginController {

    IMemberService iMemberService;

    @Autowired
    public MemberLoginController(IMemberService iMemberService) {
        this.iMemberService = iMemberService;
    }

    @ModelAttribute("loginForm")
    public LoginForm memberLoginForm() {
        return new LoginForm();
    }

    @GetMapping
    public String showLoginForm(Model model) {
        return "loginPage";
    }

    @PostMapping
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
