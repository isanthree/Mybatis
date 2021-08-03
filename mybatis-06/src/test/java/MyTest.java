import org.apache.ibatis.session.SqlSession;
import org.example.dao.StudentMapper;
import org.example.dao.TeacherMapper;
import org.example.pojo.Student;
import org.example.pojo.Teacher;
import org.example.utils.MybatisUtils;
import org.junit.Test;

import java.util.List;

public class MyTest {
	@Test
	public void getTeacherTest() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
		Teacher teacher = mapper.getTeacher(1);
		System.out.println(teacher);
		sqlSession.close();
	}

	@Test
	public void getStudentTest() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		List<Student> studentList = mapper.getStudent();
		for (Student student : studentList) {
			System.out.println(student);
		}
		sqlSession.close();
	}

	@Test
	public void getStudentTest2() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		List<Student> studentList = mapper.getStudent2();
		for (Student student : studentList) {
			System.out.println(student);
		}
		sqlSession.close();
	}
}
