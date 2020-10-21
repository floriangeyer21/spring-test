package com.spring.test.service.impl;

import com.spring.test.domain.User;
import com.spring.test.dto.UserDto;
import com.spring.test.service.UserDtoService;
import com.spring.test.service.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDtoServiceImpl implements UserDtoService {
    private final UserService userService;

    @Autowired
    public UserDtoServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDto getById(Long id) {
        User user = userService.getById(id);
        return convertUserToUserDto(user);
    }

    @Override
    public List<UserDto> getAll() {
        List<User> users = userService.listUsers();
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : users) {
            userDtoList.add(convertUserToUserDto(user));
        }
        return userDtoList;
    }

    private UserDto convertUserToUserDto(User user) {
        UserDto.Builder userDto = UserDto.newBuilder()
                .setName(user.getName())
                .setEmail(user.getEmail())
                .setPassword(user.getPassword());
        return userDto.build();
    }
}
