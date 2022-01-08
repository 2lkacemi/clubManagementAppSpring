package com.example.club_HR.persistence.mapper;

import com.example.club_HR.business.dto.Cell;
import com.example.club_HR.business.dto.Member;
import com.example.club_HR.persistence.entity.CellEntity;
import com.example.club_HR.persistence.entity.MemberEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MemberMapper {

    private CellMapper cellMapper;

    @Autowired
    public void setCellMapper(CellMapper cellMapper) {
        this.cellMapper = cellMapper;
    }

    public MemberEntity mapToMemberEntity(Member member){
        MemberEntity memberEntity = new MemberEntity();

        memberEntity.setFirstName(member.getFirstName());
        memberEntity.setLastName(member.getLastName());
        memberEntity.setEmail(member.getEmail());
        memberEntity.setMemberType(member.getMemberType());
        memberEntity.setGender(member.getGender());
        memberEntity.setPassword(member.getPassword());
        memberEntity.setPromo(member.getPromo());
        memberEntity.setTel(member.getTel());
        // map cells list
        List<Cell> cellsList = member.getCells();
        List<CellEntity> cellEntitiesList = cellsList.stream().map(cell -> cellMapper.
                mapToCellEntity(cell)).
                collect(Collectors.toList());
        memberEntity.setCells(cellEntitiesList);

        return memberEntity;
    }

    public Member mapToMember(MemberEntity memberEntity){
        Member member = new Member();

        member.setFirstName(memberEntity.getFirstName());
        member.setLastName(memberEntity.getLastName());
        member.setEmail(memberEntity.getEmail());
        member.setMemberType(memberEntity.getMemberType());
        member.setGender(memberEntity.getGender());
        member.setPassword(memberEntity.getPassword());
        member.setPromo(memberEntity.getPromo());
        member.setTel(memberEntity.getTel());
        // map cells
        List<CellEntity> cellsEntitiesList = memberEntity.getCells();
        List<Cell> cellsList = cellsEntitiesList.stream().map(cell -> cellMapper.
                        mapToCell(cell)).
                collect(Collectors.toList());
        member.setCells(cellsList);

        return  member;
    }

}
