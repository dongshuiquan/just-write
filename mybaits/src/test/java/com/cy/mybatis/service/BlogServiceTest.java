package com.cy.mybatis.service;

import com.cy.mybatis.beans.Blog;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by DELL on 2018/11/7.
 */
public class BlogServiceTest {

    BlogService service = new BlogService();

    @Test
    public void findActiveBlogWithTitleLike1() {
        List<Blog> blogs = service.findActiveBlogWithTitleLike1("title");
        System.out.println(blogs);
    }

    @Test
    public void findActiveBlogWithTitleLike2() {
        Blog blog = new Blog();
        blog.setTitle("title1");
        List<Blog> blogs = service.findActiveBlogWithTitleLike2(blog);
        System.out.println(blogs);
    }

    @Test
    public void updateBlogIfNessary() {
        Blog blog = new Blog();
        blog.setId(1);
        blog.setTitle("title111");
        blog.setState("ACTIVE");
        blog.setContent("qwertyuiosdfghjk");
        service.updateBlogIfNessary(blog);

    }

    @Test
    public void selectBlogIn() {
        List<Integer> ids = Arrays.asList(new Integer[]{1, 2});
        List<Blog> blogs = service.selectBlogIn(ids);
        System.out.println(blogs);
    }

    @Test
    public void selectBlog() {
        Blog blogs = service.selectBlog(1);
        System.out.println("=========lazy=====");
        System.out.println(blogs);
    }

    @Test
    public void selectBlog2() {
        Blog blogs = service.selectBlog2(1);
        System.out.println(blogs);
    }
}
