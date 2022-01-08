package com.example.club_HR.business;

import com.example.club_HR.business.dto.Member;
import com.example.club_HR.persistence.entity.MemberEntity;
import com.example.club_HR.persistence.IMemberDao;
import com.example.club_HR.persistence.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class MemberServiceImpl implements IMemberService {//on va faire le couplage faible avec la couche dao --> la couche metier va faire appel � la couche dao
    // pour faire l'injection de dependance  --> on va demander a spring d'injecter une implementation de cette interface

    final private IMemberDao iMemberDao;
    final private MemberMapper memberMapper;

    @Autowired
    public MemberServiceImpl(IMemberDao iMemberDao, MemberMapper memberMapper) {
        this.iMemberDao = iMemberDao;
        this.memberMapper = memberMapper;
    }

    @Override
    public void addMember(Member member) {
        this.iMemberDao.save(memberMapper.mapToMemberEntity(member));
    }

    @Override
    public List<Member> getAllMembers() {
        List<MemberEntity> memberEntitiesList = iMemberDao.findAll();

        return memberEntitiesList
                .stream()
                .map(memberMapper::mapToMember)
                .collect(Collectors.toList());

    }

    @Override
    public Member getMemberByEmail(String email) {
       return iMemberDao.findMemberEntityByEmail(email).map(memberMapper::mapToMember).orElse(null);
    }

    @Override
    public void deleteMember(String email){
        Member memberFound = getMemberByEmail(email);
        if (memberFound != null){
            iMemberDao.deleteById(3L);
        }
    }

}
