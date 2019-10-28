package com.javers.history.tryer.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.javers.repository.sql.ConnectionProvider;
import org.javers.repository.sql.DialectName;
import org.javers.repository.sql.JaversSqlRepository;
import org.javers.repository.sql.SqlRepositoryBuilder;

import com.mysql.cj.jdbc.MysqlDataSource;

public class JaversConnection {

	private Connection dbConnection;

	private ConnectionProvider connectionProvider;

	public JaversConnection() {
		this.init();
	}

	public void init() {
		try {
			try {
				Class.forName("com.mysql.jdbc.Connection");
			} catch (Exception ex) {
			}

			/// my_database?user=root&password=Pass

			MysqlDataSource dataSource = new MysqlDataSource();
			dataSource.setUser("root");
			dataSource.setPassword("rootPassword");
			// dataSource.setServerName("127.0.0.1");
			dataSource.setURL(
					"jdbc:mysql://127.0.0.1:3356/tryer_schema?useUnicode=true&characterEncoding=UTF8&autoReconnect=true");
//			dataSource.setServerName(
//					"jdbc:mysql://127.0.0.1:3356/MSSP_MAIN?useUnicode=true&characterEncoding=UTF8&autoReconnect=true");
			dataSource.setPort(3356);
			this.dbConnection = dataSource.getConnection();
			// DriverManager.getConnection("mysql:mysql-connector-java:8.0.15");

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	public ConnectionProvider connectionProvider() {

		try {
			if (this.dbConnection.isClosed()) {
				this.init();
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

		return new ConnectionProvider() {

			public Connection getConnection() {
				// suitable only for testing!
				return dbConnection;
			}
		};
	}

	public JaversSqlRepository createJaversSqlRepository() {
		JaversSqlRepository sqlRepository = SqlRepositoryBuilder.sqlRepository().withSchema("tryer_schema")
				.withConnectionProvider(this.connectionProvider()).withDialect(DialectName.MYSQL).build();

		return sqlRepository;
	}

}
