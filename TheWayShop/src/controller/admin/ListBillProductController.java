package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BillDao;
import dao.BillProductDao;
import dao.impl.BillDaoImpl;
import dao.impl.BillProductDaoImpl;
import model.Bill;
import model.BillProduct;

@WebServlet(urlPatterns = "/admin/bill-product")
public class ListBillProductController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String billId = req.getParameter("id");
		BillDao billDao = new BillDaoImpl();
		Bill bill = billDao.get(Integer.parseInt(billId));
		req.setAttribute("bill", bill);

		BillProductDao billProductDao = new BillProductDaoImpl();
		List<BillProduct> billProducts = billProductDao.search(Integer.parseInt(billId));
		req.setAttribute("billProducts", billProducts);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/billproduct/searchBillProduct.jsp");
		dispatcher.forward(req, resp);

	}

}
