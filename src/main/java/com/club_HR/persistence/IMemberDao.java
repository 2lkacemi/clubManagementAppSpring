package com.club_HR.persistence;

import com.club_HR.persistence.entity.MemberEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Transactional
public interface IMemberDao extends JpaRepository<MemberEntity, Long> {
    Optional<MemberEntity> findMemberEntityByEmail(String email);
    void deleteByEmail(String email);
    Page<MemberEntity> findMemberEntityByEmail(String email, Pageable pageable);

}
