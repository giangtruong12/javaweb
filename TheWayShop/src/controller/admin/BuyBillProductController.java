package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BillDao;
import dao.impl.BillDaoImpl;
import model.Bill;

@WebServlet(urlPatterns = "/admin/bill-product/buy")
public class BuyBillProductController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String billid = req.getParameter("billid");
		String tongtien = req.getParameter("tongtien");

		BillDao dao = new BillDaoImpl();
		Bill bill = dao.get(Integer.parseInt(billid));

		Bill bill2 = new Bill();
		bill2.setId(Integer.parseInt(billid));
		bill2.setBuyDate(bill.getBuyDate());
		bill2.setBuyer(bill.getBuyer());
		bill2.setPriceTotal(bill.getPriceTotal() + Long.parseLong(tongtien));
		dao.update(bill2);

		resp.sendRedirect("/TheWayShop/admin/bill-product?id=" + billid);

	}
}