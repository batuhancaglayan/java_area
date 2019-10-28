package com.user.role.tryer.jdbi.connection;

import org.skife.jdbi.v2.DBI;

public class RDSConnection {

	private static final String DB_URL_TEST = "jdbc:mysql://localhost:3356/tryer_schema";
	private static final String DB_USER_TEST = "root";
	private static final String DB_USER_PASSWORD = "rootPassword";

	private static DBI dbi;

	public static DBI getInstance() {
		if (dbi == null) {
			dbi = new DBI(DB_URL_TEST, DB_USER_TEST, DB_USER_PASSWORD);
		}

		return dbi;
	}
}
