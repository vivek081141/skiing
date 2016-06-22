package com.metricstream.surefire;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBHandler {
	private final String URL = "jdbc:oracle:thin:@172.27.140.5:32786:orcl11g";
	private final String USER = "METRICSTREAM";
	private final String PASS = "password";
	
	public Connection createConnection() throws SQLException{
		 Connection con=null;
		try{
			 Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			 con = DriverManager.getConnection(URL, USER, PASS);
		}  catch (Exception e) {
			e.printStackTrace();
			throw new SQLException("Problem in Making Oracle Connection",e);
		} 
		return con;
		
	}
	
	public void persistTestResult(Bean bean) throws SQLException {
		PreparedStatement stmt=null;
		Connection con=null;
		try{
			con=createConnection();
			con.setAutoCommit(false);
			String sql="INSERT INTO TEST_JAVA_TEST_CASES(MODULE_CODE,TOTAL_TEST_CASES,PASSED_TEST_CASES,RUN_DATE) values (?,?,?,?)";
			stmt =con.prepareStatement(sql);
			stmt.setString(1, bean.getModuleName());
			stmt.setString(2, bean.getTotalTests()+"");
			stmt.setString(3, bean.getTotalPassedTests()+"");
			stmt.setDate(4, new Date(bean.getRunDate().getTime()));
			stmt.executeUpdate();
			con.commit();
		}catch(SQLException ex){
			throw new SQLException("Error occured in db");
		}finally{
			closeConnection(con);
			closeStatememt(stmt);
		}
	}
	
	
	public void closeConnection(Connection con) throws SQLException{
		if(con!=null && !con.isClosed()){
			con.close();
		}
	}
	
	public void closeStatememt(PreparedStatement ps) throws SQLException{
		if(ps!=null && !ps.isClosed()){
			ps.close();
		}
	}
	

}
