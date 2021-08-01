package org.example.dao;

import org.example.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

	List<User> getUserLike(String value);

	// 查询全部用户
	List<User> getUserList();

	// 根据 ID 查询用户
	User getUserById(int id);

	User getUserById2(Map<String, Object> map);

	// 插入
	int addUser(User user);

	// 万能的 Map
	int addUser2(Map<String, Object> map);

	// 修改
	int updateUser(User user);

	// 删除
	int deleteUser(int id);
}
