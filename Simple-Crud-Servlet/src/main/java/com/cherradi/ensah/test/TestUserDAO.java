package com.cherradi.ensah.test;

import java.util.ArrayList;
import java.util.List;

import com.cherradi.ensah.dao.IUserDAO;
import com.cherradi.ensah.dao.ImpUserDAO;
import com.cherradi.ensah.entities.User;

/**
 * The second thing we want to verify after connection with database is the dao layer
 * because when we move to the web layer you are sure all business operation work fine.
 * 
 * @author = CHERRADI Mohamed
 * 
 * @email = med1995cherradi@gmail.com
 * 
 */

public class TestUserDAO {
	
	
	public static void main(String[] args) {
		
		IUserDAO userDAO = new ImpUserDAO();

		User user1 = new User("med1995cherradi@gmail.com", "123456", "admin", "true");
		User user2 = new User("mohamed.amine@gmail.com", "456789", "user", "true");
		
		User user3 = new User("saadiaakant@gmail.com", "8542", "admin", "true");
		
//		userDAO.addUser(user1);
//		userDAO.addUser(user2);
//		userDAO.addUser(user3);
		
//		List<User> users = userDAO.getUsersByRoleName("admin");
//		for (User user : users) {
//			System.out.println(user.getIdUser()+"---"+user.getLogin()+"---"+user.getPassword()+"---"+user.getRole()+"---"+user.getEnabled());
//		}
		
		
//		List<User> users = userDAO.getAllUsers();
//		for (User user : users) {
//			System.out.println(user.getIdUser()+"---"+user.getLogin()+"---"+user.getPassword()+"---"+user.getRole()+"---"+user.getEnabled());
//		}
//		
		
//		userDAO.addUser(new User("aa", "bb", "cc", "dd"));
//		userDAO.deleteUser((long) 3);
		
		
		User u7 = userDAO.getUserById((long) 7);
//		System.out.println(u7.getLogin());
		u7.setLogin("elallaoui");
		userDAO.updateUser(u7);
		System.out.println(u7.getLogin());

		
		
	}

}
