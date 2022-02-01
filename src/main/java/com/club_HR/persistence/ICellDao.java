package com.club_HR.persistence;

import com.club_HR.persistence.entity.CellEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//cette interface permet de gérer l'entite member
public interface ICellDao extends JpaRepository<CellEntity,Long> {

    CellEntity findCellEntityByCellRef(String cellRef);
    CellEntity deleteCellEntityByCellRef(String cellRef);



}
