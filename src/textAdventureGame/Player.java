package textAdventureGame;

import maths.Vector;

public class Player {
	private Vector position;
	Player(){
		position = new Vector();
	}
	Player(Vector position){
		this.position = position.copy();
	}
	public void movePlayer(Vector displacement) {
		position = position.plus(displacement);
	}
	public Vector getPosition() {
		return position.copy();
	}
}
