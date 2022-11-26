package com.ray.controller.admin;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.ray.entity.Category;
import com.ray.entity.Product;
import com.ray.service.CategoryService;
import com.ray.service.ProductService;


@WebServlet("/admin/manage_product")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 1,	// if file > 1MB, store disk instead RAM
		maxFileSize = 1024 * 1024 * 10,			// maximum file size = 10MB
		maxRequestSize = 1024 * 1024 * 100		//maximum request size = 100MB
		)
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductService productService;
    private CategoryService categoryService;

    public ProductController() {
        super();
        productService = new ProductService();
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
		List<Product> productList = productService.listProduct();
		
		/// pass data to JSP
		request.setAttribute("productList", productList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("product_list.jsp");
		dispatcher.forward(request, response);
	}

	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Category> categoryList = categoryService.listCategory();
		System.out.println(categoryList);
		HttpSession session = request.getSession();
		session.setAttribute("theProduct", null);
		session.setAttribute("categoryList", categoryList);
		
		response.sendRedirect("product_form.jsp");
	}
	
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Integer theProductId  = Integer.valueOf(request.getParameter("productId"));
		
		Product productToUpdate = productService.getById(theProductId);
		session.setAttribute("theProduct", productToUpdate);
		
		List<Category> categoryList = categoryService.listCategory();
		request.getSession().setAttribute("categoryList", categoryList);
		
		response.sendRedirect("product_form.jsp");
	}
	
	
	private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Product newProduct = new Product();
		
		Integer categoryId = Integer.parseInt(request.getParameter("category"));
		Category category = categoryService.getById(categoryId);
		
		newProduct.setName(request.getParameter("name"));
		newProduct.setAuthor(request.getParameter("author"));
		newProduct.setIsbn(request.getParameter("isbn"));
		newProduct.setPrice(new BigDecimal(request.getParameter("price")));
		newProduct.setDescription(request.getParameter("description"));
		newProduct.setCategory(category);
		
//		newProduct.setPublishDate(new Date());
		System.out.println(request.getParameter("publishDate"));
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date publishDate = dateFormat.parse(request.getParameter("publishDate"));
			newProduct.setPublishDate(publishDate);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new ServletException("The format date is yyyy-MM-dd");
		}
		
		Part filePart = request.getPart("image");
		
		if (filePart != null & filePart.getSize() > 0) {
			long size = filePart.getSize();
			byte[] imageBytes = new byte[(int) size];
			
			InputStream inputStream = filePart.getInputStream();
			inputStream.read(imageBytes);
			inputStream.close();
			
			newProduct.setImage(imageBytes);
		}
		
		String errorMessage = this.productService.create(newProduct);
		if (errorMessage != null) {
			request.setAttribute("message", errorMessage);
			request.setAttribute("theProduct", newProduct);
			RequestDispatcher rd = request.getRequestDispatcher("product_form.jsp");
			rd.forward(request, response);
			return;
		}
		
		response.sendRedirect(request.getContextPath() + "/admin/");
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
