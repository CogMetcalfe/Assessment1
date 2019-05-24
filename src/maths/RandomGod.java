package maths;

import java.util.Random;

public class RandomGod {
	private static Random rand = new Random();
	public static int nextInt(int arg0) {
		return rand.nextInt(arg0);
	}
	public static float nextFloat(){
		return rand.nextFloat();
	}
}
