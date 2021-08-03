import org.apache.ibatis.session.SqlSession;
import org.example.dao.TeacherMapper;
import org.example.pojo.Teacher;
import org.example.utils.MybatisUtils;
import org.junit.Test;

import java.util.List;

public class MyTest {
	@Test
	public void test() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();

		TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

		List<Teacher> teacherList = mapper.getTeacher();

		for (Teacher teacher : teacherList) {
			System.out.println(teacher);
		}

		sqlSession.close();
	}

	@Test
	public void getTeacher2() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();

		TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

		Teacher teacher = mapper.getTeacher2(1);

		System.out.println(teacher);

		sqlSession.close();
	}

	@Test
	public void getTeacher3() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();

		TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

		Teacher teacher = mapper.getTeacher3(1);

		System.out.println(teacher);

		sqlSession.close();
	}
}
