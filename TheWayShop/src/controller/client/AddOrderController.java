package controller.client;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BillDao;
import dao.BillProductDao;
import dao.impl.BillDaoImpl;
import dao.impl.BillProductDaoImpl;
import model.Bill;
import model.BillProduct;
import model.User;

@WebServlet(urlPatterns = "/member/add-order")
public class AddOrderController extends HttpServlet {
	BillDao billDao = new BillDaoImpl();
	BillProductDao billProductDao = new BillProductDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Object object = session.getAttribute("cart");
		User buyer = (User) session.getAttribute("loginUser");
		if (buyer != null) {
			if (object != null) {
				Map<String, BillProduct> map = (Map<String, BillProduct>) object;

				Bill bill = new Bill();
//			SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
				bill.setBuyDate((java.sql.Date) new Date());

//			User buyer=(User)session.getAttribute("loginUser");
				bill.setBuyer(buyer);

				billDao.create(bill);
				long total = 0;
				for (Entry<String, BillProduct> entry : map.entrySet()) {
					BillProduct billProduct = entry.getValue();
					billProduct.setBill(bill);
					billProductDao.create(billProduct);
					total += billProduct.getUnitPrice() * billProduct.getQuantity();
				}

				bill.setPriceTotal(total);
				billDao.update(bill);
				session.removeAttribute("cart");
				resp.sendRedirect(req.getContextPath() + "/member/bills");
			} else {
				resp.sendRedirect(req.getContextPath() + "/client/product/search");
			}

		} else {
			resp.sendRedirect(req.getContextPath() + "/login-member");
		}

	}
}
