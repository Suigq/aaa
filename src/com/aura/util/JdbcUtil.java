package com.aura.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
	private static String driver = "";
	private static String url = "";
	private static String user = "";
	private static String pwd = "";
	static {
		try {
			// 读取属性文件
			Properties p = new Properties();
			InputStream is = JdbcUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
			try {
				p.load(is);
				is.close();
				driver = p.getProperty("jdbc.driver");
				url = p.getProperty("jdbc.url");
				user = p.getProperty("jdbc.user");
				pwd = p.getProperty("jdbc.pwd");
				Class.forName(driver);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block e.printStackTrace();
		}
	}

	// 创建连接对象
	public static Connection getConnection() {
		// 连接对象
		Connection connection = null;
		try {
			// 加载驱动
			connection = DriverManager.getConnection(url, user, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	// 释放资源
	public static void closeAll(ResultSet rs, PreparedStatement statement, Connection connection) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closeAll(PreparedStatement statement, Connection connection) {
		try {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
