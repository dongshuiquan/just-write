package com.cy.mybatis.service;

import com.cy.mybatis.beans.Blog;
import com.cy.mybatis.beans.UserBean;
import com.cy.mybatis.mapper.BlogMapper;
import com.cy.mybatis.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class BlogService {


    public List<Blog> findActiveBlogWithTitleLike1(String title) {
        SqlSession session = com.cy.mybatis.tools.DBTools.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        List<Blog> blogs = null;
        try {
            blogs = mapper.findActiveBlogWithTitleLike1("%" + title + "%");
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return blogs;
    }

    public List<Blog> findActiveBlogWithTitleLike2(Blog blog) {
        SqlSession session = com.cy.mybatis.tools.DBTools.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        List<Blog> blogs = null;
        try {
            blogs = mapper.findActiveBlogWithTitleLike2(blog);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return blogs;
    }

    public void updateBlogIfNessary(Blog blog) {
        SqlSession session = com.cy.mybatis.tools.DBTools.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        List<Blog> blogs = null;
        try {
            mapper.updateBlogIfNessary(blog);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }

    public List<Blog> selectBlogIn(List<Integer> ids) {
        SqlSession session = com.cy.mybatis.tools.DBTools.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        List<Blog> blogs = null;
        try {
            blogs = mapper.selectBlogIn(ids);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return blogs;
    }



    public Blog selectBlog(Integer id) {
        SqlSession session = com.cy.mybatis.tools.DBTools.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        Blog blog = null;
        try {
            blog = mapper.selectBlog(id);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return blog;
    }

    public Blog selectBlog2(Integer id) {
        SqlSession session = com.cy.mybatis.tools.DBTools.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        Blog blog = null;
        try {
            blog = mapper.selectBlog2(id);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return blog;
    }
}