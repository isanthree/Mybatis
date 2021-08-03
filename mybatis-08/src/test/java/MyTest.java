import org.apache.ibatis.session.SqlSession;
import org.example.dao.BlogMapper;
import org.example.pojo.Blog;
import org.example.utils.IDUtils;
import org.example.utils.MybatisUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest {
	@Test
	public void addInitBlog() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

		Blog blog = new Blog();
		blog.setId(IDUtils.getId());
		blog.setTitle("Mybatis 学习");
		blog.setAuthor("hhh");
		blog.setCreateTime(new Date());
		blog.setViews(9999);

		mapper.addBlog(blog);

		blog.setId(IDUtils.getId());
		blog.setTitle("Java 学习");
		mapper.addBlog(blog);

		blog.setId(IDUtils.getId());
		blog.setTitle("Spring 学习");
		mapper.addBlog(blog);

		blog.setId(IDUtils.getId());
		blog.setTitle("微服务学习");
		mapper.addBlog(blog);

		sqlSession.close();
	}

	@Test
	public void queryBlogWithIfTest() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
		HashMap map = new HashMap();
		map.put("title", "Java 学习");
		map.put("author", "hhh");
		List<Blog> blogs = mapper.queryBlogWithIf(map);
		for (Blog blog : blogs) {
			System.out.println(blog);
		}
		sqlSession.close();
	}

	@Test
	public void queryBlogWithChooseTest() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
		HashMap map = new HashMap();
		map.put("title", "Java 学习");
		map.put("author", "hhh");
		List<Blog> blogs = mapper.queryBlogWithChoose(map);
		for (Blog blog : blogs) {
			System.out.println(blog);
		}
		sqlSession.close();
	}

	@Test
	public void updateBlogTest() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
		HashMap map = new HashMap();
		map.put("title", "Java study");
		map.put("author", "h-hh");
		map.put("id", "184f4e080ba54d89a076c1a7c4935892");
		int i = mapper.updateBlog(map);
		System.out.println("更新结果：" + i);
		sqlSession.close();
	}

	@Test
	public void queryBlogWithForeachTest() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

		Map map = new HashMap();
		ArrayList<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		ids.add(3);
		map.put("ids", ids);

		List<Blog> blogs = mapper.queryBlogWithForeach(map);

		for (Blog blog : blogs) {
			System.out.println(blog);
		}

		sqlSession.close();
	}
}
