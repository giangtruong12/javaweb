package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.BillProductDao;
import model.BillProduct;
import model.Product;

public class BillProductDaoImpl extends JDBCConnection implements BillProductDao {

	
	@Override
	public void create(BillProduct billProduct) {
		Connection conn = super.getConnection();

		try {

			String sql = "INSERT INTO bill_product(unitprice, quantity, bill_id, product_id) VALUES(?,?,?,?)";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setLong(1, billProduct.getUnitPrice());
			st.setInt(2, billProduct.getQuantity());
			st.setLong(3, billProduct.getBill().getId());
			st.setLong(4, billProduct.getProduct().getId());

			st.executeUpdate();
		} catch (Exception ex) {
			System.out.println("Loi :" + ex);
		}
	}

	@Override
	public void update(BillProduct billProduct) {
		try {
			String sql = "update bill_product SET unitprice = ?, quantity = ?, bill_id = ?, product_id = ? WHERE id = ?";
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setLong(1, billProduct.getUnitPrice());
			ps.setInt(2, billProduct.getQuantity());
			ps.setInt(3, billProduct.getBill().getId());
			ps.setInt(4, billProduct.getProduct().getId());

			ps.setInt(5, billProduct.getId());
			ps.executeUpdate();
		} catch (Exception ex) {
			System.out.println("Update loi :" + ex);
		}

	}

	
	@Override
	public void delete(int id) {
		try {
			String sql = "delete from bill_product WHERE id = ?";
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception ex) {
			System.out.println("Update loi :" + ex);
		}

	}

	
	@Override
	public BillProduct get(int id) {
		try {
			// lay tat cot cua billproduct va vai cot cua product
			String sql = "SELECT bp.*, product.name, product.image, product.id as 'p_id' from bill_product bp inner join product on bp.product_id = product.id WHERE bp.id=?";
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BillProduct billProduct = new BillProduct();
				billProduct.setId(rs.getInt("id"));
				billProduct.setUnitPrice(rs.getLong("unitprice"));
				billProduct.setQuantity(rs.getInt("quantity"));

				Product product = new Product();
				product.setName(rs.getString("product.name"));
				product.setId(rs.getInt("p_id"));
				product.setImage(rs.getString("image"));

				billProduct.setProduct(product);

				return billProduct;
			}
		} catch (Exception ex) {
			System.out.println("get loi :" + ex);
		}

		return null;
	}

	
	@Override
	public List<BillProduct> search(int billId) {
		List<BillProduct> billList = new ArrayList<BillProduct>();

		try {
			String sql = "SELECT bp.*, product.name, product.image, product.id as 'p_id' from bill_product bp inner join product on bp.product_id = product.id WHERE bp.bill_id = ?";
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, billId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BillProduct billProduct = new BillProduct();
				billProduct.setId(rs.getInt("id"));
				billProduct.setUnitPrice(rs.getLong("unitprice"));
				billProduct.setQuantity(rs.getInt("quantity"));

				Product product = new Product();
				product.setName(rs.getString("product.name"));
				product.setId(rs.getInt("p_id"));
				product.setImage(rs.getString("image"));

				billProduct.setProduct(product);

				billList.add(billProduct);
			}
		} catch (Exception ex) {
			System.out.println("get loi :" + ex);
		}

		return billList;
	}
	@Override
	public List<BillProduct> getAll() {
		List<BillProduct> billList = new ArrayList<BillProduct>();

		try {
			String sql = "SELECT product.id,product.name,product.image,product.price from product inner join bill_product  on bill_product.product_id = product.id";
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BillProduct billProduct = new BillProduct();
				billProduct.setId(rs.getInt("id"));
				billProduct.setUnitPrice(rs.getLong("unitprice"));
				billProduct.setQuantity(rs.getInt("quantity"));

				Product product = new Product();
				product.setName(rs.getString("name"));
				product.setId(rs.getInt("id"));
				product.setImage(rs.getString("image"));

				billProduct.setProduct(product);

				billList.add(billProduct);
			}
		} catch (Exception ex) {
			System.out.println("get loi :" + ex);
		}

		return billList;
	}


}
