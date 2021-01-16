package dao;

import java.util.List;

import model.Bill;

public interface BillDao {
	List<Bill> getAll();

	List<Bill> search(int userId);

	Bill get(int id);

	void delete(int id);

	void update(Bill bills);

	void create(Bill bills);

	List<Bill> search(String buyer);

}
