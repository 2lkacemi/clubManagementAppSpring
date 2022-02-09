package com.club_HR.presentation;

import com.club_HR.business.IMemberService;
import com.club_HR.business.dto.MemberDto;
import com.club_HR.business.enums.MemberType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class MemberRegistrationController {

    IMemberService iMemberService;

    @Autowired
    public MemberRegistrationController(IMemberService iMemberService) {
        this.iMemberService = iMemberService;
    }

    @ModelAttribute("member")
    public MemberDto memberRegistrationDto() {
        return new MemberDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "registrationPage";
    }


    @PostMapping
    public String registerMemberAccount(@ModelAttribute("member") MemberDto member) {
        String email = member.getEmail();
        MemberDto memberFound = iMemberService.getMemberByEmail(email);
        if (memberFound != null) {
            return "redirect:login";
        } else {
            member.setMemberType(MemberType.member);
            iMemberService.addMember(member);
            return "redirect:login";
        }
    }
}
