package by.vsu.console;

public class ExitCommand extends Command {
	@Override
	public boolean execute(double[] params) {
		if(params.length == 0) {
			System.out.println("Good bye");
			return false;
		} else {
			System.out.println("Command EXIT can't have any parameters");
			return true;
		}
	}
}
