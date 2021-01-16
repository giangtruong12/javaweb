package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.BillDao;
import lombok.val;
import model.Bill;
import model.User;

public class BillDaoImpl extends JDBCConnection implements BillDao {
	@Override
	public void create(Bill bills) {
		Connection conn = super.getConnection();
		try {
			String sql = "INSERT INTO bill(buyer_id, buydate, pricetotal) values(?,?,?)";
			
			///THEM HANG SO RETURN GENERATED KEYS DE TRA VE ID TU GEN O SQL
			PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, bills.getBuyer().getId());
			st.setDate(2,new Date(bills.getBuyDate().getTime()));
			st.setLong(3, bills.getPriceTotal());
			

			st.executeUpdate();

			/// tra ve ID gen ra, de luu sang billproduct
			ResultSet rs = st.getGeneratedKeys();
			if (rs.next()) {//NEU CO tao moi va ID tu gen o sql
				bills.setId(rs.getInt(1));// lay id cua bill
			}
		} catch (Exception ex) {
			System.out.println("Loi :" + ex);
		}
	}

	
	@Override
	public void update(Bill bills) {
		try {
			String sql = "update bill SET buyer_id = ? , buydate = ?, pricetotal = ? WHERE id = ?";
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bills.getBuyer().getId());
			ps.setDate(2,new Date(bills.getBuyDate().getTime()));
			ps.setLong(3, bills.getPriceTotal());
			ps.setInt(4, bills.getId());
			ps.executeUpdate();
		} catch (Exception ex) {
			System.out.println("Update loi :" + ex);
		}

	}

	
	@Override
	public void delete(int id) {
		try {
			String sql = "delete from bill WHERE id = ?";
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception ex) {
			System.out.println("Update loi :" + ex);
		}

	}


	@Override
	public Bill get(int id) {
		try {
			String sql = "SELECT bill.id ,bill.buyer_id, bill.buydate,bill.pricetotal, user.name  FROM bill inner join user ON bill.buyer_id = user.id WHERE bill.id = ?";
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int buyer_id=rs.getInt("buyer_id");
				int pid = rs.getInt("id");
				String buyerName = rs.getString("name");
				Date buydate = rs.getDate("buydate");
				Long pricetotal = rs.getLong("pricetotal");

				Bill bill = new Bill();
				bill.setId(pid);
				bill.setBuyDate(buydate);
				bill.setPriceTotal(pricetotal);
				

				User buyer = new User();
				buyer.setId(buyer_id);
				buyer.setName(buyerName);
				bill.setBuyer(buyer);

				return bill;
			}
		} catch (Exception ex) {
			System.out.println("Update loi :" + ex);
		}

		return null;
	}

	// tim tat ca don hang cua nguoi mua
	
	@Override
	public List<Bill> search(int userId) {
		List<Bill> billList = new ArrayList<Bill>();
		try {
			String sql = "SELECT bill.id , bill.buydate,bill.pricetotal, user.name  FROM bill inner join user ON bill.buyer_id = user.id WHERE user.id = ?";
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int pid = rs.getInt("id");
				String buyerName = rs.getString("name");
				Date buydate = rs.getDate("buydate");
				Long pricetotal = rs.getLong("pricetotal");

				Bill bill = new Bill();
				bill.setId(pid);
				bill.setBuyDate(buydate);
				bill.setPriceTotal(pricetotal);

				User buyer = new User();
				buyer.setName(buyerName);
				bill.setBuyer(buyer);

				billList.add(bill);
			}
		} catch (Exception ex) {
			System.out.println("Update loi :" + ex);
		}

		return billList;
	}
	
	@Override
	public List<Bill> search(String buyer) {
		List<Bill> billList = new ArrayList<Bill>();
		try {
//			String sql = "SELECT p.*, c.name as 'c_name' FROM product p "
//					+ "INNER JOIN category c ON p.category_id = c.id WHERE p.name LIKE ?";
			String sql = "SELECT bill.id , bill.buydate,bill.pricetotal, user.name "
					+ " FROM bill INNER JOIN user ON bill.buyer_id = user.id WHERE user.name LIKE ?";
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,"%"+buyer+"%");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int pid = rs.getInt("id");
				String buyerName = rs.getString("name");
				Date buydate = rs.getDate("buydate");
				Long pricetotal = rs.getLong("pricetotal");

				Bill bill = new Bill();
				bill.setId(pid);
				bill.setBuyDate(buydate);
				bill.setPriceTotal(pricetotal);

				User user = new User();
				user.setName(buyerName);
				bill.setBuyer(user);

				billList.add(bill);
			}
		} catch (Exception ex) {
			System.out.println("Update loi :" + ex);
		}

		return billList;
	}
	
	@Override
	public List<Bill> getAll() {
		List<Bill> billList = new ArrayList<Bill>();
		try {
			String sql = "SELECT bill.id , bill.buydate,bill.pricetotal, user.name  FROM bill inner join user ON bill.buyer_id = user.id";
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int pid = rs.getInt("id");
				String buyerName = rs.getString("name");
				Date buydate = rs.getDate("buydate");
				Long pricetotal = rs.getLong("pricetotal");

				Bill bill = new Bill();
				bill.setId(pid);
				bill.setBuyDate(buydate);
				bill.setPriceTotal(pricetotal);

				User user = new User();
				user.setName(buyerName);
				bill.setBuyer(user);

				billList.add(bill);
			}
		} catch (Exception ex) {
			System.out.println("Update loi :" + ex);
		}

		return billList;
	}
	
}
