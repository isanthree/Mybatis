import org.apache.ibatis.session.SqlSession;
import org.example.dao.UserMapper;
import org.example.pojo.User;
import org.example.utils.MybatisUtils;
import org.junit.Test;

public class MyTest {
	@Test
	public void getUserByIdTest() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();

		UserMapper mapper = sqlSession.getMapper(UserMapper.class);

		User user = mapper.getUserById(1);
		System.out.println(user);

		sqlSession.clearCache();  // 手动清理缓存

		User user2 = mapper.getUserById(1);
		System.out.println(user2);

		System.out.println(user==user2);

		sqlSession.close();
	}

	@Test
	public void cacheTest() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		SqlSession sqlSession2 = MybatisUtils.getSqlSession();

		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = mapper.getUserById(1);
		System.out.println(user);
		sqlSession.close();

		UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
		User user2 = mapper2.getUserById(1);
		System.out.println(user2);
		sqlSession2.close();
	}
}
