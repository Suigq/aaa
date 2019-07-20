package com.aura.daoimpl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;


import java.sql.Statement;
import com.aura.dao.StudentDao;
import com.aura.entity.Student;
import com.aura.util.JdbcUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDaoImpl implements StudentDao {
	private Student s;
	//查询所有数据
	public List<Student> selStudent() {
		List<Student> list=new ArrayList<Student>();
		Connection connection=null;
		PreparedStatement statement=null;
		ResultSet rs=null;
		try {
		connection=JdbcUtil.getConnection();
		String sql="select *from Student";
		statement=connection.prepareStatement(sql);
		rs=statement.executeQuery(sql);
			while(rs.next()) {
				int sid=rs.getInt("sid");
				String sname = rs.getString("sname"); 
				String gender = rs.getString("gender"); 
				Student s=new Student(sid,sname,gender);
				list.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.closeAll(rs, statement, connection);
		}
		return list;
	}
	//增加
	public boolean  addStudent(Student s) {
		boolean flag= false;
		Connection connection=null;
		PreparedStatement statement=null;
	try {
		connection=JdbcUtil.getConnection();
		String sql="insert into Student (sid,sname,gender) values (?,?,?)";
		statement=connection.prepareStatement(sql);
		statement.setInt(1, s.getsid());
		statement.setString(2, s.getsname());
		statement.setString(3, s.getgender());
        int n = statement.executeUpdate();
        if(n!=0) {
			flag=true;
		}
	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.closeAll(statement, connection);
		}
	return flag;
	}
	//删除
	
	public int delStudent(int sid) {
		int n=0;
		Connection connection=null;
		PreparedStatement statement=null;
		try {
		connection=JdbcUtil.getConnection();
		String sql ="delete from Student where sid = ?";
		statement=connection.prepareStatement(sql);
		statement.setInt(1,sid);
			n=statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.closeAll(statement, connection);
		}
		return n;
	}
	//更改
	public int updateStudent(Student s) {
		int n=0;
		Connection connection=null;
		PreparedStatement statement=null;
		try {
		connection=JdbcUtil.getConnection();
		String sql ="update Student set sname=?,gender=? where sid=?";
		statement=connection.prepareStatement(sql);
		statement.setInt(3,s.getsid());
		statement.setString(1, s.getsname());
		statement.setString(2, s.getgender());
		
			n=statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.closeAll(statement, connection);
		}
		return n;
	}
	public List<Student> getStudent(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Student> getStudent(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
