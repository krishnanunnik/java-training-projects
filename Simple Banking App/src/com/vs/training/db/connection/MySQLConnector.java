package com.vs.training.db.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class MySQLConnector {

	private String hostName;
	private String password;
	private String port = "3306";
	private String userName;
	private static MySQLConnector connectorInstance = null;

	public static Connection getConnectionInstance(String dbName) throws Exception {

		if (!(MySQLConnector.connectorInstance instanceof MySQLConnector)) {
			MySQLConnector.connectorInstance = new MySQLConnector("", "", dbName);

		}
		return MySQLConnector.connectorInstance.getConnection(dbName);

	}

	private MySQLConnector(String hostName, String userName, String password) {
		this.hostName = hostName;
		this.userName = userName;
		this.password = password;
	}

	private String createConnectionString(String dbName) {

		// something like 'jdbc:mysql://localhost:3306/sampledb'
		return "jdbc:mysql://" + this.hostName + ":" + this.port + "/" + dbName;

	}

	public Connection getConnection(String dbName) throws Exception {

		try {
			String dbConStr = this.createConnectionString(dbName);

			Connection dbConnection = DriverManager.getConnection(dbConStr, this.userName, password);

			if (dbConnection instanceof Connection) {
				System.out.println("Connected");
				return dbConnection;
			}

		} catch (SQLException ex) {
			throw new Exception("Could not connect!");
		}
		throw new Exception("Could not connect!");

	}

}
