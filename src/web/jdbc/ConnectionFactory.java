package web.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection getConnection(String url) {
		Connection conn = null;
		try {
			// ����ͨ��Class.forName�������ؽ�ȥ��Ҳ����ͨ����ʼ������������������������ʽ������
			Class.forName("com.mysql.jdbc.Driver");// ��̬����mysql����
			// 2 com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
			// 3 new com.mysql.jdbc.Driver();
			// һ��Connection����һ�����ݿ�����
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
