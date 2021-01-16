package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import dao.impl.ProductDaoImpl;

@WebServlet(urlPatterns = "/admin/product/delete")
public class DeleteProductController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		ProductDao dao = new ProductDaoImpl();
		dao.delete(Integer.parseInt(id));
		resp.sendRedirect("/TheWayShop/admin/product/search");
	}
}