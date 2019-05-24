package textAdventureGame;

import maths.Vector;

public class Player {
	private Vector position;
	public Status stats;
	private int gold;
	public Inventory inv;
	Player(){
		position = new Vector();
		inv = new Inventory();
		gold=0;
		stats = new Status();
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
	public void addGold(int gold) {
		if(gold>0) {
			this.gold+=gold;
		}
	}
	public boolean payGold(int cost) {
		if(gold>=cost && cost>0) {
			gold-=cost;
			return true;
		}
		return false;
	}
	public String getHealthStatus() {
		return stats.healthStatus();
	}
	public void takeDamage(int damage) {
		stats.takeDamage(damage);
	}
	public boolean isAlive() {
		return stats.getHealth()>0;
	}
}
