package textAdventureGame;
import java.util.Scanner;
import events.WorldEvents;

public class CompassGame {
	private WorldEvents eventSystem;
	private Map worldMap;
	private Scanner consoleInput;
	
	public CompassGame(){
		worldMap = new Map();
		eventSystem = new WorldEvents();
	}
	
	public void run() {
		consoleOut("Grey foggy clouds float oppressively close to you,\r\n" + 
				"reflected in the murky grey water which reaches up your shins.\r\n" + 
				"Some black plants barely poke out of the shallow water.\r\n" + 
				"Try \"north\",\"south\",\"east\",or \"west\"\r\n" + 
				"You notice a small watch-like device in your left hand.\r\n" + 
				"It has hands like a watch, but the hands don't seem to tell time.\n");
		printDial();
		boolean running=true;
		while(running) {
			input();
			//worldMap.getPlayer().stats.getDexterity()
			if(!worldMap.getPlayer().isAlive()) {
				consoleOut("YOU DIED, GAME OVER");
				running=false;
			}
			if(worldMap.foundTreasure()) {
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
	private void printDial() {
		consoleOut("The dial reads: \'" + worldMap.compassDirection() + "\'");
	}
	private void runEvent() {
		eventSystem.findOrCreateLocationEvent(worldMap.getPlayer().getPosition()).runEvent(worldMap.getPlayer());
	}
	private boolean input() {
		String input = GlobalScanner.scanGlobal.nextLine();
		String command = input.toLowerCase();
		switch(command) {
			case "n":
			case "north":
				worldMap.goNorth();
				runEvent();
				printDial();
			break;
			case "s":
			case "south":
				worldMap.goSouth();
				runEvent();
				printDial();
			break;
			case "w":
			case "west":
				worldMap.goWest();
				runEvent();
				printDial();
			break;
			case "e":
			case "east":
				worldMap.goEast();
				runEvent();
				printDial();
			break;
			case "dial":
			case "d":
				printDial();
				return false;
			case "status":
			case "stats":
				consoleOut(worldMap.getPlayer().stats.status());
				return false;
			default:
				consoleOut("\'" + input + "\' is not a compass direction e.g. \'North\', \'E\'");
				return false;
		}
		return true;
	}
	
}
