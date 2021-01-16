package controller.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BillDao;
import dao.impl.BillDaoImpl;

@WebServlet(urlPatterns = "/member/bill/delete")
public class ClientBillDeleteController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String billid = req.getParameter("billid");
		BillDao dao = new BillDaoImpl();
		dao.delete(Integer.parseInt(billid));
		resp.sendRedirect("/TheWayShop/member/bills");

	}
}