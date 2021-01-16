package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.CategoryDao;
import dao.impl.CategoryDaoImpl;
import model.Category;

@WebServlet(urlPatterns = "/admin/category/search")
public class SearchCategoryController extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    CategoryDao dao =new CategoryDaoImpl();
    List<Category> allUsers =dao.search("");
    req.setAttribute("searchCate",allUsers);
	RequestDispatcher requestDispatcher =req.getRequestDispatcher("/view/admin/category/searchCategory.jsp");
     requestDispatcher.forward(req, resp);
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     String name =req.getParameter("name");
     CategoryDao dao =new CategoryDaoImpl();
     List<Category> list =dao.search(name);
     req.setAttribute("searchCate", list);
     RequestDispatcher requestDispatcher =req.getRequestDispatcher("/view/admin/category/searchCategory.jsp");
     requestDispatcher.forward(req, resp);
	}
}
