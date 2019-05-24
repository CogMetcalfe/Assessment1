import java.util.ArrayList;
import java.util.Random;
public class Map {
	Vector playerPos;
	Vector treasurePos;
	Random rand;
	Map(){
		//set seed ??
//		rand.setSeed(arg0);
		rand = new Random();
		playerPos = new Vector();
		treasurePos = new Vector(rand.nextInt(5)+5,0);
		treasurePos = treasurePos.rotate(rand.nextFloat());
	}
	Vector getVectorToTreasure() {
		return treasurePos.sub(playerPos);
	}
	double getDistanceToTreasure() {
		return playerPos.dist(treasurePos);
	}
	boolean foundTreasure() {
		return getDistanceToTreasure()==0;
	}
	void movePlayer(Vector displacement) {
		playerPos = playerPos.plus(displacement);
	}
	void goNorth() {
		movePlayer(new Vector(0,1));
	}
	void goSouth() {
		movePlayer(new Vector(0,-1));
	}
	void goWest() {
		movePlayer(new Vector(-1,0));
	}
	void goEast() {
		movePlayer(new Vector(1,0));
	}
}
