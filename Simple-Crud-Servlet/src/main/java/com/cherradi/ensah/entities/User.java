package com.cherradi.ensah.entities;

import java.io.Serializable;

/**
 * 
 * This is a model class represents user entity or java bean
 * 
 * @author = CHERRADI Mohamed
 * 
 * @email = med1995cherradi@gmail.com
 * 
 */


public class User implements Serializable{
	
	private Long idUser;
	private String login;
	private String password;
	private String role;
	private String enabled;
	
	
	public User() {
	}

	public User(String login, String password, String role, String enabled) {
		this.login = login;
		this.password = password;
		this.role = role;
		this.enabled = enabled;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	
	
}
