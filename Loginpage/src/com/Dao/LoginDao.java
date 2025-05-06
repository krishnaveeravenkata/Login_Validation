package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {

	public String checkLogin(String username, String password) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String usr = "system";
		String pwd = "1234";
		String sql = "select USERNAME,PASSWORD from loginpage where USERNAME =? AND PASSWORD=?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, usr, pwd);
			ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		if (rs.next()) {
			return "login Succesfully";
		} else {
			return "login Failed ";
		}
	}
}