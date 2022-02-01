package com.club_HR.business;

import com.club_HR.persistence.IMemberDao;
import com.club_HR.business.dto.MemberDto;

import com.club_HR.persistence.mapper.MemberMapper;
import com.club_HR.persistence.entity.MemberEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
    public MemberDto addMember(MemberDto memberDto) {
        this.iMemberDao.save(memberMapper.mapToMemberEntity(memberDto));
        return memberDto;
    }

    @Override
    public List<MemberDto> getAllMembers() {
        List<MemberEntity> memberEntitiesList = iMemberDao.findAll();

        return memberEntitiesList
                .stream()
                .map(memberMapper::mapToMemberDto)
                .collect(Collectors.toList());
    }

    @Override
    public MemberDto getMemberByEmail(String email) {
       return iMemberDao.findMemberEntityByEmail(email)
               .map(memberMapper::mapToMemberDto)
               .orElse(null);
    }

    @Override
    public void removeMemberByEmail(String email) {
        MemberDto memberFound = getMemberByEmail(email);
        if (memberFound != null){
            iMemberDao.deleteMemberEntityByEmail(memberMapper.mapToMemberEntity(memberFound).getEmail());
        }
    }

    @Override
    public MemberDto updateMemberByEmail(String email, MemberDto newMember) {
        MemberDto oldMember = getMemberByEmail(email);
        newMember.setEmail(email);
        oldMember.setFirstName(newMember.getFirstName());
        oldMember.setMemberType(newMember.getMemberType());
        oldMember.setCellDtos(newMember.getCellDtos());
        oldMember.setGender(newMember.getGender());
        oldMember.setPromo(newMember.getPromo());
        oldMember.setLastName(newMember.getLastName());
        oldMember.setTel(newMember.getTel());

        addMember(oldMember);
        return oldMember;
    }
}
