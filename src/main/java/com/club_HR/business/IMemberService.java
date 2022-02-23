package com.club_HR.business;
import com.club_HR.business.dto.MemberDto;

import java.util.List;

public interface IMemberService {

    MemberDto addMember(MemberDto memberDto);
    List<MemberDto> getAllMembers();
    MemberDto getMemberByEmail(String email);
    void removeMemberByEmail(String email);
    void updateMember(MemberDto member);


}