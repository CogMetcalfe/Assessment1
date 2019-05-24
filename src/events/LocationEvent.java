package events;

import maths.Vector;

public abstract class LocationEvent {
	private Vector position;
	public Vector getPosition() {
		return position.copy();
	}
	public abstract void runEvent();
}
