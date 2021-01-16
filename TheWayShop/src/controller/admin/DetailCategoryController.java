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
import model.Category;

@WebServlet(urlPatterns = "/admin/category/detail")
public class DetailCategoryController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		CategoryDao dao = new CategoryDaoImpl();
		Category category = dao.get(Integer.parseInt(id));
		req.setAttribute("category", category);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/admin/category/detailCategory.jsp");
		requestDispatcher.forward(req, resp);

	}
}