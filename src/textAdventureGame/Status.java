package textAdventureGame;

import maths.RandomGod;

public class Status {
	private int health;
	private int maxHealth;
	
	private int strength;
	private int charisma;
	private int intelligence;
	private int dexterity;
	Status(){
		this.maxHealth=5+RandomGod.nextInt(6);
		this.health=this.maxHealth;
		this.strength=1+RandomGod.nextInt(10);
		this.charisma=1+RandomGod.nextInt(10);
		this.intelligence=1+RandomGod.nextInt(10);
		this.dexterity=1+RandomGod.nextInt(10);
	}
	Status(int maxHP, int strength, int charisma, int intelligence, int dexterity){
		this.health=maxHP;
		this.maxHealth=maxHP;
		this.strength=strength;
		this.charisma=charisma;
		this.intelligence=intelligence;
		this.dexterity=dexterity;
	}
	public void takeDamage(int damage) {
		if(damage>0) {
			health=Math.max(0,health-damage);
		}
	}
	public int getHealth() {
		return this.health;
	}
	public int getMaxHealth() {
		return this.maxHealth;
	}
	public int getStrength() {
		return this.strength;
	}

	public int getCharisma() {
		return this.charisma;
	}
	
	public int getIntelligence() {
		return this.intelligence;
	}
	
	public int getDexterity() {
		return this.dexterity;
	}
	
	public void levelUpStr() {
		this.strength = Math.min(20, this.strength+1);
	}
	public void levelUpChr() {
		this.charisma = Math.min(20, this.charisma+1);
	}
	public void levelUpInt() {
		this.intelligence = Math.min(20, this.intelligence+1);
	}
	public void levelUpDex() {
		this.dexterity = Math.min(20, this.dexterity+1);
	}
	public void levelUpMaxHP() {
		this.maxHealth = this.maxHealth+1;
	}
	
	
	public String healthStatus() {
		return health + "/" + maxHealth;
	}
	public String status() {
		return (healthStatus()+"\nStrength: " + strength+"\nCharisma: " + charisma+"\nIntelligence: " + intelligence+"\nDexterity: " + dexterity);
	}
}
