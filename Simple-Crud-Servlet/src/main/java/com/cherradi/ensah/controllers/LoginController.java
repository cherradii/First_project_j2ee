package com.cherradi.ensah.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cherradi.ensah.dao.IUserDAO;
import com.cherradi.ensah.dao.ImpUserDAO;
import com.cherradi.ensah.entities.User;

/*
 * This java class acts as a page controller for the application, handling all requests from the user.
 * 
 * @author = CHERRADI Mohamed
 * 
 * @email = med1995cherradi@gmail.com
 * 
 */


@WebServlet(name="LoginController", urlPatterns="/")
public class LoginController  extends HttpServlet{
	
	 IUserDAO dao;
	 
	 @Override
	public void init() throws ServletException {
		dao = new ImpUserDAO();
	}
	 
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actionName = request.getServletPath();
		
		switch (actionName) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			default:
				listUser(request, response);
				break;
		}
			
		

	}

	private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> users = new ArrayList<User>();
		users = dao.getAllUsers();
		request.setAttribute("listUsers", users);
		this.getServletContext().getRequestDispatcher("/views/user-list.jsp").forward(request, response);
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Long idUser = Long.parseLong(request.getParameter("id"));
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		String enabled = request.getParameter("activation");
		User user = new User();
		user.setIdUser(idUser);user.setLogin(login);user.setPassword(password);user.setRole(role);user.setEnabled(enabled);
		dao.updateUser(user);
		response.sendRedirect("list");
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		User user = dao.getUserById(id);
		request.setAttribute("user", user);
		this.getServletContext().getRequestDispatcher("/views/user-form.jsp").forward(request, response);
		
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		dao.deleteUser(id);
		response.sendRedirect("list");
	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		String activation = request.getParameter("activation");
		User user = new User(login, password, role, activation);
		dao.addUser(user);
		response.sendRedirect("list");
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/views/user-form.jsp").forward(request, response);
	}
	
	

}
