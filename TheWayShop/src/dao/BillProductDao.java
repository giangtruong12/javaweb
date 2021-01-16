package dao;

import java.util.List;

import model.BillProduct;

public interface BillProductDao {
	List<BillProduct> search(int billId);

	BillProduct get(int id);

	void delete(int id);

	void update(BillProduct billProduct);

	void create(BillProduct billProduct);

	List<BillProduct> getAll();

}
