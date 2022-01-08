package com.example.club_HR.persistence;

import com.example.club_HR.persistence.entity.CellEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//cette interface permet de gérer l'entite member
public interface ICellDao extends JpaRepository<CellEntity,Long> {

    CellEntity findCellEntityByCellName(String name);
    CellEntity deleteCellEntityByCellName(String name);
    CellEntity findCellEntityByCellRef(String cellRef);
    CellEntity deleteCellEntityByCellRef(String cellRef);



}
