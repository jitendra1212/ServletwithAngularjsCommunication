package com.nt.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.service.ProductService;
import com.nt.service.ProductServiceImpl;

public class ProductServlet extends HttpServlet {
	private ProductService productService;
	public void init() {
		productService=(ProductService) new ProductServiceImpl();
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	//gather min and max price from request objec
		double minPrice= Double.parseDouble(req.getParameter("minPrice"));
		double maxPrice = Double.parseDouble(req.getParameter("maxPrice"));
		//call the productService class methods
	String jsonProductList=	productService.getProductDetails(minPrice, maxPrice);
	res.setContentType("application/json");
		//send the json the results back to anguuuar controller
	res.getWriter().write(jsonProductList);
	}
	

}
