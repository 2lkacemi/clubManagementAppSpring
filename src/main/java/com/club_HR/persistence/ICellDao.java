package com.club_HR.persistence;

import com.club_HR.persistence.entity.CellEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

//cette interface permet de gérer l'entite member
@Transactional
public interface ICellDao extends JpaRepository<CellEntity, Long> {

    CellEntity findByCellRef(String cellRef);
    void deleteByCellRef(String cellRef);



}
