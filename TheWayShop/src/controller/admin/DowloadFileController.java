package controller.admin;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

@WebServlet(urlPatterns = "/download")
public class DowloadFileController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String image = req.getParameter("image");
		final String UPLOAD_FOLDER = "/Volumes/Macintosh\\ HD/Users/apple/Downloads\n" + 
				"";
		File file = new File(UPLOAD_FOLDER + File.separator + image);
		if (file.exists()) {
			FileUtils.copyFile(file, resp.getOutputStream());
		}

	}

}
