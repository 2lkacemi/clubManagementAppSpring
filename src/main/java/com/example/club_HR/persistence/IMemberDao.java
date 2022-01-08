package com.example.club_HR.persistence;

import com.example.club_HR.persistence.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//cette interface permet de gérer l'entite member
public interface IMemberDao extends JpaRepository<MemberEntity, Long> {
    Optional<MemberEntity> findMemberEntityByEmail(String email);
}
