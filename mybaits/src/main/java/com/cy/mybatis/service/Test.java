package com.cy.mybatis.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by DELL on 2018/8/13.
 */
public class Test {

    public static void main(String[] args) throws Exception {
        test02();
    }


    static void test01() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true");

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select 1 from t_user");
        System.out.println(resultSet.next());
    }

    static void test02() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:dong", "infodba", "infodba");

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select 2 *3 from dual");
        if(resultSet.next()) {
            int anInt = resultSet.getInt(1);
            System.out.println(anInt);

        }
    }
}
