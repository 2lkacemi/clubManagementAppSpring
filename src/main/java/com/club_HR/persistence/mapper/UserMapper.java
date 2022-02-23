package com.club_HR.persistence.mapper;


import com.club_HR.business.dto.UserDto;
import com.club_HR.business.enums.Gender;
import com.club_HR.persistence.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity mapToUserEntity(UserDto userDto){
        UserEntity userEntity = new UserEntity();

        userEntity.setId(userDto.getId());
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setTel(userDto.getTel());
        userEntity.setGender(userDto.getGender());
        userEntity.setPromo(userDto.getPromo());

        return userEntity;
    }

    public UserDto mapToUserDto(UserEntity userEntity ){
        UserDto userDto  = new UserDto();

        userDto.setId(userEntity.getId());
        userDto.setFirstName(userEntity.getFirstName());
        userDto.setLastName(userEntity.getLastName());
        userDto.setEmail(userEntity.getEmail());
        userDto.setPassword(userEntity.getPassword());
        userDto.setTel(userEntity.getTel());
        userDto.setGender(userEntity.getGender());
        userDto.setPromo(userEntity.getPromo());

        return userDto;
    }


}
