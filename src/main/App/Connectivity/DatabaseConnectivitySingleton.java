package main.App.Connectivity;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectivitySingleton {
	
	private static DatabaseConnectivitySingleton instance;
	private Connection connection;
	private final String URL = "jdbc:postgresql://localhost:5432/";
	private String username = "postgres";
	private String password = "admin";
	
	private DatabaseConnectivitySingleton() throws SQLException{
		try {
			Class.forName("org.postgresql.Driver");
			this.connection = DriverManager.getConnection(URL, username, password);
			 Statement stmt = connection.createStatement();
			 String sql = "DROP DATABASE IF EXISTS surveydb;CREATE DATABASE surveydb;";
			 
			 stmt.executeUpdate(sql);
			  sql =
	                    "CREATE TABLE IF NOT EXISTS public.user_info("
	                    + "    id SERIAL PRIMARY KEY,"
	                    + "    surname character varying(255) COLLATE pg_catalog.\"default\","
	                    + "    first_name character varying(255) COLLATE pg_catalog.\"default\","
	                    + "    date date,"
	                    + "    age integer,"
	                    + "    favourite_food character varying(255) COLLATE pg_catalog.\"default\","
	                    + "    contact_number character varying(255) COLLATE pg_catalog.\"default\","
	                    + "    eat_out integer,"
	                    + "    watch_movies integer,"
	                    + "    watch_tv integer,"
	                    + "    listen_to_radio integer"
	                    + "    )"
	                    + "TABLESPACE pg_default;"
	                    + "ALTER TABLE IF EXISTS public.user_info"
	                    + "    OWNER to postgres;";
	         stmt.executeUpdate(sql);
		}catch(ClassNotFoundException ex) {
			System.out.print("Database Connection Creation Failed: "+ex.getMessage());
		}
	}
	
	public Connection getConnection() { return this.connection; }
	
	public static DatabaseConnectivitySingleton getInstance() throws SQLException {
		if (instance == null || instance.getConnection().isClosed())
			instance = new DatabaseConnectivitySingleton();
		return instance;
	}
}
