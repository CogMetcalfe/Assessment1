import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
public class Map {
	//final int goblinResetDistance=5;
	//final int goblinFuzzyModifier=3;
	final double goblinDensity = 0.05;
	final double chanceToSlayGoblin = 0.5;
	
	boolean alive;
	boolean killedGoblinFlag;
	Vector playerPos;
	Vector treasurePos;
	ArrayList<Vector> goblinPosArray;
	Random rand;
	Map(){
		//set seed ??
//		rand.setSeed(arg0);
		rand = new Random();
		playerPos = new Vector();
		treasurePos = new Vector(rand.nextInt(5)+5,0);
		treasurePos = treasurePos.rotate(rand.nextFloat());
		generateGoblins();
	}
	void generateGoblins() {
		goblinPosArray = new ArrayList<Vector>();
		Vector playerToTreasure = treasurePos.sub(playerPos);
		Vector midPoint = playerPos.plus(playerToTreasure.multiply(0.5));
		playerToTreasure = playerToTreasure.plus(new Vector(10,10));
		int maxX, minX, maxY, minY;
		
		maxX = midPoint.x+Math.abs(playerToTreasure.x);
		minX = midPoint.x-Math.abs(playerToTreasure.x);
		
		maxY = midPoint.y+Math.abs(playerToTreasure.y);
		minY = midPoint.y-Math.abs(playerToTreasure.y);
		
		int area = (maxX-minX)*(maxY-minY);

		//for a certain number of times, and stop if the goblin density gets high enough
		for(int i=0;i<goblinDensity*area*2&&!(goblinPosArray.size() <goblinDensity*area);i++) {
			int x,y;
			x = minX + rand.nextInt(maxX-minX);
			y = minY + rand.nextInt(maxY-minY);
			Vector newGoblin = new Vector(x,y);
			
			//if too close to player
			if(newGoblin.dist(playerPos)<4) {
				continue;
			}
			
			//if too close to treasure
			if(newGoblin.dist(treasurePos)<6) {
				continue;
			}
			
			//if too close to another goblin
			if(goblinDistance(newGoblin)<5) {
				continue;
			}
			goblinPosArray.add(newGoblin);
		}
	}
	
	private void generateCurrentLocation() {
		
	}
	
	double goblinDistance(Vector v) {
		double closest=Double.MAX_VALUE;
		for(Vector g:goblinPosArray) {
			closest = Math.min(closest, v.dist(g));
		}
		return closest;
	}
	double goblinDistancePlayer() {
		return goblinDistance(playerPos);
	}

	boolean killedByGoblin() {
		return !alive;
	}
	
	double fuzzyCompass() {
		//adds goblin jam to the compass
		if(goblinDistancePlayer()==1) {
			return Double.MAX_VALUE*(rand.nextInt(2)*2-1);
		}else if(goblinDistancePlayer()<=3) {
			return getDistanceToTreasure()+(((float)rand.nextInt(7)+3)*(rand.nextInt(2)*2-1));
		}else {
			return getDistanceToTreasure();
		}
	}
	Vector getClosestGoblin() {
		double closest=Double.MAX_VALUE;
		Vector goblin=new Vector(-1,-1);
		for(Vector g:goblinPosArray) {
			closest = Math.min(closest, playerPos.dist(g));
			goblin = g;
		}
		return goblin;
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
		//goblin encounter
		if(goblinDistancePlayer()==0) {
			goblinPosArray.remove(getClosestGoblin());
			killedGoblinFlag=true;
		}
	}
	boolean goblinSlain() {
		if(killedGoblinFlag) {
			killedGoblinFlag = false;
			return true;
		}
		return false;
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
