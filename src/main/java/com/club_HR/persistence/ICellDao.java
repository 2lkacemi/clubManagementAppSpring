package com.club_HR.persistence;

import com.club_HR.persistence.entity.CellEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

//cette interface permet de gérer l'entite member
@Transactional
public interface ICellDao extends JpaRepository<CellEntity, Long> {

    CellEntity findByCellRef(String cellRef);
    void deleteByCellRef(String cellRef);

    @Modifying
    @Query("update CellEntity u set u.cellName = :cellName  where u.cellRef = :cellRef")
    void updateCell(@Param(value = "cellRef") String cellRef, @Param(value = "cellName") String cellName);



}
