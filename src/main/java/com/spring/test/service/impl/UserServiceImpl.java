package com.spring.test.service.impl;

import com.spring.test.domain.User;
import com.spring.test.repository.UserRepository;
import com.spring.test.service.UserService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User add(User user) {
        return userRepository.add(user);
    }

    @Override
    public List<User> listUsers() {
        return userRepository.listUsers();
    }

    @Override
    public User getById(Long id) {
        return userRepository.getById(id);
    }
}
