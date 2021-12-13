package by.vsu.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.vsu.domain.Task;
import by.vsu.storage.TaskCsvStorage;

public class TaskListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TaskCsvStorage storage = new TaskCsvStorage();
		storage.setFileName("D:\\eclipse-workspaces\\git\\example-2021-wp\\tasks.csv");
		try {
			ArrayList<Task> tasks = storage.readAll();
			req.setAttribute("tasks", tasks);
			req.getRequestDispatcher("/WEB-INF/task/list.html").forward(req, resp);
		} catch (IOException e) {
			throw new ServletException(e);
		}
	}
}
