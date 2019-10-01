package com.ssi;

public class ProductService {

	private ProductDAOImpl dao;
	
	public ProductService() {
		dao=new ProductDAOImpl();
	}
	
	public Product getProductDetails(int code) {
		return dao.searchProductById(code);
	}
	
	
}
