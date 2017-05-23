package web.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection getConnection(String url) {
		Connection conn = null;
		try {
			// 可以通过Class.forName把它加载进去，也可以通过初始化来驱动起来，下面三种形式都可以
			Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
			// 2 com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
			// 3 new com.mysql.jdbc.Driver();
			// 一个Connection代表一个数据库连接
			conn = DriverManager.getConnection(url);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
