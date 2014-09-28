package br.com.magnum.exemplo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() {
		try {
		return DriverManager.getConnection(
		"jdbc:mysql://localhost/magnum", "root", "12345");
		} catch (SQLException e) {
		throw new RuntimeException(e);
		}
		}
}
