package dao;

import java.util.List;

import model.Category;

public interface CategoryDao {
	List<Category> search(String name);

	Category get(int id);

	void delete(int id);

	void update(Category category);

	void creat(Category category);
}
