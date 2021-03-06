package textAdventureGame;


import maths.RandomGod;
import maths.Vector;

public class Map {
	//final int goblinResetDistance=5;
	//final int goblinFuzzyModifier=3;
//	final private double goblinDensity = 0.05;
//	final private double chanceToSlayGoblin = 0.5;
//	
//	private boolean alive;
//	private boolean killedGoblinFlag;
	private Player player;
	private Vector treasurePos;
//	private ArrayList<Vector> goblinPosArray;
	//private Random rand;
	public Map(){
		//set seed ??
//		rand.setSeed(arg0);
		//rand = new Random();
		player = new Player();
		treasurePos = new Vector(RandomGod.nextInt(5)+5,0);
		treasurePos = treasurePos.rotate(RandomGod.nextFloat());
//		generateGoblins();
	}
	
	public Player getPlayer() {
		return player;
	}
	
//	private void generateGoblins() {
//		goblinPosArray = new ArrayList<Vector>();
//		Vector playerToTreasure = treasurePos.sub(player.getPosition());
//		Vector midPoint = player.getPosition().plus(playerToTreasure.multiply(0.5));
//		playerToTreasure = playerToTreasure.plus(new Vector(10,10));
//		int maxX, minX, maxY, minY;
//		
//		maxX = midPoint.x+Math.abs(playerToTreasure.x);
//		minX = midPoint.x-Math.abs(playerToTreasure.x);
//		
//		maxY = midPoint.y+Math.abs(playerToTreasure.y);
//		minY = midPoint.y-Math.abs(playerToTreasure.y);
//		
//		int area = (maxX-minX)*(maxY-minY);
//
//		//for a certain number of times, and stop if the goblin density gets high enough
//		//Wait, you actually read this? It's all commented. There's nothing here, Jim.
//		for(int i=0;i<goblinDensity*area*2&&!(goblinPosArray.size() <goblinDensity*area);i++) {
//			int x,y;
//			x = minX + RandomGod.nextInt(maxX-minX);
//			y = minY + RandomGod.nextInt(maxY-minY);
//			Vector newGoblin = new Vector(x,y);
//			
//			//if too close to player
//			if(newGoblin.dist(player.getPosition())<4) {
//				continue;
//			}
//			
//			//if too close to treasure
//			if(newGoblin.dist(treasurePos)<6) {
//				continue;
//			}
//			
//			//if too close to another goblin
//			if(goblinDistance(newGoblin)<5) {
//				continue;
//			}
//			goblinPosArray.add(newGoblin);
//		}
//	}
	
	
//	private double goblinDistance(Vector v) {
//		double closest=Double.MAX_VALUE;
//		for(Vector g:goblinPosArray) {
//			closest = Math.min(closest, v.dist(g));
//		}
//		return closest;
//	}
//	
//	private double goblinDistancePlayer() {
//		return goblinDistance(player.getPosition());
//	}
//
//	public boolean killedByGoblin() {
//		return !alive;
//	}
//	
	
//	public double fuzzyCompass() {
//		//adds goblin jam to the compass
//		if(goblinDistancePlayer()==1) {
//			return Double.MAX_VALUE*(RandomGod.nextInt(2)*2-1);
//		}else if(goblinDistancePlayer()<=3) {
//			return getDistanceToTreasure()+(((float)RandomGod.nextInt(7)+3)*(RandomGod.nextInt(2)*2-1));
//		}else {
//			return getDistanceToTreasure();
//		}
//	}
//	
//	private Vector getClosestGoblin() {
//		double closest=Double.MAX_VALUE;
//		Vector goblin=new Vector(-1,-1);
//		for(Vector g:goblinPosArray) {
//			closest = Math.min(closest, player.getPosition().dist(g));
//			goblin = g;
//		}
//		return goblin;
//	}
//	
	public String compassDirection() {
		double ang = treasurePos.sub(player.getPosition()).getAngle();
		final double pi = Math.PI;
		if(ang<pi/8||ang>(2*pi-pi/8)) {
			return "N";
		}
		int dir=1;
		while(!(ang>dir*(pi/4)-pi/8 && ang<(dir)*(pi/4)+pi/8)) {
			dir++;
		}
		switch(dir) {
		case 1:
			return "NE";
		case 2:
			return "E";
		case 3:
			return "SE";
		case 4:
			return "S";
		case 5:
			return "SW";
		case 6:
			return "W";
		case 7:
			return "NW";
		}
		return "It's broken";
	}
	private Vector getVectorToTreasure() {
		return treasurePos.sub(player.getPosition());
	}
	
	public double getDistanceToTreasure() {
		return player.getPosition().dist(treasurePos);
	}
	
	public boolean foundTreasure() {
		return getDistanceToTreasure()==0;
	}
	
	public void movePlayer(Vector displacement) {
		player.movePlayer(displacement);
		//goblin encounter
//		if(goblinDistancePlayer()==0) {
//			goblinPosArray.remove(getClosestGoblin());
//			killedGoblinFlag=true;
//		}
	}
	
//	public boolean goblinSlain() {
//		if(killedGoblinFlag) {
//			killedGoblinFlag = false;
//			return true;
//		}
//		return false;
//	}
	
	public void goNorth() {
		movePlayer(new Vector(0,1));
	}
	
	public void goSouth() {
		movePlayer(new Vector(0,-1));
	}
	
	public void goWest() {
		movePlayer(new Vector(-1,0));
	}
	
	public void goEast() {
		movePlayer(new Vector(1,0));
	}
}
