package by.vsu.storage;

import java.util.ArrayList;

import by.vsu.domain.Task;

abstract public class TaskStorage {
	abstract public ArrayList<Task> readAll() throws StorageException;
}
