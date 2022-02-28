package com.club_HR.persistence.mapper;

import com.club_HR.business.dto.CellDto;
import com.club_HR.business.dto.MemberDto;
import com.club_HR.persistence.entity.CellEntity;
import com.club_HR.persistence.entity.MemberEntity;
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

    /**
     * method which convert a dto to an entity
     * @param cellDto parameter
     * @return this return cellEntity
     */
    public CellEntity mapToCellEntity(CellDto cellDto){
        CellEntity cellEntity = new CellEntity();
        cellEntity.setId(cellDto.getId());
        cellEntity.setCellRef(cellDto.getCellRef());
        cellEntity.setCellName(cellDto.getCellName());
        cellEntity.setCellDescription(cellDto.getCellDescription());

        List<MemberDto> membersList = cellDto.getMemberDtoList();
        List<MemberEntity> memberEntitiesList = membersList.stream()
                .map(member -> memberMapper.mapToMemberEntity(member))
                .collect(Collectors.toList());
        cellEntity.setMemberEntityList(memberEntitiesList);

        return cellEntity;
    }

    /**
     * method which convert an entity to a dto
     * @param cellEntity parameter
     * @return cellDto
     */
    public CellDto mapToCellDto(CellEntity cellEntity){
        CellDto cellDto = new CellDto();
        cellDto.setId(cellEntity.getId());
        cellDto.setCellRef(cellEntity.getCellRef());
        cellDto.setCellName(cellEntity.getCellName());
        cellDto.setCellDescription(cellEntity.getCellDescription());

        List<MemberEntity> memberEntityList = cellEntity.getMemberEntityList();
        List<MemberDto> memberDtoList = memberEntityList.stream()
                .map(member -> memberMapper.mapToMemberDto(member))
                .collect(Collectors.toList());
        cellDto.setMemberDtoList(memberDtoList);

        return cellDto;
    }

}
