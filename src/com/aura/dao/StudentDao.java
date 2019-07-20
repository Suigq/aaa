package com.aura.dao;

import java.util.List;

import com.aura.entity.Student;

public interface StudentDao {
	//查询所有数据
	public List<Student> selStudent();
	//增加
	public boolean addStudent(Student s);
	//删除
	public int delStudent(int sid);
	//更改
	public int updateStudent(Student s);

}
