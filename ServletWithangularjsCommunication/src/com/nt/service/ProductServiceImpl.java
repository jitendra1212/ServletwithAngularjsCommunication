package com.nt.service;

import java.util.List;

import com.nt.bo.Product;
import com.nt.dao.ProductDAO;
import com.nt.dao.ProductDAOImpl;
import com.nt.util.JsonUtil;

public class ProductServiceImpl implements ProductService {

	@Override
	public String getProductDetails(double minPrice, double maxPrice) {
		// TODO Auto-generated method stub
		
		//call DAO
		ProductDAO productDAO = new ProductDAOImpl();
		List<Product>list= productDAO.getProductDetails(minPrice, maxPrice);
		String jsonProductlist= JsonUtil.convertJavaToJson(list);
		return jsonProductlist;
	}

}
