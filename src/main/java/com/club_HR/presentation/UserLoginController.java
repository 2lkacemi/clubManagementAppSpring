package com.club_HR.presentation;


import com.club_HR.business.IMemberService;
import com.club_HR.business.IUserService;
import com.club_HR.business.dto.MemberDto;
import com.club_HR.business.dto.UserDto;
import com.club_HR.presentation.dto.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/login","/"})
public class UserLoginController {

    IUserService iUserService;

    @Autowired
    public UserLoginController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @ModelAttribute("loginForm")
    public LoginForm userLoginForm() {
        return new LoginForm();
    }

    @GetMapping
    public String showLoginForm() {
        return "loginPage";
    }

    @PostMapping
    public String login(@ModelAttribute(name = "loginForm") LoginForm loginForm, Model model) {
        String email = loginForm.getEmail();
        String password = loginForm.getPassword();
        UserDto userFound = iUserService.getUserByEmail(email);
        if (userFound != null) {
            if (userFound.getPassword().equals(password)) {
                model.addAttribute("email", email);
                model.addAttribute("password", password);
                return "redirect:dash";
            }
        }
//        model.addAttribute()
        return "redirect:/login";
    }


}
