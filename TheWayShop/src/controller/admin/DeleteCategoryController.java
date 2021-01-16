package controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDao;
import dao.impl.CategoryDaoImpl;

@WebServlet(urlPatterns = "/admin/category/delete")
public class DeleteCategoryController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		CategoryDao dao = new CategoryDaoImpl();
		dao.delete(Integer.parseInt(id));
		resp.sendRedirect("/TheWayShop/admin/category/search");
	}
}
