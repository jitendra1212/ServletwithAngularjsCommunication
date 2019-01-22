package com.nt.dao;

import java.util.List;

import com.nt.bo.Product;

public interface ProductDAO {
	public List<Product> getProductDetails(double minPrice,double maxPrice);

}
