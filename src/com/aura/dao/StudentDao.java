package com.aura.dao;

import java.util.List;

import com.aura.entity.Student;

public interface StudentDao {
	//��ѯ��������
	public List<Student> selStudent();
	//����
	public boolean addStudent(Student s);
	//ɾ��
	public int delStudent(int sid);
	//����
	public int updateStudent(Student s);

}
