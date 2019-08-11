package com.cy.mybatis.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.cy.mybatis.beans.UserBean;
import com.cy.mybatis.mapper.UserMapper;
import org.junit.*;

public class Userservice {

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
    public void deleteUser(int id) {
        SqlSession session = com.cy.mybatis.tools.DBTools.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        try {
            mapper.deleteUser(id);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }


    /**
     * 根据id查询用户
     */
    public void selectUserById(int id) {
        SqlSession session = com.cy.mybatis.tools.DBTools.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        try {
            UserBean user = mapper.selectUserById(id);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }

    /**
     * 查询所有的用户
     */

    public List<UserBean> selectAllUser() {
        SqlSession session = com.cy.mybatis.tools.DBTools.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<UserBean> userBeans = null;
        try {
            userBeans = mapper.selectAllUser();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return userBeans;
    }

    public void update(UserBean user) {
        SqlSession session = com.cy.mybatis.tools.DBTools.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        try {
            mapper.updateUser(user);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }

    /**
     * 根据id查询用户
     */
    public Map<String, Object> selectUserMapById(int id) {
        SqlSession session = com.cy.mybatis.tools.DBTools.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        Map<String, Object> user = null;
        try {
            user = mapper.selectUserMapById(id);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return user;
    }

}