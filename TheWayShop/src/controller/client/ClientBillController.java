package controller.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BillDao;
import dao.impl.BillDaoImpl;
import model.Bill;
import model.User;

@WebServlet(urlPatterns = "/member/bills")
public class ClientBillController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		User buyer = (User) session.getAttribute("loginUser");
		if (buyer != null) {
			BillDao dao = new BillDaoImpl();
			List<Bill> list = dao.search(buyer.getId());
			req.setAttribute("bills", list);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/client/bill/bill-list.jsp");
			requestDispatcher.forward(req, resp);
		} else {
			resp.sendRedirect(req.getContextPath() + "/login-member");
		}

	}
}
