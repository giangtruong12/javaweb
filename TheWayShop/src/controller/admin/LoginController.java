package controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import model.User;

@WebServlet(urlPatterns = "/login-admin")
public class LoginController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("errorCode");
		if (code != null && code.equals("1000")) {
			req.setAttribute("msg", "Sai tai khoan hoac mat khau!");
		}
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/admin/login.jsp");
		requestDispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		HttpSession session = req.getSession();
		UserDao dao = new UserDaoImpl();
		User user = dao.getByUsername(username);
		if (user != null && user.getPassword().equals(password)) {
			System.out.println("Login thanh cong!");
			session.setAttribute("loginUser", user);
			resp.sendRedirect("/TheWayShop/admin/user/search");
		} else {
			resp.sendRedirect("/TheWayShop/login-admin?errorCode=1000");
		}
	}
}
