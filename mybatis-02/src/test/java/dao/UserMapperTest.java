package dao;

import org.apache.ibatis.session.SqlSession;
import org.example.dao.UserMapper;
import org.example.pojo.User;
import org.example.utils.MybatisUtils;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

	@Test
	public void getUserListTest() {
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
}
