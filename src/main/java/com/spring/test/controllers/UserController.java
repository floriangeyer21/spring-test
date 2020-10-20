package com.spring.test.controllers;

import com.spring.test.domain.User;
import com.spring.test.dto.UserDto;
import com.spring.test.service.UserService;
import com.spring.test.service.UserDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user/")
public class UserController {
    private final UserDtoService userDtoService;
    private final UserService userService;

    @Autowired
    public UserController(UserDtoService userDtoService,
                          UserService userService) {
        this.userDtoService = userDtoService;
        this.userService = userService;
    }

    @GetMapping("/inject")
    public void inject() {
        Map<String, String[]> usersCredencial = new HashMap<String, String[]>(){{
            put( "getName", new String[]{"Alice", "Bob", "Jack", "John"});
            put( "getEmail", new String[]{
                    "alice@gmail.com",
                    "bob@gmail.com",
                    "jack@gmail.com",
                    "John@gmail.com"});
            put( "getPassword", new String[]{"1234", "1234", "1234", "1234"});
        }};
        for (int i = 0; i <= 4; i++) {
            User user = new User();
            for (String key : usersCredencial.keySet()) {
                String[] value = usersCredencial.get(key);
                try {
                    user.getClass().getMethod(key).invoke(user, value[i]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            userService.add(user);
        }
    }

    @GetMapping("/add/{name}")
    public void addUser(@PathVariable String name) {
        User user = User.builder().name(name).email("sfd").password("sdfd").build();
        userService.add(user);
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable Long id) {
         UserDto userDto = userDtoService.getById();
         return userDto;
    }

    @ResponseBody
    @GetMapping("/all")
    public List<User> getAll() {
        List<UserDto> users = userDtoService.getAll();
        return userService.listUsers();
    }
}
