package by.vsu.console;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("command: ");
			String command = sc.nextLine();
			String[] parts = command.split(" ");
			Command cmd = CommandFactory.newCommand(parts[0]);
			if(cmd != null) {
				try {
					double[] parameters = new double[parts.length - 1];
					for(int i = 1; i < parts.length; i++) {
						parameters[i - 1] = Double.parseDouble(parts[i]);
					}
					boolean result = cmd.execute(parameters);
					if(!result) {
						break;
					}
				} catch (NumberFormatException e) {
					System.out.println("Parameters need to be floating point numbers");
				}
			} else {
				System.out.println("Unknown command " + parts[0]);
			}
		}
		sc.close();
	}
}
