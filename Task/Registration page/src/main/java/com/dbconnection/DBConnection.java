package com.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	public static final String URL = "jdbc:mysql://localhost:3306/webapp";
	public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	public static final String USER = "root";
	public static final String PASSWORD = "root";

	public static Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Class.forName(DRIVER_CLASS);
		Connection connection = (Connection) DriverManager.getConnection(URL,
				USER, PASSWORD);
		return connection;
	}

	public static void dbCleanup(Connection con, PreparedStatement ptst,
			ResultSet rs) {
		close(con);
		close(ptst);
		close(rs);
	}

	public static void dbCleanUp(Connection conn, PreparedStatement ps) {
		close(conn);
		close(ps);
	}

	public static void close(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException sqlexp) {
				sqlexp.printStackTrace();
			}
		}
	}

	public static void close(PreparedStatement pStatement) {
		if (pStatement != null) {
			try {
				pStatement.close();
			} catch (SQLException sqlexp) {
				sqlexp.printStackTrace();
			}
		}
	}

	public static void close(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException sqlexp) {
				sqlexp.printStackTrace();
			}
		}
	}
}