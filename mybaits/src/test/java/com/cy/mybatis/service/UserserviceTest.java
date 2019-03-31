package com.cy.mybatis.service;

import com.cy.mybatis.beans.UserBean;
import org.junit.Test;

/**
 * Created by DELL on 2018/11/7.
 */
public class UserserviceTest {

    Userservice userservice = new Userservice();

    @Test
    public void testInsert() {
        UserBean user = new UserBean("dong", "1314520", 7000.0);
        userservice.insertUser(user);
    }

}
