package com.aura.jbdc;

import java.util.List;

import org.junit.Test;

import com.aura.dao.StudentDao;
import com.aura.daoimpl.StudentDaoImpl;
import com.aura.entity.Student;


public class Test1{
	 StudentDao Student=new StudentDaoImpl();
	//����
	@Test
	public void  test1() {
		boolean flag1=Student.addStudent(new Student(1,"����","��"));
		System.out.println(flag1?"��ӳɹ�":"���ʧ��");
		boolean flag2=Student.addStudent(new Student(2,"����","��"));
		System.out.println(flag2?"��ӳɹ�":"���ʧ��");
		System.out.println("aa");
	}
	//��ѯ
	@Test
	public void test2() {
		List<Student>list=Student.selStudent();
		System.out.println(list);
	}
	//����
	@Test
	public void test3() {
		int n=Student.updateStudent(new Student(2,"����","Ů"));
		System.out.println(n!=0?"�޸ĳɹ�":"�޸�ʧ��");
	}
	//ɾ��
	@Test
	public void test4(){
		int n= Student.delStudent(1);
		System.out.println(n!=0?"ɾ���ɹ�":"ɾ��ʧ��");
	}
	
}
