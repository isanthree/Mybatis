package org.example.dao;

import org.example.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
	int addBlog(Blog blog);

	// IF 查询
	List<Blog> queryBlogWithIf(Map map);

	List<Blog> queryBlogWithChoose(Map map);

	// 更新
	int updateBlog(Map map);

	// 查询第 1、2、3 号记录的 blog
	List<Blog> queryBlogWithForeach(Map map);
}
