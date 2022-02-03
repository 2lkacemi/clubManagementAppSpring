package com.club_HR.presentation;

import com.club_HR.business.IMemberService;
import com.club_HR.business.dto.MemberDto;
import com.club_HR.business.enums.Gender;
import com.club_HR.presentation.dto.LoginForm;
import com.club_HR.presentation.dto.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.Registration;

@Controller
public class AuthenticationController {

    IMemberService iMemberService;

    @Autowired
    public AuthenticationController(IMemberService iMemberService) {
        this.iMemberService = iMemberService;
    }


    //Check for Credentials
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

    @PostMapping(value = {"/registration"})
    public String registration(@ModelAttribute(name = "member") MemberDto member) {
//        String firstName = registrationForm.getFirstName();
//        String lastName = registrationForm.getLastName();
//        String promo = registrationForm.getPromo();
//        Gender gender = registrationForm.getGender();
//        String password = registrationForm.getPassword();
        String email = member.getEmail();
        MemberDto memberFound = iMemberService.getMemberByEmail(email);
        if (memberFound != null) {
            return "redirect:login";
        }
        else{
            iMemberService.addMember(member);
            return "redirect:login";
        }
    }
}
