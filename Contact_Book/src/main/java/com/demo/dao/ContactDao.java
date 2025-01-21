package com.demo.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.demo.entity.Contact;

public class ContactDao {

	private Connection con;

	public ContactDao(Connection con) {
		super();
		this.con = con;
	}

	public boolean saveContact(Contact c) {

		boolean f = false;

		try {
			PreparedStatement ps = con.prepareStatement(
					"insert into contact (first_name,last_name,email,phone_number,about,userId) values(?,?,?,?,?,?)");

			ps.setString(1, c.getFirst_name());
			ps.setString(2, c.getLast_name());
			ps.setString(3, c.getEmail());
			ps.setString(4, c.getPhone_number());
			ps.setString(5, c.getAbout());
			ps.setInt(6, c.getUserId());
			if (ps.executeUpdate() > 0) {
				f = true;
			}
		} catch (Exception e) {

		}

		return f;
	}
	
	public List<Contact> getAllContact(int uid){
		
		List<Contact>lst=new ArrayList<>();
		
		Contact c=null;
		try {
			
			PreparedStatement ps=con.prepareStatement("Select * from contact where userId=?");
			
			ps.setInt(1, uid);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				
				c=new Contact();
				c.setContact_id(rs.getInt("contact_id"));
				c.setFirst_name(rs.getString("first_name"));
				c.setLast_name(rs.getString("last_name"));
				c.setEmail(rs.getString("email"));
				c.setPhone_number(rs.getString("phone_number"));
				c.setAbout(rs.getString("about"));
				c.setUserId(rs.getInt("userId"));;
				lst.add(c);
			}
			System.out.println(lst);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return lst;
	}
	
	
	public Contact getContactById(int cid) {
		
		Contact c=new Contact();
		
		try {
			PreparedStatement ps=con.prepareStatement("Select * from contact where contact_id=?");
			
			ps.setInt(1, cid);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				
				c.setContact_id(rs.getInt("contact_id"));
				c.setFirst_name(rs.getString("first_name"));
				c.setLast_name(rs.getString("last_name"));
				c.setEmail(rs.getString("email"));
				c.setPhone_number(rs.getString("phone_number"));
				c.setAbout(rs.getString("about"));
				c.setUserId(rs.getInt(rs.getInt("userId")));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	
	public  boolean updateContact(Contact c) {
		boolean f = false;

		try {
			PreparedStatement ps = con.prepareStatement(
					"update contact set first_name=?,last_name=?,email=?,phone_number=?,about=? where contact_id=?");

			ps.setString(1, c.getFirst_name());
			ps.setString(2, c.getLast_name());
			ps.setString(3, c.getEmail());
			ps.setString(4, c.getPhone_number());
			ps.setString(5, c.getAbout());
			ps.setInt(6, c.getContact_id());
			System.out.println(c.getContact_id());
			if (ps.executeUpdate() > 0) {
				f = true;
			}
		} catch (Exception e) {

		}

		return f;
	}
	
	public boolean deleteContactById(int id) {
		
		boolean f=false;
		
		try {
			PreparedStatement ps=con.prepareStatement("delete from contact where contact_id=?");
			
			ps.setInt(1, id);
			
			if(ps.executeUpdate()>0) {
				f=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}
