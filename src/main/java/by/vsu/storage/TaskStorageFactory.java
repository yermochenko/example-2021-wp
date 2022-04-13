package by.vsu.storage;

public class TaskStorageFactory {
	public static TaskStorage newInstance() {
//		TaskCsvStorage taskStorage = new TaskCsvStorage();
//		taskStorage.setFileName("D:\\eclipse-workspaces\\git\\example-2021-wp\\tasks.csv");
//		return taskStorage;
		return new TaskDatabaseStorage();
	}
}
