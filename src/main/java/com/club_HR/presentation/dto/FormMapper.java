package com.club_HR.presentation.dto;

import com.club_HR.business.dto.MemberDto;
import com.club_HR.presentation.MemberDetailForm;
import org.springframework.stereotype.Component;

@Component
public class FormMapper {

    public MemberDto mapFromMemberFormToMember(MemberDetailForm memberDetailForm) {
        MemberDto memberDto = new MemberDto();

        memberDto.setFirstName(memberDetailForm.getFirstName());
        memberDto.setLastName(memberDetailForm.getLastName());
        memberDto.setEmail(memberDetailForm.getEmail());
        memberDto.setGender(memberDetailForm.getGender());
        memberDto.setPassword(memberDetailForm.getPassword());
        memberDto.setPromo(memberDetailForm.getPromo());

        return memberDto;
    }
}
