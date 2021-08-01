package org.example.dao;

import org.apache.ibatis.session.SqlSession;
import org.example.pojo.User;
import org.example.utils.MybatisUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
			assert sqlSession != null;
			sqlSession.close();
		}
	}

	@Test
	public void getUserLikeTest() {
		SqlSession sqlSession = null;
		try {
			// 第一步：获得 SqlSession 对象
			sqlSession = MybatisUtils.getSqlSession();
			// 第二步：获取 Mapper
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			List<User> userList = mapper.getUserLike("五");
			System.out.println(userList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭 SqlSession
			if (sqlSession != null)
				sqlSession.close();
		}
	}

	@Test
	public void getUserByIdTest() {
		SqlSession sqlSession = null;
		try {
			// 第一步：获得 SqlSession 对象
			sqlSession = MybatisUtils.getSqlSession();
			// 第二步：获取 Mapper
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			User user = mapper.getUserById(1);
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭 SqlSession
			if (sqlSession != null)
				sqlSession.close();
		}
	}

	@Test
	public void getUserById2Test() {
		SqlSession sqlSession = null;
		try {
			// 第一步：获得 SqlSession 对象
			sqlSession = MybatisUtils.getSqlSession();
			// 第二步：获取 Mapper
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("id", 4);

			User user = mapper.getUserById2(map);

			System.out.println(user);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭 SqlSession
			if (sqlSession != null)
				sqlSession.close();
		}
	}

	// 增删该需要提交事务
	@Test
	public void addUserTest() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);

		int res = mapper.addUser(new User(4, "刘翔", "123"));
		if (res > 0) {
			System.out.println("插入成功");
		}
		// 提交事务
		sqlSession.commit();
		// 关闭
		sqlSession.close();
	}

	@Test
	public void addUser2Test() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();

		UserMapper mapper = sqlSession.getMapper(UserMapper.class);

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("userId", 4);
		map.put("userName", "foot");
		map.put("password", 2333);

		int i = mapper.addUser2(map);
		System.out.println("sql 语句执行情况：" + i);

		sqlSession.commit();  // 记得提交事务

		sqlSession.close();
	}

	@Test
	public void updateUserTest() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);

		int res = mapper.updateUser(new User(4, "姚明", "000"));
		if (res > 0) {
			System.out.println("修改成功");
		}
		// 提交事务
		sqlSession.commit();
		// 关闭
		sqlSession.close();
	}

	@Test
	public void deleteUserTest() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);

		int id = 4;
		int res = mapper.deleteUser(id);
		if (res > 0) {
			System.out.println("成功删除 " + id + " 号用户");
		}
		// 提交事务
		sqlSession.commit();
		// 关闭
		sqlSession.close();
	}
}
