package com.spring.test.service;

import com.spring.test.domain.User;
import java.util.List;

public interface UserService {
    User add(User user);

    List<User> listUsers();

    User getById(Long id);
}
