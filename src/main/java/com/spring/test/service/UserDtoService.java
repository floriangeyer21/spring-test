package com.spring.test.service;

import com.spring.test.dto.UserDto;

import java.util.List;

public interface UserDtoService {

    UserDto getById();

    List<UserDto> getAll();
}
