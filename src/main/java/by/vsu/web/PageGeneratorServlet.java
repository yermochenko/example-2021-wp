package by.vsu.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageGeneratorServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("<body style=\"background: yellow\">");
		double number = Math.round(Math.random() * 100);
		pw.println("<p style=\"background: #AFA; border: 2px solid green; padding: 20px; border-radius: 20px;\">" + number + "</p>");
		pw.println("</body>");
		pw.println("</html>");
	}
}
