package com.ray.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ray.dao.UserDAO;
import com.ray.entity.User;
import com.ray.service.UserService;

/// http://localhost:8080/ebook/admin/manage_user
@WebServlet("/admin/manage_user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	private UserService userService;
	
    public UserController() {
        super();
        this.userDAO = new UserDAO();
        this.userService = new UserService();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String theCommand = request.getParameter("command");
		
		if (theCommand == null) {
			theCommand = "LIST";
		}
		
		switch (theCommand) {
			case "LIST":
				getUserList(request, response);
				break;
			case "NEW":
				showNewForm(request, response);
				break;
			case "LOAD":
				showEditForm(request, response);
				break;
			case "DELETE":
				deleteUser(request, response);
				break;
			default:
				getUserList(request, response);
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String theCommand = request.getParameter("command");
		
		if (theCommand == null) {
			theCommand = "LIST";
		}
		
		switch (theCommand) {
			case "INSERT":
				insertUser(request, response);
				break;
			case "UPDATE":
				updateUser(request, response);
				break;
			default:
				getUserList(request, response);
		}
		
	}
	
	
	private void getUserList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get data
		List<User> userList = this.userDAO.getListAll();
		
		/// pass data to JSP
		request.setAttribute("userList", userList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("user_list.jsp");
		dispatcher.forward(request, response);
	}

	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.setAttribute("theUser", null);
		
		response.sendRedirect("user_form.jsp");
	}
	
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Integer theUserId  = Integer.valueOf(request.getParameter("userId"));
		
		User userToUpdate = this.userService.getUserById(theUserId);
		session.setAttribute("theUser", userToUpdate);
		
		response.sendRedirect("user_form.jsp");
	}
	
	
	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setAttribute("message", null);
		
		String email = request.getParameter("email");
		String fullName = request.getParameter("fullName");
		String password = request.getParameter("password");
		
		User newUser = new User(email, fullName, password);
//		this.userDAO.create(newUser);
		String errorMessage = userService.createUser(newUser);
		
		if (errorMessage != null) {
			request.setAttribute("message", errorMessage);
			request.setAttribute("theUser", newUser);
			RequestDispatcher rd = request.getRequestDispatcher("user_form.jsp");
			rd.forward(request, response);
			return;
		}
		
		response.sendRedirect("manage_user?command=LIST");
	}
	
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Integer userId = Integer.valueOf(request.getParameter("userId"));
		String email = request.getParameter("email");
		String fullName = request.getParameter("fullName");
		String password = request.getParameter("password");
		
		User userToUpdate = new User(userId, email, fullName, password);
		String errorMessage = this.userService.update(userToUpdate);
		
		if (errorMessage != null) {
			request.setAttribute("message", errorMessage);
			RequestDispatcher rd = request.getRequestDispatcher("user_form.jsp");
			rd.forward(request, response);
			return;
		}
		
		response.sendRedirect("manage_user?command=LIST");
	}
	
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Integer userId = Integer.valueOf(request.getParameter("userId"));
		userService.deleteUser(userId);
		
		response.sendRedirect("manage_user?command=LIST");
	}
}
