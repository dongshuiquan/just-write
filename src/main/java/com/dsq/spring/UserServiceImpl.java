package com.dsq.spring;

import org.springframework.stereotype.Service;

/**
 * Created by DELL on 2018/4/27.
 */


public class UserServiceImpl implements UserService {
    @Override
    public String hello() {
        return "userService Hello";
    }

    @Override
    public String addUser(String name) {
        return "addUser " + name;
    }

    @Override
    public String addUser(int i) {
        return "addUser " + i;
    }
}
