package controller.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDao;
import dao.impl.ProductDaoImpl;
import model.BillProduct;
import model.Product;

@WebServlet(urlPatterns = "/add-to-cart")
public class AddToCartController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pid = req.getParameter("pid");
		ProductDao dao = new ProductDaoImpl();
		Product product = dao.get(Integer.parseInt(pid));

		HttpSession session = req.getSession();
		Object object = session.getAttribute("cart");

		if (object == null) {
			BillProduct billProduct = new BillProduct();
			billProduct.setProduct(product);
			billProduct.setQuantity(1);
			billProduct.setUnitPrice(product.getPrice());

			Map<String, BillProduct> map = new HashMap<String, BillProduct>();
			map.put(pid, billProduct);

			session.setAttribute("cart", map);
		} else {
			Map<String, BillProduct> map = (Map<String, BillProduct>) object;
			BillProduct billProduct = map.get(pid);

			if (billProduct == null) {
				billProduct = new BillProduct();
				billProduct.setProduct(product);
				billProduct.setQuantity(1);
				billProduct.setUnitPrice(product.getPrice());
				map.put(pid, billProduct);
			} else {
				billProduct.setQuantity(billProduct.getQuantity() + 1);
			}
			session.setAttribute("cart", map);
		}
		resp.sendRedirect(req.getContextPath() + "/cart");
	}
}
