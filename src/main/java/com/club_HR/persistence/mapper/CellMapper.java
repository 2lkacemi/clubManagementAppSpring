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
     * @param cellDto
     * @return
     */
    public CellEntity mapToCellEntity(CellDto cellDto){
        CellEntity cellEntity = new CellEntity();
        cellEntity.setCellRef(cellDto.getCellRef());
        cellEntity.setCellName(cellDto.getCellName());
        cellEntity.setCellDescription(cellDto.getCellDescription());

        List<MemberDto> membersList = cellDto.getMemberDtos();
        List<MemberEntity> memberEntitiesList = membersList.stream()
                .map(member -> memberMapper.mapToMemberEntity(member))
                .collect(Collectors.toList());
        cellEntity.setMemberEntities(memberEntitiesList);

        return cellEntity;
    }

    /**
     * method which convert an entity to a dto
     * @param cellEntity
     * @return
     */
    public CellDto mapToCellDto(CellEntity cellEntity){
        CellDto cellDto = new CellDto();
        cellDto.setCellRef(cellEntity.getCellRef());
        cellDto.setCellName(cellEntity.getCellName());
        cellDto.setCellDescription(cellEntity.getCellDescription());

        return cellDto;
    }

}
