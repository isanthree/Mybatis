package org.example.pojo;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * 实体类
 */
@Alias("user")  // 也可以给这个类起一个别名，配合 Mybatis typeAliases 配置一起使用
public class User implements Serializable {
	private int id;
	private String name;
	private String pwd;

	public User() {
	}

	public User(int id, String name, String pwd) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", pwd='" + pwd + '\'' +
				'}';
	}
}
