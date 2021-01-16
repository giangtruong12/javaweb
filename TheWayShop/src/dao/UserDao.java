package dao;

import java.util.List;

import model.User;

public interface UserDao {
	List<User> search(String name);

	User get(int id);

	void delete(int id);

	void update(User user);

	void create(User user);

	List<User> getAll();

	User getByUsername(String username);
}
