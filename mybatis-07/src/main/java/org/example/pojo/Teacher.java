package org.example.pojo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data  // 使用了 lombok 插件
public class Teacher {
	private int id;
	private String name;
	private List<Student> students;  // 一个老师教多个学生
}
