package controller.client;

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

;

@WebServlet(urlPatterns = "/member/bill-product")
public class ClientBillProductController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String billid = req.getParameter("billid");
		BillProductDao billProductDao = new BillProductDaoImpl();
		BillDao billDao = new BillDaoImpl();

		Bill bill = billDao.get(Integer.parseInt(billid));
		req.setAttribute("bill", bill);

		List<BillProduct> billProducts = billProductDao.search(Integer.parseInt(billid));
		req.setAttribute("billProducts", billProducts);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/bill/bill-product.jsp");
		dispatcher.forward(req, resp);
	}
}
