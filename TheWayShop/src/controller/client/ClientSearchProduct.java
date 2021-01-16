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

import dao.CategoryDao;
import dao.ProductDao;
import dao.impl.CategoryDaoImpl;
import dao.impl.ProductDaoImpl;
import model.Category;
import model.Product;
import model.User;

@WebServlet(urlPatterns = "/client/product/search")
public class ClientSearchProduct extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("loginUser");
		if (user != null) {
			req.setAttribute("user", user);
		}

		CategoryDao dao = new CategoryDaoImpl();
		List<Category> list = dao.search("");
		req.setAttribute("cateList", list);

		ProductDao dao2 = new ProductDaoImpl();
		List<Product> list2 = dao2.search("");
		req.setAttribute("prodList", list2);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/client/product/searchProduct.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");

		CategoryDao dao = new CategoryDaoImpl();
		List<Category> list = dao.search("");
		req.setAttribute("cateList", list);

		ProductDao dao2 = new ProductDaoImpl();
		List<Product> list2 = dao2.search(name);
		req.setAttribute("prodList", list2);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/client/product/searchProduct.jsp");
		requestDispatcher.forward(req, resp);

	}
}
