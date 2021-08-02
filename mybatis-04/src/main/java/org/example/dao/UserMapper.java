package org.example.dao;

import org.example.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
	// 查询全部用户
	List<User> getUserList();

	User getUserById(int id);

	// 分页查询：SQL 语句 ———— Limit
	List<User> getUserByLimit(Map<String, Integer> map);

	// 分页查询：RowBounds
	List<User> getUserByRowBounds();
}
