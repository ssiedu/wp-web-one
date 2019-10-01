package com.ssi;

public interface ProductDAO {
	public void saveProduct(Product product);
	public void updateProduct(Product product);
	public Product searchProductById(int code);
}
