package com.nt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nt.bo.Product;

public class ProductDAOImpl implements ProductDAO {

	@Override
	public List<Product> getProductDetails(double minPrice, double maxPrice) {
		// TODO Auto-generated method stub
		List<Product> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			String sql="select pid,pname,price,qty from product where price>=? and price<=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1,minPrice);
			ps.setDouble(2,maxPrice);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Product product = new Product();
				product.setProductId(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setPrice(rs.getDouble(3));
				product.setQty(rs.getInt(4));
				list.add(product);
			}
		}
			catch(ClassNotFoundException cnf) {
				cnf.printStackTrace();
			}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	

}
