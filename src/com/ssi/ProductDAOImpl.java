package com.ssi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductDAOImpl implements ProductDAO {

	private Connection con;
		
	public ProductDAOImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void saveProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product searchProductById(int code) {
		
		Product product=new Product();
		
		try {
		String sql="select * from prodinfo where code=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, code);
		ResultSet rs=ps.executeQuery();
		rs.next();
		product.setCode(rs.getInt(1));
		product.setName(rs.getString(2));
		product.setDesc(rs.getString(3));
		product.setCategory(rs.getString(4));
		product.setPrice(rs.getInt(5));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return product;
	}

	
	
}
