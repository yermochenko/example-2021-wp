package by.vsu.console;

public class CommandFactory {
	public static Command newCommand(String name) {
		if(name.equalsIgnoreCase("add")) {
			return new AddCommand();
		} else if(name.equalsIgnoreCase("mul")) {
			return new MulCommand();
		} else if(name.equalsIgnoreCase("exit")) {
			return new ExitCommand();
		}
		return null;
	}
}
