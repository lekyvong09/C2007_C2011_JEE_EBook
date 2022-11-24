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

import com.ray.entity.Product;
import com.ray.service.ProductService;


@WebServlet("/admin/manage_product")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductService productService;

    public ProductController() {
        super();
        productService = new ProductService();
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
		List<Product> productList = productService.listProduct();
		
		/// pass data to JSP
		request.setAttribute("productList", productList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("product_list.jsp");
		dispatcher.forward(request, response);
	}

	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.setAttribute("theProduct", null);
		
		response.sendRedirect("product_form.jsp");
	}
	
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Integer theProductId  = Integer.valueOf(request.getParameter("productId"));
		
		Product productToUpdate = productService.getById(theProductId);
		session.setAttribute("theProduct", productToUpdate);
		
		response.sendRedirect("product_form.jsp");
	}
	
	
	private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//		request.setAttribute("message", null);
//		
//		String name = request.getParameter("name");
//		
//		Product newProduct = new Product(name);
//		String errorMessage = productService.create(newProduct);
//		
//		if (errorMessage != null) {
//			request.setAttribute("message", errorMessage);
//			request.setAttribute("theProduct", newProduct);
//			RequestDispatcher rd = request.getRequestDispatcher("product_form.jsp");
//			rd.forward(request, response);
//			return;
//		}
//		
//		response.sendRedirect("manage_product?command=LIST");
	}
	
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//		Integer productId = Integer.valueOf(request.getParameter("productId"));
//		String name = request.getParameter("name");
//		
//		Product productToUpdate = new Product(productId, name);
//		String errorMessage = productService.update(productToUpdate);
//		
//		if (errorMessage != null) {
//			request.setAttribute("message", errorMessage);
//			RequestDispatcher rd = request.getRequestDispatcher("product_form.jsp");
//			rd.forward(request, response);
//			return;
//		}
//		
//		response.sendRedirect("manage_product?command=LIST");
	}
	
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Integer productId = Integer.valueOf(request.getParameter("productId"));
		productService.delete(productId);
		
		response.sendRedirect("manage_product?command=LIST");
	}
}
