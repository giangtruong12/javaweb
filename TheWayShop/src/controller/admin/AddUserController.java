package controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import model.User;

@WebServlet(urlPatterns = "/admin/user/add")
public class AddUserController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/admin/user/addUser.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String age = req.getParameter("age");
		String name = req.getParameter("name");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String role = req.getParameter("role");

		User user = new User();
		user.setAge(Integer.parseInt(age));
		user.setName(name);
		user.setUsername(username);
		user.setPassword(password);
		user.setRole(role);
		UserDao userDao = new UserDaoImpl();
		userDao.create(user);

		req.setAttribute("success", "Them User Thanh Cong!");

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/admin/user/addUser.jsp");
		requestDispatcher.forward(req, resp);

	}
}
