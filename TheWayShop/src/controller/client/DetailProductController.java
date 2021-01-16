package controller.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDao;
import dao.ProductDao;
import dao.impl.CategoryDaoImpl;
import dao.impl.ProductDaoImpl;
import model.Category;
import model.Product;

@WebServlet(urlPatterns = "/client/product/detail")
public class DetailProductController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");

		CategoryDao dao = new CategoryDaoImpl();
		List<Category> list = dao.search("");
		req.setAttribute("cateList", list);

		ProductDao dao2 = new ProductDaoImpl();
		Product product = dao2.get(Integer.parseInt(id));
		req.setAttribute("product", product);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/client/product/detailProduct.jsp");
		requestDispatcher.forward(req, resp);
	}
}
