package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import dao.ProductDao;
import model.Category;
import model.Product;

public class ProductDaoImpl extends JDBCConnection implements ProductDao {
	
	@Override
	public void add(Product product) {
		String sql = "INSERT INTO product(name, price, image, describe, category_id) "
				+ "VALUES (?, ?, ?, ?, ?);";
		try {
			Connection conn = super.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			
			preparedStatement.setString(1, product.getName());
			preparedStatement.setInt(2, product.getPrice());
			preparedStatement.setString(3, product.getImage());
			preparedStatement.setString(4, product.getDescribe());
			preparedStatement.setInt(5, product.getCategory().getId());

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			System.out.println("Loi Add Product: " + e);
		}
	}

	
	@Override
	public void update(Product product) {
		String sql = "UPDATE product SET name = ?, price = ?, image = ?, describe = ?, category_id = ? WHERE id = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setString(1, product.getName());
			preparedStatement.setInt(2, product.getPrice());
			preparedStatement.setString(3, product.getImage());
			preparedStatement.setString(4, product.getDescribe());
			preparedStatement.setInt(5, product.getCategory().getId());
			preparedStatement.setInt(6, product.getId());

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			System.out.println("Loi Update Product: " + e);
		}
	}


	@Override
	public void delete(int id) {
		String sql = "DELETE FROM product WHERE id = ?";

		try {
			Connection conn = super.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setInt(1, id);

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			System.out.println("Loi Delete Product: " + e);
		}
	}


	@Override
	public List<Product> search(String findName) {
//		String sql = "SELECT * FROM product WHERE name = ?";
		String sql = "SELECT p.*, c.name as 'c_name' FROM product p "
				+ "INNER JOIN category c ON p.category_id = c.id WHERE p.name LIKE ?";
        List<Product> list =new ArrayList<Product>();
		try {
			Connection conn = super.getConnection();

			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setString(1,"%"+findName+"%");

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				list.add(rowMapper(resultSet)) ;
			}

		} catch (Exception e) {
			System.out.println("Loi search Product by name: " + e);
		}
		return list;
	}
	@Override
	public List<Product> searchByCateId(int cateId){
		String sql ="SELECT p.*, c.name as 'c_name' FROM product p INNER JOIN category c ON p.category_id = c.id WHERE c.id = ?";
		List<Product> list =new ArrayList<Product>();
		try {
			Connection conn = super.getConnection();

			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setInt(1, cateId);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				list.add( rowMapper(resultSet));
			}

		} catch (Exception e) {
			System.out.println("Loi lay product bang cateId"+e);
		}
		return list;
	}
	@Override
	public List<Product> getall() {
		String sql = "SELECT * FROM product";
		List<Product> list =new ArrayList<Product>();

		try {
			Connection conn = super.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				list.add(rowMapper(resultSet));
			}

		} catch (Exception e) {
			System.out.println("Loi lay tat ca list product: " + e);
		}

		return list;
	}

	@Override
	public Product get(int id) {
//		String sql = "SELECT * FROM product WHERE id = ?";
		String sql = "SELECT p.*, c.name as 'c_name' FROM product p "
				+ "INNER JOIN category c ON p.category_id = c.id WHERE p.id = ?";

		try {
			Connection conn = super.getConnection();

			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				return rowMapper(resultSet);
			}

		} catch (Exception e) {
			System.out.println("Loi lay product by id: " + e);
		}

		return null;
	}
	  
	  private Product rowMapper(ResultSet resultSet) throws Exception {
	 	 Product product =new Product();	 
	 	 product.setId(resultSet.getInt("id"));
	 	 product.setName(resultSet.getString("name"));
	 	 product.setPrice(resultSet.getInt("price"));
	 	 product.setImage(resultSet.getString("image"));
	 	 product.setDescribe(resultSet.getString("describe"));
	 	 
	 	 Category category =new Category();
	 	 category.setId(resultSet.getInt("category_id"));
	 	 category.setName(resultSet.getString("c_name"));
	 	 
	 	 product.setCategory(category);
	 	 
	 	 return product;

	 	}
}
