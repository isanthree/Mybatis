package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.pojo.Teacher;

import java.util.List;

public interface TeacherMapper {
	List<Teacher> getTeacher();

	// 获取指定老师下的所有学生以及老师的信息
	Teacher getTeacher2(@Param("tid") int id);

	Teacher getTeacher3(@Param("tid") int id);
}
