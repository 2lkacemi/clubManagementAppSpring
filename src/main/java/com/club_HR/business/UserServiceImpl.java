package com.club_HR.business;

import com.club_HR.business.dto.UserDto;
import com.club_HR.persistence.IUserDao;
import com.club_HR.persistence.entity.UserEntity;
import com.club_HR.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService{

    final private IUserDao iUserDao;
    final private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(IUserDao iUserDao, UserMapper userMapper) {
        this.iUserDao = iUserDao;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        this.iUserDao.save(userMapper.mapToUserEntity(userDto));
        return userDto;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserEntity> userEntityList = iUserDao.findAll();
        return userEntityList
                .stream()
                .map(userMapper::mapToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getUserByEmail(String email) {
        return iUserDao.findUserEntityByEmail(email)
                .map(userMapper::mapToUserDto)
                .orElse(null);
    }

    @Override
    public void removeUserByEmail(String email) {
        iUserDao.deleteByEmail(email);
    }

    @Override
    public void updateUser(UserDto userDto) {
        iUserDao.save(userMapper.mapToUserEntity(userDto));

    }
}
