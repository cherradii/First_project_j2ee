package com.cherradi.ensah.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cherradi.ensah.entities.User;
import com.cherradi.ensah.utils.JDBCUtils;
import com.mysql.jdbc.PreparedStatement;


/**
 * 
 * The jdbc version implementation of the specification or the contract defined in dao interface.
 * we can use other implementation such as hibernate, jpa, ejb, spring data, etc.
 * 
 * @author = CHERRADI Mohamed
 * 
 */

public class ImpUserDAO implements IUserDAO{

	public List<User> getAllUsers() {
		Connection conn = JDBCUtils.getConnection();
		List<User> users = new ArrayList<User>();
		try {
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("select * from users");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Long idUser = rs.getLong(1);
				String login = rs.getString("login");
				String password = rs.getString("password");
				String role = rs.getString("role");
				String enabled = rs.getString("enabled");
				User user = new User(login, password, role, enabled);
				user.setIdUser(idUser);
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

	public List<User> getUsersByRoleName(String roleName) {
		Connection conn = JDBCUtils.getConnection();
		List<User> users = new ArrayList<User>();
		try {
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("select * from users where role=?");
			stmt.setString(1, roleName);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setIdUser(rs.getLong("idUser"));
				user.setLogin(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setRole(rs.getString(4));
				user.setEnabled(rs.getString(5));
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

	public void addUser(User user) {
		Connection conn = JDBCUtils.getConnection();
		try {
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("insert into users (login, password, role, enabled) values (?, ?, ?, ?)");
			stmt.setString(1, user.getLogin());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getRole());
			stmt.setString(4, user.getEnabled());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void updateUser(User user) {
		Connection conn = JDBCUtils.getConnection();
		boolean rowUpdated;
		try {
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("update users set login=?, password=?, role=?, enabled=? where idUser=?");
			stmt.setString(1, user.getLogin());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getRole());
			stmt.setString(4, user.getEnabled());
			stmt.setInt(5, (int) user.getIdUser().intValue());
			stmt.executeUpdate();
//			rowUpdated = stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		return rowUpdated;
	}

	public void deleteUser(Long idUser) {
		Connection conn = JDBCUtils.getConnection();
//		boolean rowDeleted;
		try {
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("delete from users where idUser = ?");
			stmt.setLong(1, idUser);
			stmt.executeUpdate();
//			rowDeleted = stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		return rowDeleted;
	}

	@Override
	public User getUserById(Long id) {
		Connection conn = JDBCUtils.getConnection();
		User user = new User();
		try {
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("select * from users where idUser = ?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				user.setIdUser(rs.getLong(1));
				user.setLogin(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setRole(rs.getString(4));
				user.setEnabled(rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}
