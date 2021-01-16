package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.UserDao;
import model.User;

public class UserDaoImpl extends JDBCConnection implements UserDao {

	@Override
	public void create(User user) {
		String sql = "INSERT INTO USER(age, name, username, password, role) VALUES(?,?,?,?,?)";
		try {

			Connection conn = super.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, user.getAge());
			statement.setString(2, user.getName());
			statement.setString(3, user.getUsername());
			statement.setString(4, user.getPassword());
			statement.setString(5, user.getRole());
			statement.executeUpdate();

		} catch (Exception e) {
			System.out.println("Loi Tao User :" + e);
		}

	}

	@Override
	public void update(User user) {
		String sql = "UPDATE USER SET age = ?, name = ?, username = ?, password = ?, role=? WHERE id = ? ";
		try {

			Connection conn = super.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, user.getAge());
			statement.setString(2, user.getName());
			statement.setString(3, user.getUsername());
			statement.setString(4, user.getPassword());
			statement.setString(5, user.getRole());
			statement.setInt(6, user.getId());
			statement.executeUpdate();

		} catch (Exception e) {
			System.out.println("Loi Update User :" + e);
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM USER WHERE id = ?";
		try {

			Connection conn = super.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			statement.executeUpdate();

		} catch (Exception e) {
			System.out.println("Loi Xoa User :" + e);
		}
	}

	@Override
	public User get(int id) {
		List<User> list = new ArrayList<User>();
		String sql = "SELECT * FROM USER WHERE id = ?";
		try {

			Connection conn = super.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				return rowMapper(resultSet);
			}
		} catch (Exception e) {
			System.out.println("Loi get List<User>:" + e);
		}
		return null;
	}

	@Override
	public List<User> search(String name) {
		List<User> users = new ArrayList<>();
		String sql = "SELECT * FROM USER WHERE name LIKE ?";
		try {

			Connection conn = super.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1,"%"+ name+"%");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				users.add(rowMapper(resultSet));

			}
		} catch (Exception e) {
			System.out.println("Loi Tim Kiem User theo name:" + e);
		}
		return users;
	}
	@Override
	public User getByUsername(String username) {
		String sql = "SELECT * FROM user WHERE username = ?";

		try {
			Connection conn = super.getConnection();

			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setString(1, username);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				return rowMapper(resultSet);
			}

		} catch (Exception e) {
			System.out.println("Loi: " + e);
		}

		return null;
	}
	@Override
	public List<User> getAll() {
		List<User> list = new ArrayList<>();
		String sql = "SELECT * FROM USER";
		try {

			Connection conn = super.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				list.add(rowMapper(resultSet));
			}
		} catch (Exception e) {
			System.out.println("Loi Tim Kiem Tat Ca User:" + e);
		}
		return list;
	}

	private User rowMapper(ResultSet resultSet) throws Exception {
		User user = new User();
		user.setId(resultSet.getInt("id"));
		user.setAge(resultSet.getInt("age"));
		user.setName(resultSet.getString("name"));
		user.setUsername(resultSet.getString("username"));
		user.setPassword(resultSet.getString("password"));
		user.setRole(resultSet.getString("role"));
		return user;
	}
}
