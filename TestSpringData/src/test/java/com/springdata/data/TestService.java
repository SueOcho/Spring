package com.springdata.data;

import com.springdata.data.service.UserService;
import junit.framework.TestCase;
import junit.framework.TestResult;
import org.springframework.beans.factory.annotation.Autowired;

public class TestService extends TestCase {

    @Autowired
    UserService userService;

    public static void main(String[] args) {

    }

    @Override
    public void run(TestResult result) {
        ;
        System.out.println(userService.findAll());
        userService.findAll().stream(). forEach(System.out::println);



    }
}

