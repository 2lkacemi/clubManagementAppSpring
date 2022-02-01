package com.club_HR.persistence;

import com.club_HR.persistence.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//cette interface permet de gérer l'entite member
@Repository
public interface IMemberDao extends JpaRepository<MemberEntity, Long> {
    Optional<MemberEntity> findMemberEntityByEmail(String email);
    void deleteMemberEntityByEmail(String email);
}
