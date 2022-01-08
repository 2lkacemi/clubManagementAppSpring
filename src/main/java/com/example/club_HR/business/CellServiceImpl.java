package com.example.club_HR.business;

import com.example.club_HR.business.dto.Cell;
import com.example.club_HR.business.dto.Member;
import com.example.club_HR.persistence.ICellDao;
import com.example.club_HR.persistence.entity.CellEntity;
import com.example.club_HR.persistence.mapper.CellMapper;
import com.example.club_HR.persistence.mapper.MemberMapper;
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
    public void addCell(Cell cell) {
        cell.setCellRef("code_" + cell.getCellName().substring(0,4));
        this.iCellDao.save(cellMapper.mapToCellEntity(cell));
    }

    @Override
    public void deleteCellByCellRef(String cellRef) {
        iCellDao.deleteCellEntityByCellRef(cellRef);
    }

    @Override
    public List<Cell> getAllCells() {
        List<CellEntity> cellEntitiesList = iCellDao.findAll();

        return cellEntitiesList
                .stream()
                .map(cellEntity -> cellMapper.mapToCell(cellEntity))
                .collect(Collectors.toList());
    }

    @Override
    public void addMemberToCell(String email, String cellRef) {
        //recuperer le membre avec id == id
        Member member = iMemberService.getMemberByEmail(email);
        Cell cell = this.getCellByCellRef(cellRef);

        if (!cell.getMembers().contains(member)){
            cell.getMembers().add(member);
            iCellDao.save(cellMapper.mapToCellEntity(cell));
        }

    }

    @Override
    public Cell getCellByCellRef(String cellRef) {
        return iCellDao.findCellEntityByCellRef(cellRef) != null ? cellMapper.mapToCell(iCellDao.findCellEntityByCellRef(cellRef)) : null;
    }

    @Override
    public void deleteMemberFromCell(String email, String cellRef) {
        //recuperer le membre avec id == id
        Member member = iMemberService.getMemberByEmail(email);
        Cell cell = this.getCellByCellRef(cellRef);
        if (!cell.getMembers().contains(member)){
            cell.getMembers().remove(member);
            iCellDao.delete(cellMapper.mapToCellEntity(cell));
        }
    }

    public void update(String cellRef, Cell cell){

    }
}
