package com.bcnx.application.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class DataSource {
	private static final Logger logger = Logger.getLogger(DataSource.class);
	private static Connection connection;
	static{
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:./datasource/configuration.s3db"); 
		} catch (ClassNotFoundException e) {
			logger.debug("Exception occured while try to find database driver", e);
		}
		catch (SQLException e) {
			logger.debug("Exception occured while try to establish database connection", e);
		}
	}
	public static Connection getConnection(){
		return connection;
	}
}
