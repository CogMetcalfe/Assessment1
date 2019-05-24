package events;
import maths.RandomGod;
import maths.Vector;
import textAdventureGame.Player;
import textAdventureGame.YesNoResponse;

public class CombatEvent extends LocationEvent{
	private int type;
	private int state;
	
	public CombatEvent(Vector position) {
		this.position = position;
		generateEvent();
	}
	@Override
	public void runEvent(Player player) {
		switch(type) {
		case 0:
			goblinCamp(player);
			break;
		case 1:
			wildDogAttack(player);
		}
	}
	private void generateEvent(){
		state=0;
		generateEvent(RandomGod.nextInt(2));
	}
	private void generateEvent(int type) {
		this.type = type;
	}
	
	private void goblinCamp(Player player) {
		System.out.println("In the distance you see a smoke stack climb high into the sky."
				+ "\nUpon approach, you see a variety of green creatures dancing around the fire, clubs in hands, singing and drinking while roasting a boar."
				+ "\nDo you wish to approach the goblin camp?[Y/N]");
		if(YesNoResponse.getResponse()) {
			//Could check strength stats and roll chance to survive.
			System.out.println("You walk up to the goblin camp and draw your..."
					+ "\n...sword that you don't have. Good job."
					+ "\nThe goblins bash in your skull and you die."
					+ "\nThey add your corpse to the roast.");
			player.takeDamage(Integer.MAX_VALUE);
		}
	}
	
	private void wildDogAttack(Player player) {
		switch(state) {
		case 0:
			System.out.println("A wild dog stalks you as you travel."
					+ "\nIt suddenly starts hurtling towards you!");
			int outcome = RandomGod.nextInt(15);
			if(outcome<1) {
				System.out.println("It bites deep into your neck, causing you to bleed heavily."
						+ "\nYou try to get it off but you stumble, fall over and hit your head on a rock."
						+ "\nYou die in a pool of mud and blood.");
				player.takeDamage(Integer.MAX_VALUE);
			}else if(outcome<5) {
				System.out.println("The beast bites your leg, but you kick it away."
						+ "\nYou climb into a nearby tree and wait for it to leave.");
				player.takeDamage(1);
				if(player.isAlive()) {
					System.out.println("You bled but managed to stop the bleeding after a while.");
				}else {
					System.out.println("The blood loss was too great. You lose consciousness and break your neck falling out of the tree");
				}
			}else {
				System.out.println("You reach down into the mud and manage to grab hold of a large rock."
						+ "\nLifting it up high, you bring it down square on the wild beasts head as it pounces."
						+ "\nYou kill it instantly. Impressive. Dog meat is on the menu.");
			}
			state++;
			break;
		case 1:
			System.out.println("The mud here is stained with blood");
			break;
		}
	}
	
}
