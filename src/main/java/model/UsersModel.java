package model;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import entity.user;

public class UsersModel {
	public List<user> listUsers(DataSource dataSource) {
		//step1 : Initialize connection objects
				List<user> listUsers=new ArrayList<>();
				Connection connect=null;
				Statement stmt=null;
				ResultSet rs=null;
				try {
					connect=dataSource.getConnection();
					
					//step2: create a sql statements string
					String query="Select * from users";
					stmt=connect.createStatement();
					//step 3: Executes sql query
					rs=stmt.executeQuery(query);
					
					
					//step 4: Process the result set
					while(rs.next()) {
						listUsers.add(new user(rs.getInt("users_id"),rs.getString("user_name"),rs.getString("email")));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return listUsers;
	}

	public void adduser(DataSource dataSource,user newUser) {
		Connection connect=null;
		PreparedStatement statement=null;
		try {
			connect=dataSource.getConnection();
			String username=newUser.getUser_name();
			String email=newUser.getEmail();
			String query="insert into users(user_name,email) values(?,?)";
			statement=connect.prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, email);
			statement.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
	}

	public void updateuser(DataSource dataSource, user updateduser) {
		Connection connect=null;
		PreparedStatement statement=null;
		try {
			connect=dataSource.getConnection();
			int userid=updateduser.getUsers_id();
			String username=updateduser.getUser_name();
			String email=updateduser.getEmail();
			String query="update users set user_name=?,email=? where users_id=?";
			statement=connect.prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, email);
			statement.setInt(3, userid);
			statement.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
	}

	public void deleteuser(DataSource dataSource,int usersID) {
		
		Connection connect=null;
		PreparedStatement statement=null;
		try {
			connect=dataSource.getConnection();
			
			String query="delete from users where users_id=?";
			statement=connect.prepareStatement(query);
			statement.setInt(1,usersID);
			statement.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
	}

}
