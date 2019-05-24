package maths;

import java.util.Random;

//Whenever someone gets mad at the RNG god, this is who they're referring to.
public class RandomGod {
	private static Random rand = new Random();
	public static int nextInt(int arg0) {
		return rand.nextInt(arg0);
	}
	public static float nextFloat(){
		return rand.nextFloat();
	}
	public static boolean nextBoolean(){
		return rand.nextBoolean();
	}
}
