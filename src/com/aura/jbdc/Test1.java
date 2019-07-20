package com.aura.jbdc;

import java.util.List;

import org.junit.Test;

import com.aura.dao.StudentDao;
import com.aura.daoimpl.StudentDaoImpl;
import com.aura.entity.Student;


public class Test1{
	 StudentDao Student=new StudentDaoImpl();
	//增加
	@Test
	public void  test1() {
		boolean flag1=Student.addStudent(new Student(1,"张三","男"));
		System.out.println(flag1?"添加成功":"添加失败");
		boolean flag2=Student.addStudent(new Student(2,"李四","男"));
		System.out.println(flag2?"添加成功":"添加失败");
		System.out.println("aa");
	}
	//查询
	@Test
	public void test2() {
		List<Student>list=Student.selStudent();
		System.out.println(list);
	}
	//更改
	@Test
	public void test3() {
		int n=Student.updateStudent(new Student(2,"李四","女"));
		System.out.println(n!=0?"修改成功":"修改失败");
	}
	//删除
	@Test
	public void test4(){
		int n= Student.delStudent(1);
		System.out.println(n!=0?"删除成功":"删除失败");
	}
	
}
