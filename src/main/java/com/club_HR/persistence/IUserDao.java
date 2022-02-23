package com.club_HR.persistence;


import com.club_HR.persistence.entity.MemberEntity;
import com.club_HR.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public interface IUserDao extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findUserEntityByEmail(String email);
    void deleteByEmail(String email);

}
