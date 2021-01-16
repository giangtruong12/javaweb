package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CategoryDao;
import model.Category;

public class CategoryDaoImpl extends JDBCConnection implements CategoryDao {
 @Override
public void creat(Category category) {
	 String sql ="INSERT INTO category(name)"+"VALUES(?)";
	 try {
Connection connection =super.getConnection();
PreparedStatement statement=connection.prepareStatement(sql);
		statement.setString(1, category.getName());
		statement.executeUpdate();
	} catch (Exception e) {
		System.out.println("LOI INSERT :"+e);
	}
 }
 @Override
public void update(Category category) {
	 String sql ="UPDATE category SET name = ? WHERE id = ?";
	 try {
		Connection conn=super.getConnection();
		PreparedStatement statement=conn.prepareStatement(sql);
		statement.setString(1, category.getName());
		statement.setInt(2, category.getId());
		statement.executeUpdate();
	} catch (Exception e) {
		System.out.println("LOI UPDATE :"+e);
	}
 }
 @Override
public void delete(int id) {
	 String sql ="DELETE  FROM category WHERE id = ?";
	 try {
		Connection conn=super.getConnection();
		PreparedStatement statement=conn.prepareStatement(sql);
		statement.setInt(1, id);
		statement.executeUpdate();
	} catch (Exception e) {
		System.out.println("LOI DELETE :"+e);
	}
 }
 @Override
public Category get(int id) {
	 String sql ="SELECT * FROM category WHERE id = ?";
	 try {
		Connection conn=super.getConnection();
		PreparedStatement statement=conn.prepareStatement(sql);
		statement.setInt(1, id);
		ResultSet resultSet =statement.executeQuery();
		while (resultSet.next()) {
			return rowMapper(resultSet);
			
		}
	} catch (Exception e) {
		System.out.println("LOI GET CATEGORY BY ID :"+e);
	}
	 return null;
 }
 @Override
public List<Category> search(String name) {
	 List<Category> list=new ArrayList();
	 String sql ="SELECT * FROM category WHERE name LIKE ?";
	 try {
		Connection conn=super.getConnection();
		PreparedStatement statement=conn.prepareStatement(sql);
		statement.setString(1,"%"+ name+"%");
		ResultSet resultSet =statement.executeQuery();
		while (resultSet.next()) {
			 list.add(rowMapper(resultSet));
			
		}
	} catch (Exception e) {
		System.out.println("LOI SEARCH NAME :"+e);
	}
	 return list;
 }
// @Override
//public List<Category> getall() {
//	 List<Category> list=new ArrayList();
//	 String sql ="SELECT * FROM category";
//	 try {
//		Connection conn=super.getConnection();
//		PreparedStatement statement=conn.prepareStatement(sql);
//		ResultSet resultSet =statement.executeQuery();
//		while (resultSet.next()) {
//			 list.add(rowMapper(resultSet));
//			
//		}
//	} catch (Exception e) {
//		System.out.println("LOI LIST ALL :"+e);
//	}
//	 return list;
// }
 
 private Category rowMapper(ResultSet resultSet) throws Exception {
	 Category category =new Category();	 
	 category.setId(resultSet.getInt("id"));
	 category.setName(resultSet.getString("name"));
	 return category;

	}
 }

