package dao;

import java.util.List;

import model.Product;

public interface ProductDao {
	Product get(int id);

	List<Product> getall();

	List<Product> search(String findName);

	void delete(int id);

	void update(Product product);

	void add(Product product);

	List<Product> searchByCateId(int cateId);
}
