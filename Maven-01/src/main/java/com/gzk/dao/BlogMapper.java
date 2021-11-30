package com.gzk.dao;

import com.gzk.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    int addBlog(Blog blog);

    List<Blog> queryBlogTF(Map map);

    List<Blog> queryBlogChoose(Map map);

    int updateBlog(Map map);
}
