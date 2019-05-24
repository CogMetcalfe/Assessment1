package textAdventureGame;
import java.util.Scanner;

public class CompassGame {
	private Map worldMap;
	private Scanner consoleInput;
	public CompassGame(){
		worldMap = new Map();
	}
	public void run() {
		consoleOut("Grey foggy clouds float oppressively close to you,\r\n" + 
				"reflected in the murky grey water which reaches up your shins.\r\n" + 
				"Some black plants barely poke out of the shallow water.\r\n" + 
				"Try \"north\",\"south\",\"east\",or \"west\"\r\n" + 
				"You notice a small watch-like device in your left hand.\r\n" + 
				"It has hands like a watch, but the hands don't seem to tell time.\n");
		boolean running=true;
		consoleInput = new Scanner(System.in);
		while(running) {
			consoleOut("The dial reads: \'" + worldMap.fuzzyCompass() + "\'");
			while(!input()) {}
			if(worldMap.getDistanceToTreasure()==0) {
				//Win condition met
				running = false;
				consoleOut("\n You see a box sitting on the plain. Its filled with treasure! You win!\r\n" + 
						"The end.\r\n");
			}
		}
	}
	private void consoleOut(String text) {
		System.out.println(text);
	}
	public boolean input() {
		String input = consoleInput.nextLine();
		String command = input.toLowerCase();
		switch(command) {
			case "n":
			case "north":
				worldMap.goNorth();
			break;
			case "s":
			case "south":
				worldMap.goSouth();
			break;
			case "w":
			case "west":
				worldMap.goWest();
			break;
			case "e":
			case "east":
				worldMap.goEast();
			break;
			default:
				consoleOut("\'" + input + "\' is not a compass direction e.g. \'North\', \'E\'");
				return false;
		}
		return true;
	}
	
}
