package com.ray.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ray.service.UserService;


@WebServlet("/admin/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService userService;

    public LoginServlet() {
        super();
        userService = new UserService();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		String errorMessage = userService.checkLogin(email, password);
		
		if (errorMessage != null) {
			request.setAttribute("message", errorMessage);
			
			/// http://localhost:8080/ebook/admin/login.jsp
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(request, response);
			return;
		}
		
		request.getSession().setAttribute("userEmail", email);
		
		/// http://localhost:8080/ebook/admin/
		response.sendRedirect(request.getContextPath() + "/admin/");
	}

}
