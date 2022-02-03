package com.club_HR.business;

import com.club_HR.business.dto.CellDto;

import java.util.List;


public interface ICellService {

     CellDto addCell(CellDto cellDto);
     void deleteCellByCellRef(String cellRef);
     List<CellDto> getAllCells();
     void addMemberToCell(String email, String cellRef);
     CellDto getCellByCellRef(String cellRef);
     void deleteMemberFromCell(String email, String cellRef );



}
