package cn.yh.shop.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DateBaseConnection {
	private static final String DBDRIVER= "com.mysql.jdbc.Driver";
	private static final String DBURL= "jdbc:mysql://localhost:3306/mshop";
	private static final String USER= "root";
	private static final String PASSWORD= "yh123";
	private Connection conn;
	public DateBaseConnection(){
		try {
			Class.forName(DBDRIVER);
			this.conn = DriverManager.getConnection(DBURL,USER,PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public Connection getConn(){
		return this.conn;
	}
	public void close(){
		try {
			this.conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	

}
