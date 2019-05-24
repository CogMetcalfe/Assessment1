package events;

import maths.*;
import textAdventureGame.*;

public class EnvironmentEvent extends LocationEvent{
	
	String detail;
	
	public EnvironmentEvent(Vector position) {
		this.position = position;
		generateEvent();
	}

	private void generateEvent(){
		generateEvent(RandomGod.nextInt(7));
	}
	private void generateEvent(int type) {
		switch(type) {
		case 0:
			detail="You wade through thick sludge in the depths of the swamp."
					+ "\nEnourmous, mossy trees shade the area in darkness.";
			return;
		case 1:
			detail="You find yourself in a lush grassland, a brief respite from the unforgiving swamp.";
			return;
		case 2:
			detail="More swamp. It's gray, dark and wet."
					+ "\nYour boots squelch with every step."
					+ "\nA piercing howl echoes throughout the gloomy pits.";
			return;
			
		case 3:
			detail="You reach a parting in the overgrowth."
					+ "\nA slimmer of sunshine pierces the treeline and illuminates the water."
					+ "\nA dense bed of colourful flowers grows in the sunlight.";
			return;
		case 4: 
			detail="The swamp gets shallower, and more wild plants thrive."
					+ "\nYou take a moment to dry out your boots and have a snack.";
			return;
		case 5: 
			detail="As you are wandering through the swamp, you suddenly feel an overwhelming sense of dread."
					+ "\nPanic sets in as you spin around to check behind you."
					+ "\nYou see nothing but the path you came down.";
			return;
		case 6: 
			detail="You come to the bank of a wide river."
					+ "\nA creaky, rotten wooden plank bridge stretches across.";
			return;
		}
		detail = "ERROR";
	}
	
	
	@Override
	public void runEvent(Player player) {
		System.out.println(detail);
	}


}
