package textAdventureGame;

import java.util.Scanner;

public class YesNoResponse {
	public static boolean getResponse() {
		Scanner s = new Scanner(System.in);
		while(true) {
			String command = s.nextLine();
			switch(command.toLowerCase()) {
			case "n":
			case "no":
				return false;
			case "y":
			case "ye":
			case "yes":
				return true;
			}
			System.out.println("\"" + command + "\" is not a valid response, please type yes or no");
		}
	}
}
