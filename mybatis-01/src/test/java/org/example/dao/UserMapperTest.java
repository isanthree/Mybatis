package org.example.dao;

import org.apache.ibatis.session.SqlSession;
import org.example.pojo.User;
import org.example.utils.MybatisUtils;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
	@Test
	public void test() {
		SqlSession sqlSession = null;

		try {
			// 第一步：获得 SqlSession 对象
			sqlSession = MybatisUtils.getSqlSession();

			// 方式一：getMapper
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			List<User> userList = userMapper.getUserList();

			// 方式二：不建议使用
//			List<User> userList = sqlSession.selectList("org.example.dao.UserDao.getUserList");

			for (User user : userList) {
				System.out.println(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭 SqlSession
			sqlSession.close();
		}
	}
}
