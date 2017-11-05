package com.david.edshirorolesystem.po;

/**
 * 用户登录
 * 
 * @author ：david
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @github: https://github.com/QQ986945193
 */
public class UserLogin {

	private Integer userid;

	private String username;

	private String password;

	private Integer role;

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}
}
