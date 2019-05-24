package events;

import maths.Vector;
import textAdventureGame.Player;

public abstract class LocationEvent {
	protected Vector position;
	public Vector getPosition() {
		return position.copy();
	}
	public abstract void runEvent(Player player);
}
