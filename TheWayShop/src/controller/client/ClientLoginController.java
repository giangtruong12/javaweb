package controller.client;

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

@WebServlet(urlPatterns = "/login-member")
public class ClientLoginController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("errCode");

		if (code != null && code.equals("100")) {
			req.setAttribute("msg", "Tai khoan hoac mat khau sai");
		}
		RequestDispatcher dispathcer = req.getRequestDispatcher("/view/client/login.jsp");
		dispathcer.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String pass = req.getParameter("password");

		UserDao userDao = new UserDaoImpl();
		User user = userDao.getByUsername(username);

		if (user != null && user.getPassword().equals(pass)) {
			System.out.println("Log in success");
			// tao session
			HttpSession session = req.getSession();
			// luu doi tuong vao session
			session.setAttribute("loginUser", user);

			// chuyen huong : server tra ve cho client mot trang web(duong dan) khac
			// req.getContextPath(): ten root path(ten project)
			resp.sendRedirect("/TheWayShop/client/product/search"); // respond : server tra ve

		} else {
			System.out.println("Login Fail!");
			resp.sendRedirect("/TheWayShop/login-member?errCode=100");
		}
	}
}
