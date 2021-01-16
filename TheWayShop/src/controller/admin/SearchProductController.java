package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import dao.impl.ProductDaoImpl;
import model.Product;

@WebServlet(urlPatterns = "/admin/product/search")	// muc search nen chi dung Get thoi, vi k them du lieu gi vao ma chi search du lieu thoi
public class SearchProductController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductDao dao = new ProductDaoImpl();
		List<Product> list = dao.search("");
		req.setAttribute("allProd", list);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/admin/product/searchProduct.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		ProductDao dao = new ProductDaoImpl();
		List<Product> list = dao.search(name);
		req.setAttribute("allProd", list);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/admin/product/searchProduct.jsp");
		requestDispatcher.forward(req, resp);
	}
}