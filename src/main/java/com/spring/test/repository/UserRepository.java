package com.spring.test.repository;

import com.spring.test.domain.User;
import java.util.List;

public interface UserRepository {
    User add(User user);

    List<User> listUsers();
}
