package com.example.club_HR.business;

import com.example.club_HR.business.dto.Cell;

import java.util.List;

public interface ICellService {

     void addCell(Cell cell);
     void deleteCellByCellRef(String cellRef);
     List<Cell> getAllCells();
     void addMemberToCell(String email, String cellRef);
     Cell getCellByCellRef(String cellRef);
     void deleteMemberFromCell(String email, String cellRef );



}
