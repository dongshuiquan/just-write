package com.cy.mybatis.mapper;

/**
 * Created by DELL on 2018/8/13.
 */

import com.cy.mybatis.beans.UserBean;

        import java.util.List;
import java.util.Map;

import com.cy.mybatis.beans.UserBean;

public interface UserMapper {
    /**
     * 新增用戶
     * @param user
     * @return
     * @throws Exception
     */
    public int insertUser(UserBean user) throws Exception;
    /**
     * 修改用戶
     * @param user
     * @return
     * @throws Exception
     */
    public int updateUser (UserBean user) throws Exception;
    /**
     * 刪除用戶
     * @param id
     * @return
     * @throws Exception
     */
    public int deleteUser(int id) throws Exception;
    /**
     * 根据id查询用户信息
     * @param id
     * @return
     * @throws Exception
     */
    public UserBean selectUserById(int id) throws Exception;
    /**
     * 查询所有的用户信息
     * @return
     * @throws Exception
     */
    public List<UserBean> selectAllUser() throws Exception;

    public Map<String, Object> selectUserMapById(int id) throws Exception;
}