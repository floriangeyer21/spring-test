package com.spring.test.controllers;

import com.spring.test.domain.User;
import com.spring.test.dto.UserDto;
import com.spring.test.service.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/inject")
    public void inject() throws Exception {
        userService.add(User.builder().setName("Alice")
                .setEmail("alice@gmail.com").setPassword("1234").build());
        userService.add(User.builder().setName("Bob")
                .setEmail("bob@gmail.com").setPassword("1234").build());
        userService.add(User.builder().setName("Jack")
                .setEmail("jack@gmail.com").setPassword("1234").build());
        userService.add(User.builder().setName("John")
                .setEmail("John@gmail.com").setPassword("1234").build());
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable Long id) {
        User user = userService.getById(id);
        return convertUserToUserDto(user);
    }

    @GetMapping("/")
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
