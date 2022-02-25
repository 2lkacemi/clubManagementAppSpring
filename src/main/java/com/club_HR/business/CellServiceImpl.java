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
    public void addCell(CellDto cellDto) {
        cellDto.setCellRef("code_" + cellDto.getCellName().substring(0,4));
        this.iCellDao.save(cellMapper.mapToCellEntity(cellDto));
    }

    @Override
    public void updateCell(CellDto cell){
            CellEntity cellEntity = cellMapper.mapToCellEntity(cell);
        iCellDao.save(cellEntity);
    }

    @Override
    public void removeCellByCellRef(String cellRef) {
        iCellDao.deleteByCellRef(cellRef);
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

        if (!cellDto.getMemberDtoList().contains(memberDto)){
            cellDto.getMemberDtoList().add(memberDto);
            iCellDao.save(cellMapper.mapToCellEntity(cellDto));
        }
    }

    @Override
    public CellDto getCellByCellRef(String cellRef) {
        return iCellDao.findByCellRef(cellRef) != null ? cellMapper.mapToCellDto(iCellDao.findByCellRef(cellRef)) : null;
    }

    @Override
    public CellDto getCellById(Long id) {
        return iCellDao.findById(id).isPresent() ? cellMapper.mapToCellDto(iCellDao.findById(id).get()) : null;
    }

    @Override
    public void removeMemberFromCell(String email, String cellRef) {
        //recuperer le membre avec id == id
        MemberDto memberDto = iMemberService.getMemberByEmail(email);
        CellDto cellDto = this.getCellByCellRef(cellRef);
        if (cellDto.getMemberDtoList().contains(memberDto)){
            cellDto.getMemberDtoList().remove(memberDto);
            iCellDao.save(cellMapper.mapToCellEntity(cellDto));
        }
    }
}
