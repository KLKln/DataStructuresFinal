/**
 * creates a character class for dungeons and dragons
 * @author Kelly Klein
 * @version 1.0
 */
public class Character {
	private String name;

	private int strength;

	private int intelligence;

	private int dexterity;

	private int wisdom;

	private int charisma;

	private int constitution;

	private int hitpoints;

	/**
	 * Constructs the Character Class
	 * @param strength
	 * @param intelligence
	 * @param dexterity
	 * @param wisdom
	 * @param charisma
	 * @param constitution
	 * @param hitpoints
	 */
	public Character(int strength, int intelligence, int dexterity, int wisdom, int charisma, int constitution,
			int hitpoints) {
		super();
		this.strength = strength;
		this.intelligence = intelligence;
		this.dexterity = dexterity;
		this.wisdom = wisdom;
		this.charisma = charisma;
		this.constitution = constitution;
		this.hitpoints = this.modifier(this.getConstitution()) + 10;
	}

	/**
	 * method to calculate hitpoints which takes a base of constitution
	 * @param input - user input
	 * @return result
	 */
	private int modifier(int input) {
		int result = input - 10;
		result = Math.floorDiv(result, 2);
		return result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	public int getWisdom() {
		return wisdom;
	}

	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
	}

	public int getCharisma() {
		return charisma;
	}

	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}

	public int getConstitution() {
		return constitution;
	}

	public void setConstitution(int constitution) {
		this.constitution = constitution;
	}

	public int getHitpoints() {
		return hitpoints;
	}

	public void setHitpoints(int hitpoints) {
		this.hitpoints = hitpoints;
	}

	@Override
	public String toString() {
		return "Character [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
