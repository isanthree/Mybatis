package org.example.dao;

import org.example.pojo.User;

import java.util.List;

public interface UserMapper {
	// 查询全部用户
	List<User> getUserList();
}
