import org.apache.ibatis.session.SqlSession;
import org.example.dao.UserMapper;
import org.example.pojo.User;
import org.example.utils.MybatisUtils;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
	@Test
	public void test() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();

		// 底层主要应用反射
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);

		List<User> users = mapper.getUsers();

		for (User user : users) {
			System.out.println(user);
		}

		sqlSession.close();
	}

	@Test
	public void getUserByIdTest() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();

		// 底层主要应用反射
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);

		User user = mapper.getUserById(1);

		System.out.println(user);

		sqlSession.close();
	}

	@Test
	public void addUserTest() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();

		// 底层主要应用反射
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);

		int i = mapper.addUser(new User(6, "hello", "5662"));

		System.out.println("插入结果：" + i);

		sqlSession.close();
	}

	@Test
	public void updateUserTest() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();

		// 底层主要应用反射
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);

		int i = mapper.updateUser(new User(1, "hhh", "666666"));

		System.out.println("更新结果：" + i);

		sqlSession.close();
	}

	@Test
	public void deleteUserTest() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();

		// 底层主要应用反射
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);

		int i = mapper.deleteUser(6);

		System.out.println("删除结果：" + i);

		sqlSession.close();
	}
}
