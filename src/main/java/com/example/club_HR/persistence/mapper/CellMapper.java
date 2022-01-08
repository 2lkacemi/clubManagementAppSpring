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
public class CellMapper {
    private MemberMapper memberMapper;

    @Autowired
    public void setMemberMapper(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public CellEntity mapToCellEntity(Cell cell){
        CellEntity cellEntity = new CellEntity();
        cellEntity.setCellRef(cell.getCellRef());
        cellEntity.setCellName(cell.getCellName());
        cellEntity.setCellDescription(cell.getCellDescription());

        List<Member> membersList = cell.getMembers();
        List<MemberEntity> memberEntitiesList = membersList.stream()
                .map(member -> memberMapper.mapToMemberEntity(member))
                .collect(Collectors.toList());
        cellEntity.setMembers(memberEntitiesList);

        return cellEntity;
    }

    public Cell mapToCell(CellEntity cellEntity){
        Cell cell = new Cell();
        cell.setCellRef(cellEntity.getCellRef());
        cell.setCellName(cellEntity.getCellName());
        cell.setCellDescription(cellEntity.getCellDescription());

        List<MemberEntity> memberEntitiesList = cellEntity.getMembers();
        List<Member> membersList = memberEntitiesList.stream()
                .map(memberEntity -> memberMapper.mapToMember(memberEntity))
                .collect(Collectors.toList());

        cell.setMembers(membersList);

        return cell;
    }

}
