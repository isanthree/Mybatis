package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.pojo.User;

import java.util.List;

public interface UserMapper {

	User getUserById(@Param("id") int id);

	int updateUser(User user);
}
