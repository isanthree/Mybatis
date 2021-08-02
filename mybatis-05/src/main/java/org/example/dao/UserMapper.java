package org.example.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.pojo.User;

import java.util.List;

public interface UserMapper {

	@Select("select * from user")
	List<User> getUsers();

	// 方法存在多个参数，参数前面需要加入 @Param 注解，一个参数可写可不写
	@Select("select * from user where id = #{id}")
	User getUserById(@Param("id") int id);

	@Insert("insert into user(id, name, pwd) values (#{id}, #{name}, #{password})")
	int addUser(User user);

	@Update("update user set name = #{name}, pwd = #{password} where id = #{id}")
	int updateUser(User user);

	@Delete("delete from user where id = #{uid}")
	int deleteUser(@Param("uid") int id);
}
