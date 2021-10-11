package by.vsu.console;

import java.io.IOException;
import java.util.ArrayList;

import by.vsu.domain.Task;
import by.vsu.storage.TaskCsvStorage;

public class Runner {
	public static void main(String[] args) {
		TaskCsvStorage storage = new TaskCsvStorage();
		storage.setFileName("tasks.csv");
		try {
			ArrayList<Task> tasks = storage.readAll();
			for(Task task : tasks) {
				System.out.println(task);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
