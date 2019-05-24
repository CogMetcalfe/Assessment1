package events;
import maths.RandomGod;
import maths.Vector;
import textAdventureGame.*;

public class InteractiveEvent extends LocationEvent{
	int type;
	int stage;
	public InteractiveEvent(Vector position) {
		this.position = position;
		generateEvent();
	}
	public InteractiveEvent(Vector position, int type) {
		this.position = position;
		stage = 0;
		this.type = type;
	}
	
	private void generateEvent() {
		stage=0;
		type = RandomGod.nextInt(1);
	}
	@Override
	public void runEvent(Player player) {
		switch(type) {
		case 0:
			System.out.println("You come across great ruins of a civilisation long past.\r\n" + 
					"Scattered about are great stone monuments to the old gods.\r\n" + 
					"You climb the steps leading into a great temple, constructed from steel and rock.\r\n" + 
					"Inside lies a sword, constructed out of black glass. It feels natural and fits into your hilt perfectly."
					+ "\n");
			player.inv.addItem(new Item("sword"));
			break;
		}
	}
	
}
