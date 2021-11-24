package by.vsu.console;

public class MulCommand extends Command {
	@Override
	public boolean execute(double[] params) {
		if(params.length == 2) {
			System.out.printf(
				"%f * %f = %f\n",
				params[0],
				params[1],
				params[0] * params[1]
			);
		} else {
			System.out.println("Error: command MUL need exactly 2 parameters");
		}
		return true;
	}
}
