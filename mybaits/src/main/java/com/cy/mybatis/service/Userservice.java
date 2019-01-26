package com.cy.mybatis.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.cy.mybatis.beans.UserBean;
import com.cy.mybatis.mapper.UserMapper;
import org.junit.*;

public class Userservice {

    public static void main(String[] args) {
         //insertUser();
//        deleteUser();
       //selectUserById();

    }


    /**
     * 新增用户
     */
    public void insertUser(UserBean user) {
        SqlSession session = com.cy.mybatis.tools.DBTools.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        try {
            mapper.insertUser(user);
            System.out.println(user.toString());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }


    /**
     * 删除用户
     */
    private void deleteUser(){
        SqlSession session= com.cy.mybatis.tools.DBTools.getSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        try {
            mapper.deleteUser(1);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }


    /**
     * 根据id查询用户
     */
    private void selectUserById(){
        SqlSession session= com.cy.mybatis.tools.DBTools.getSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        try {
            UserBean user=    mapper.selectUserById(1);
            System.out.println(user.toString());

            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }

    /**
     * 查询所有的用户
     */

    public void selectAllUser(){
        SqlSession session = com.cy.mybatis.tools.DBTools.getSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        try {
            List<UserBean> user=mapper.selectAllUser();
            System.out.println(user.toString());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }


}