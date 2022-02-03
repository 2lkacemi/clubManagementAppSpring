package com.club_HR.business;

import com.club_HR.business.dto.CellDto;
import com.club_HR.business.dto.MemberDto;

import com.club_HR.persistence.ICellDao;
import com.club_HR.persistence.entity.CellEntity;
import com.club_HR.persistence.mapper.CellMapper;
import com.club_HR.persistence.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;


@Service
public class CellServiceImpl implements ICellService{

    final private ICellDao iCellDao;
    final private IMemberService iMemberService;
    final private MemberMapper memberMapper;
    final private CellMapper cellMapper;

    @Autowired
    public CellServiceImpl(ICellDao iCellDao, IMemberService iMemberService, MemberMapper memberMapper, CellMapper cellMapper) {
        this.iCellDao = iCellDao;
        this.iMemberService = iMemberService;
        this.memberMapper = memberMapper;
        this.cellMapper = cellMapper;
    }

    @Override
    public CellDto addCell(CellDto cellDto) {
        cellDto.setCellRef("code_" + cellDto.getCellName().substring(0,4));
        this.iCellDao.save(cellMapper.mapToCellEntity(cellDto));
        return cellDto;
    }

    @Override
    public void deleteCellByCellRef(String cellRef) {
        iCellDao.deleteCellEntityByCellRef(cellRef);
    }

    @Override
    public List<CellDto> getAllCells() {
        List<CellEntity> cellEntitiesList = iCellDao.findAll();

        return cellEntitiesList
                .stream()
                .map(cellEntity -> cellMapper.mapToCellDto(cellEntity))
                .collect(Collectors.toList());
    }

    @Override
    public void addMemberToCell(String email, String cellRef) {
        //recuperer le membre avec id == id
        MemberDto memberDto = iMemberService.getMemberByEmail(email);
        CellDto cellDto = this.getCellByCellRef(cellRef);

        if (!cellDto.getMemberDtos().contains(memberDto)){
            cellDto.getMemberDtos().add(memberDto);
            iCellDao.save(cellMapper.mapToCellEntity(cellDto));
        }

    }

    @Override
    public CellDto getCellByCellRef(String cellRef) {
        return iCellDao.findCellEntityByCellRef(cellRef) != null ? cellMapper.mapToCellDto(iCellDao.findCellEntityByCellRef(cellRef)) : null;
    }

    @Override
    public void deleteMemberFromCell(String email, String cellRef) {
        //recuperer le membre avec id == id
        MemberDto memberDto = iMemberService.getMemberByEmail(email);
        CellDto cellDto = this.getCellByCellRef(cellRef);
        if (!cellDto.getMemberDtos().contains(memberDto)){
            cellDto.getMemberDtos().remove(memberDto);
            iCellDao.delete(cellMapper.mapToCellEntity(cellDto));
        }
    }

}
