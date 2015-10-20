package com.aironman.cassandra.pojo;

public class UserCredentials {

	/***
	 * email text,
    password text,
    userid uuid,
	 */
	public String email;
	public String password;
	public String userid;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "UserCredentials [email=" + email + ", password=" + password + ", userid=" + userid + "]";
	}
	
	
}
