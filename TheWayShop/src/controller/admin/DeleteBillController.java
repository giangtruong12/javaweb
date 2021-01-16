package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BillDao;
import dao.impl.BillDaoImpl;

@WebServlet(urlPatterns = "/admin/bill/delete")
public class DeleteBillController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		BillDao dao = new BillDaoImpl();
		dao.delete(Integer.parseInt(id));
		resp.sendRedirect("/TheWayShop/admin/bill/search");
	}
}
