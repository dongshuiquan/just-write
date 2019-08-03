package com.cy.mybatis.service;

import com.cy.mybatis.beans.UserBean;
import org.junit.Test;

import java.util.List;

/**
 * Created by DELL on 2018/11/7.
 */
public class UserserviceTest {

    Userservice userservice = new Userservice();

    @Test
    public void insert() {
        UserBean user = new UserBean("dong", "1314520", 7000.0);
        userservice.insertUser(user);
    }

    @Test
    public void getAll() {
        List<UserBean> userBeans = userservice.selectAllUser();
        userBeans.forEach(System.out::println);
    }

    @Test
    public void delete() {
        userservice.deleteUser(1);
        getAll();
    }

    @Test
    public void update() {
        UserBean userBean = new UserBean();
        userBean.setId(2);
        userBean.setUsername("shui");
        userBean.setPassword("321");

        userservice.update(userBean);
        getAll();
    }

}
