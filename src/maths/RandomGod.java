package maths;

import java.util.Random;

public class RandomGod {
	static Random rand = new Random();
	static int randInt(int arg0) {
		return rand.nextInt(arg0);
	}
}
