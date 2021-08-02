package dao;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.example.dao.UserMapper;
import org.example.pojo.User;
import org.example.utils.MybatisUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {

	static Logger logger = Logger.getLogger(UserMapperTest.class);


	@Test
	public void getUserTest() {
		SqlSession sqlSession = null;
		try {
			// 第一步：获得 SqlSession 对象
			sqlSession = MybatisUtils.getSqlSession();
			// 第二步：获取 Mapper
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			List<User> userList = mapper.getUserList();

			for (User user : userList) {
				System.out.println(user);
			}
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
			// 第三步：执行 sql 语句
			User user = mapper.getUserById(1);
			System.out.println("查询结果：" + user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭 SqlSession
			if (sqlSession != null)
				sqlSession.close();
		}
	}

	@Test
	public void log4jTest() {
		logger.info("info：进入了 log4jTest() ......");
		logger.debug("debug：进入了 log4jTest() ......");
		logger.error("error：进入了 log4jTest() ......");
	}

	/**
	 * 分页查询：Limit
	 */
	@Test
	public void getUserByLimitTest() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startIndex", 0);
		map.put("pageSize", 2);

		List<User> userList = mapper.getUserByLimit(map);
		for (User user : userList) {
			System.out.println(user);
		}

		sqlSession.close();
	}

	/**
	 * 分页查询：通过 Java 代码层面实现分页
	 */
	@Test
	public void getUserByRowBoundsTest() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();

		// RowBounds 实现
		RowBounds rowBounds = new RowBounds(1, 2);

		// 通过 Java 代码层面实现分页
		List<User> userList = sqlSession.selectList("org.example.dao.UserMapper.getUserByRowBounds", null, rowBounds);

		for (User user : userList) {
			System.out.println(user);
		}

		sqlSession.close();
	}

}
