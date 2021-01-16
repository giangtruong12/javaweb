package controller.admin;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BillDao;
import dao.UserDao;
import dao.impl.BillDaoImpl;
import dao.impl.UserDaoImpl;
import model.Bill;
import model.User;

@WebServlet(urlPatterns = "/admin/bill/add")
public class AddBillController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDao dao = new UserDaoImpl();
		List<User> list = dao.search("");
		req.setAttribute("userList", list);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/admin/bill/addBill.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        
//		String userId = req.getParameter("userId");
		String userId ="1";

		Bill bill = new Bill();

		User user = new User();
		user.setId(Integer.parseInt(userId));

		bill.setBuyer(user);
		bill.setBuyDate(date);
		bill.setPriceTotal(0);

		BillDao dao = new BillDaoImpl();
		dao.create(bill);

		resp.sendRedirect("/TheWayShop/admin/bill/search");

	}
}
