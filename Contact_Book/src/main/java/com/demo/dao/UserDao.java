package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.demo.entity.User;

public class UserDao {

	private Connection con;

	public UserDao(Connection con) {
		super();
		this.con = con;
	}

	public boolean userRegister(User u) {

		boolean f = false;

		try {

			String query = "insert into user (first_name,last_name,email,password,mobile_number,address,gender) values(?,?,?,?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, u.getFirst_name());
			ps.setString(2, u.getLast_name());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPassword());
			ps.setString(5, u.getMobile_number());
			ps.setString(6, u.getAddress());
			ps.setString(7, u.getGender());

			int i = ps.executeUpdate();
			if (i == 1) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public User loginUser(String email, String pass) {

		User u=null;
		try {
			
			String query = "select * from  user where email=? and password=?";
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1,email);
			ps.setString(2, pass);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				
				u=new User();
				
				u.setId(rs.getInt(1));
            	u.setFirst_name(rs.getString(2));
            	u.setLast_name(rs.getString(3));
            	u.setEmail(rs.getString(4));
            	u.setPassword(rs.getString(5));
            	u.setMobile_number(rs.getString(6));
            	u.setAddress(rs.getString(7));
            	u.setGender(rs.getString(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}
}
