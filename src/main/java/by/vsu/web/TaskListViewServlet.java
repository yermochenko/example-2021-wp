package by.vsu.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.vsu.domain.Task;

public class TaskListViewServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		@SuppressWarnings("unchecked")
		ArrayList<Task> tasks = (ArrayList<Task>) req.getAttribute("tasks");
		int size = tasks.size();
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<meta charset=\"UT-8\">");
		pw.println("<title>List of tasks</title>");
		pw.println("<style type=\"text/css\">");
		pw.println("table {border-collapse: collapse;}");
		pw.println("th, td {border: 1px solid black;}");
		pw.println("th {background: #AAF; padding: 5px 10px;}");
		pw.println("td {padding: 5px 25px 5px 10px;}");
		pw.println(".disable {background: #DDD;}");
		pw.println("</style>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h1>List of tasks</h1>");
		pw.println("<table>");
		pw.println("<tr>");
		pw.println("<th>Title</th>");
		pw.println("<th>Description</th>");
		pw.println("<th>Date</th>");
		pw.println("<th>Importance</th>");
		pw.println("</tr>");
		for(Task task : tasks) {
			pw.printf("<tr %s>\n", !task.isActive() ? "class=\"disable\"": "");
			pw.printf("<td>%s</td>\n", task.getTitle());
			pw.printf("<td>%s</td>\n", task.getDescription());
			pw.printf("<td>%1$td.%1$tm.%1$tY, %1$tH:%1$tM</td>\n", task.getDate());
			pw.printf("<td>%.2f</td>\n", task.getImportance());
			pw.println("</tr>");
		}
		pw.println("</table>");
		pw.printf("<p>Total %d tasks</p>\n", size);
		pw.println("</body>");
		pw.println("</html>");
	}
}
