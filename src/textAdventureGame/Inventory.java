package textAdventureGame;

import java.util.ArrayList;

public class Inventory {
	ArrayList<Item> itemArray;
	public Inventory() {
		itemArray = new ArrayList<Item>();
	}
	public boolean contains(String name) {
		for(Item i:itemArray) {
			if(i.name.equals(name)) {
				return true;
			}
		}
		return false;
	}
}
