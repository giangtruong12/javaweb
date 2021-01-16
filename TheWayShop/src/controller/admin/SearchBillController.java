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
import dao.impl.BillDaoImpl;
import model.Bill;

@WebServlet(urlPatterns = "/admin/bill/search")
public class SearchBillController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BillDao dao = new BillDaoImpl();
		List<Bill> list = dao.getAll();
		req.setAttribute("allBill", list);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/admin/bill/searchBill.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String buyer = req.getParameter("buyer");
		BillDao dao = new BillDaoImpl();
		List<Bill> list = dao.search(buyer);
		req.setAttribute("allBill", list);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/admin/bill/searchBill.jsp");
		requestDispatcher.forward(req, resp);

	}
}
