package com.cherradi.ensah.dao;

import java.util.List;

import com.cherradi.ensah.entities.User;


/*
 * 
 * This interface describe contract between client and developer, often contains crud operation
 * business functionalities defined in service layer.
 * 
 * @author = CHERRADI Mohamed
 * 
 * @email = med1995cherradi@gmail.com
 * 
 * 
 */

public interface IUserDAO {
	
	public List<User> getAllUsers();
	public List<User> getUsersByRoleName(String roleName);
	public User getUserById(Long id);
	public void addUser(User user);
	public void updateUser(User user);
	public void deleteUser(Long idUser);

}
