package com.spring.test;

import com.spring.test.config.ApplicationConfig;
import com.spring.test.domain.User;
import com.spring.test.service.UserService;
import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Log4j
public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ApplicationConfig.class);
        UserService userService = context.getBean(UserService.class);

        userService.add(User.builder().name("Alice")
                .email("alicebetterthanbob@gmail.com")
                .password("12345")
                .build());
        userService.add(User.builder().name("Bob")
                .email("bobdisagree@gmail.com")
                .password("12345")
                .build());

        userService.listUsers().forEach(log::info);
    }

}

