package com.ray.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/// http://localhost:8080/ebook/admin/...
@WebFilter("/admin/*")
public class AdminLoginFilter implements Filter {

    public AdminLoginFilter() {
    }


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
		/**
		 * getSession(parameter)
		 * parameter = true: if not exist then create session
		 * parameter = false: if not exist return null, else get session 
		 */
		HttpSession session = httpRequest.getSession(false);
		
		boolean isLoggedIn = session != null && session.getAttribute("userEmail") != null;
		
		/**
		 * Exception cases
		 */
		String loginURI = httpRequest.getContextPath() + "/admin/login";
		boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURI);
		boolean isLoginPage = httpRequest.getRequestURI().endsWith("login.jsp");
		
		if (isLoggedIn || isLoginRequest || isLoginPage) {
			chain.doFilter(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(httpRequest, response);
		}
	}


	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void destroy() {
	}
}
