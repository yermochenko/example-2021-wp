package by.vsu.storage;

public class StorageException extends Exception {
	public StorageException(String message) {
		super(message);
	}

	public StorageException(Throwable cause) {
		super(cause);
	}
}
