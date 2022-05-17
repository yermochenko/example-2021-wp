package by.vsu.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.vsu.domain.Task;
import by.vsu.storage.StorageException;
import by.vsu.storage.TaskStorage;
import by.vsu.storage.TaskStorageFactory;

public class TaskListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TaskStorage storage = TaskStorageFactory.newInstance();
		try {
			ArrayList<Task> tasks = storage.readAll();
			req.setAttribute("tasks", tasks);
			req.getRequestDispatcher("/WEB-INF/jsp/task/list.jsp").forward(req, resp);
		} catch (StorageException e) {
			throw new ServletException(e);
		}
	}
}
