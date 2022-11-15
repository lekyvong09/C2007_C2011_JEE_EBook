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

import com.ray.entity.Category;
import com.ray.service.CategoryService;


@WebServlet("/admin/manage_category")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CategoryService categoryService;

    public CategoryController() {
        super();
        categoryService = new CategoryService();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String theCommand = request.getParameter("command");
		
		if (theCommand == null) {
			theCommand = "LIST";
		}
		
		switch (theCommand) {
			case "LIST":
				getList(request, response);
				break;
			case "NEW":
				showNewForm(request, response);
				break;
			case "LOAD":
				showEditForm(request, response);
				break;
			case "DELETE":
				delete(request, response);
				break;
			default:
				getList(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String theCommand = request.getParameter("command");
		
		if (theCommand == null) {
			theCommand = "LIST";
		}
		
		switch (theCommand) {
			case "INSERT":
				insert(request, response);
				break;
			case "UPDATE":
				update(request, response);
				break;
			default:
				getList(request, response);
		}
	}

	
	private void getList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get data
		List<Category> categoryList = categoryService.listCategory();
		
		/// pass data to JSP
		request.setAttribute("categoryList", categoryList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("category_list.jsp");
		dispatcher.forward(request, response);
	}

	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.setAttribute("theCategory", null);
		
		response.sendRedirect("category_form.jsp");
	}
	
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Integer theCategoryId  = Integer.valueOf(request.getParameter("categoryId"));
		
		Category categoryToUpdate = categoryService.getById(theCategoryId);
		session.setAttribute("theCategory", categoryToUpdate);
		
		response.sendRedirect("category_form.jsp");
	}
	
	
	private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setAttribute("message", null);
		
		String name = request.getParameter("name");
		
		Category newCategory = new Category(name);
		String errorMessage = categoryService.create(newCategory);
		
		if (errorMessage != null) {
			request.setAttribute("message", errorMessage);
			request.setAttribute("theCategory", newCategory);
			RequestDispatcher rd = request.getRequestDispatcher("category_form.jsp");
			rd.forward(request, response);
			return;
		}
		
		response.sendRedirect("manage_category?command=LIST");
	}
	
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Integer categoryId = Integer.valueOf(request.getParameter("categoryId"));
		String name = request.getParameter("name");
		
		Category categoryToUpdate = new Category(categoryId, name);
		String errorMessage = categoryService.update(categoryToUpdate);
		
		if (errorMessage != null) {
			request.setAttribute("message", errorMessage);
			RequestDispatcher rd = request.getRequestDispatcher("category_form.jsp");
			rd.forward(request, response);
			return;
		}
		
		response.sendRedirect("manage_category?command=LIST");
	}
	
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Integer categoryId = Integer.valueOf(request.getParameter("categoryId"));
		categoryService.delete(categoryId);
		
		response.sendRedirect("manage_category?command=LIST");
	}
}
