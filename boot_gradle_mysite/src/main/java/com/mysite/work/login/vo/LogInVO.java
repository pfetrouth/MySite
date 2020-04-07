package com.mysite.work.login.vo;

public class LogInVO {

	String uid; 
	String pwd;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "LogInVO [uid=" + uid + ", pwd=" + pwd + "]";
	}
}
