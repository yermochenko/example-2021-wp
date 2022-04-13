package by.vsu.storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import by.vsu.domain.Task;

public class TaskDatabaseStorage extends TaskStorage {
	@Override
	public ArrayList<Task> readAll() throws StorageException {
		String sql = "SELECT \"id\", \"title\", \"description\", \"active\", \"date\", \"importance\" FROM \"task\"";
		Connection c = null;
		Statement s = null;
		ResultSet r = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/wp_2022_tasks_db", "root", "root");
			s = c.createStatement();
			r = s.executeQuery(sql);
			ArrayList<Task> tasks = new ArrayList<>();
			while(r.next()) {
				Task task = new Task();
				task.setId(r.getInt("id"));
				task.setTitle(r.getString("title"));
				task.setDescription(r.getString("description"));
				task.setActive(r.getBoolean("active"));
				java.sql.Timestamp d1 = r.getTimestamp("date"); // java.sql.Date
				long millis = d1.getTime();
				java.util.Date d2 = new java.util.Date(millis);
				task.setDate(d2);
				task.setImportance(r.getDouble("importance"));
				tasks.add(task);
			}
			return tasks;
		} catch(ClassNotFoundException | SQLException e) {
			throw new StorageException(e);
		} finally {
			try { r.close(); } catch(Exception e) {}
			try { s.close(); } catch(Exception e) {}
			try { c.close(); } catch(Exception e) {}
		}
	}
}
