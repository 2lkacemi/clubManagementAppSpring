package com.example.club_HR.business;
import com.example.club_HR.business.dto.Member;

import java.util.List;

public interface IMemberService {

    void addMember(Member member);
    List<Member> getAllMembers();
    Member getMemberByEmail(String email);
    void deleteMember(String email);


}