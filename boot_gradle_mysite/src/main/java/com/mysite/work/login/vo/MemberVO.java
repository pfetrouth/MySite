package com.mysite.work.login.vo;

public class MemberVO {
	
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", resno=" + resno + ", in_id=" + in_id
				+ ", in_dt=" + in_dt + ", up_id=" + up_id + ", up_dt=" + up_dt + "]";
	}
	private String id;
	private String pwd;
	private String name;
	private String resno;
	private String in_id;
	private String in_dt;
	private String up_id;
	private String up_dt;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getResno() {
		return resno;
	}
	public void setResno(String resno) {
		this.resno = resno;
	}
	public String getIn_id() {
		return in_id;
	}
	public void setIn_id(String in_id) {
		this.in_id = in_id;
	}
	public String getIn_dt() {
		return in_dt;
	}
	public void setIn_dt(String in_dt) {
		this.in_dt = in_dt;
	}
	public String getUp_id() {
		return up_id;
	}
	public void setUp_id(String up_id) {
		this.up_id = up_id;
	}
	public String getUp_dt() {
		return up_dt;
	}
	public void setUp_dt(String up_dt) {
		this.up_dt = up_dt;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	

}
