package by.vsu.storage;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import by.vsu.domain.Task;

public class TaskCsvStorage extends TaskStorage {
	private String fileName;

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public ArrayList<Task> readAll() throws StorageException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy, HH:mm");
		BufferedReader br = null;
		String row = null;
		try {
			FileInputStream fis = new FileInputStream(fileName);
			InputStreamReader isr = new InputStreamReader(fis, "cp1251");
			br = new BufferedReader(isr);
			ArrayList<Task> tasks = new ArrayList<>();
			while((row = br.readLine()) != null) {
				String[] parts = row.split(";");
				if(parts.length == 6) {
					Task task = new Task();
					task.setId(Integer.parseInt(parts[0]));
					task.setTitle(parts[1]);
					task.setDescription(parts[2]);
					task.setActive(Boolean.parseBoolean(parts[3]));
					task.setDate(sdf.parse(parts[4]));
					task.setImportance(Double.parseDouble(parts[5]));
					tasks.add(task);
				} else {
					throw new StorageException("Incorrect amount of cell in row \"" + row + "\"");
				}
			}
			return tasks;
		} catch(ParseException | NumberFormatException e) {
			throw new StorageException("Incorrect content of cells in row \"" + row + "\"");
		} catch(IOException e) {
			throw new StorageException(e);
		} finally {
			try { br.close(); } catch(Exception e) {}
		}
	}
}
