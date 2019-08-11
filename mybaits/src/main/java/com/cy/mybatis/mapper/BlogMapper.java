package com.cy.mybatis.mapper;

import com.cy.mybatis.beans.Blog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogMapper {

    List<Blog> findActiveBlogWithTitleLike1(@Param("title") String title);

    List<Blog> findActiveBlogWithTitleLike2(Blog blog);

    void updateBlogIfNessary(Blog blog);

    List<Blog> selectBlogIn(@Param("ids")List<Integer> ids);

    Blog selectBlog(@Param("id")Integer id);

    Blog selectBlog2(@Param("id")Integer id);

}
