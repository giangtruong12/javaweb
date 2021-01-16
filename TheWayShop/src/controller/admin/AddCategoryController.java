package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDao;
import dao.impl.CategoryDaoImpl;
import model.Category;

@WebServlet(urlPatterns = "/admin/category/add")
public class AddCategoryController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("success", "");
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/admin/category/addCategory.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		Category category = new Category();
		category.setName(name);
		CategoryDao dao = new CategoryDaoImpl();
		dao.creat(category);
		req.setAttribute("success", "Them User Thanh Cong!");
		resp.sendRedirect(req.getContextPath() + "/admin/category/search");
	}
}
