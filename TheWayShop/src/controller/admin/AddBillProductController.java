package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BillDao;
import dao.BillProductDao;
import dao.ProductDao;
import dao.UserDao;
import dao.impl.BillDaoImpl;
import dao.impl.BillProductDaoImpl;
import dao.impl.ProductDaoImpl;
import dao.impl.UserDaoImpl;
import model.Bill;
import model.BillProduct;
import model.Product;
import model.User;

@WebServlet(urlPatterns = "/admin/bill-product/add")
public class AddBillProductController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String billid = req.getParameter("billid");

		BillDao dao = new BillDaoImpl();
		Bill bill = dao.get(Integer.parseInt(billid));
		req.setAttribute("bill", bill);

		ProductDao dao2 = new ProductDaoImpl();
		List<Product> product = dao2.search("");
		req.setAttribute("listProd", product);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/admin/billproduct/addBillProduct.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String billid = req.getParameter("billid");
		String quantity = req.getParameter("quantity");
		String productId = req.getParameter("productId");

		ProductDao dao = new ProductDaoImpl();

		BillProduct billProduct = new BillProduct();
		billProduct.setQuantity(Integer.parseInt(quantity));

		Product product = dao.get(Integer.parseInt(productId));

		Bill bill = new Bill();
		bill.setId(Integer.parseInt(billid));

		billProduct.setProduct(product);
		billProduct.setBill(bill);
		billProduct.setUnitPrice(product.getPrice());

		BillProductDao dao2 = new BillProductDaoImpl();
		dao2.create(billProduct);

		resp.sendRedirect("/TheWayShop/admin/bill-product?id=" + billid);

	}
}
