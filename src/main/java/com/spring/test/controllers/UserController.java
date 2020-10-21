package com.spring.test.controllers;

import com.spring.test.domain.User;
import com.spring.test.dto.UserDto;
import com.spring.test.service.UserDtoService;
import com.spring.test.service.UserService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
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
    public void inject() throws Exception {
        Map<String, String[]> credencials = new HashMap<>() {{
                put("setName", new String[]{"Alice", "Bob", "Jack", "John"});
                put("setEmail", new String[]{
                        "alice@gmail.com",
                        "bob@gmail.com",
                        "jack@gmail.com",
                        "John@gmail.com"});
                put("setPassword", new String[]{"1234", "1234", "1234", "1234"});
            }};
        for (int i = 0; i < 4; i++) {
            User.Builder user = User.builder();
            for (String key : credencials.keySet()) {
                user.getClass().getDeclaredMethod(
                        key, String.class).invoke(user, credencials.get(key)[i]);
            }
            userService.add(user.build());
        }
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable Long id) {
        return userDtoService.getById(id);
    }

    @GetMapping("/")
    public List<UserDto> getAll() {
        return userDtoService.getAll();
    }
}
