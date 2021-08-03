package org.example.pojo;

import lombok.Data;

@Data  // 使用了 lombok 插件
public class Student {
	private int id;
	private String name;
	private int tid;
}
