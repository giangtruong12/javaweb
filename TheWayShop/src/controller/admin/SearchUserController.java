package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import model.User;

@WebServlet(urlPatterns = "/admin/user/search")
public class SearchUserController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDao dao = new UserDaoImpl();
		List<User> allUsers = dao.search("");
		req.setAttribute("allUsers", allUsers);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/admin/user/searchUser.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");

		UserDao dao = new UserDaoImpl();
		List<User> user = dao.search(name);
		req.setAttribute("allUsers", user);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/admin/user/searchUser.jsp");
		requestDispatcher.forward(req, resp);
	}
}