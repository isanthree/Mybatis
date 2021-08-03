package org.example.pojo;

import lombok.Data;  // 使用 lombok 插件

@Data  // 使用了 lombok 插件
public class Student {
	private int id;
	private String name;
	private Teacher teacher;  // 学生需要关联一个老师
}
