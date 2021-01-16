package controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BillProductDao;
import dao.impl.BillProductDaoImpl;

@WebServlet(urlPatterns = "/admin/bill-product/delete")
public class DeleteBillProductController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String billproductid = req.getParameter("billproductid");
		String billid = req.getParameter("billid");
		BillProductDao dao = new BillProductDaoImpl();
		dao.delete(Integer.parseInt(billproductid));
		resp.sendRedirect("/TheWayShop/admin/bill-product?id=" + billid);
	}
}
