package com.aura.entity;

import java.io.Serializable;

public class Student implements Serializable{

	private Integer sid;
	private String sname;
	private String gender;

	public Student(Integer sid, String sname, String gender) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", gender=" + gender +  "]";
	}
	public Student() {
		super();
	}
	public  Integer getsid() {
		return sid;
	}
	public void setsid(Integer sid) {
		this.sid = sid;
	}
	public String getsname() {
		return sname;
	}
	public void setsname(String sname) {
		this.sname = sname;
	}
	public String getgender() {
		return gender;
	}
	public void setgender(String gender) {
		this.gender = gender;
	}

}
