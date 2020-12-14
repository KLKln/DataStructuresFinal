import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * Creates a Dice class
 * @author Kelly Klein
 * @version 1.0
 */
public class Dice {

	private int numOfSides;
	private int numOfDice;
	private int faceValue;
	private int total;
	
	Queue<Integer> pq = new PriorityQueue<Integer>();
	
	public int getNumOfSides() {
		return numOfSides;
	}

	public void setNumOfSides(int numOfSides) {
		this.numOfSides = numOfSides;
	}

	public int getNumOfDice() {
		return numOfDice;
	}

	public void setNumOfDice(int numOfDice) {
		this.numOfDice = numOfDice;
	}

	public int getFaceValue() {
		return faceValue;

	}
	public void setFaceValue(int faceValue) {
		this.faceValue = faceValue;
	}
	
	public int getTotal() {
		return total;
	}
	
	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * Constructs the Dice class
	 * @param numberOfSides - takes number of sides on a die
	 */
	public Dice(int numberOfSides) {

		numOfSides = numberOfSides;

		Random rand = new Random();
		faceValue = rand.nextInt(numOfSides - 1) + 1;
	}

	/**
	 * Constructs the dice class
	 * @param numberOfDice - total number of dice
	 * @param numberOfSides - takes number of sides on a die
	 */
	public Dice(int numberOfDice, int numberOfSides) {
		numOfDice = numberOfDice;
		numOfSides = numberOfSides;

		Random rand = new Random();
		faceValue = rand.nextInt(numOfSides - 1) + 1;

	}

	/**
	 * "Rolls" the dice
	 * @return total of the dice rolled
	 */
	public int rollDice() {
		
		int valueTotal = 0;

		Random rand = new Random();
		for(int i = 0; i <= numOfDice; i++) {
			faceValue = rand.nextInt(numOfSides - 1) + 1;
			valueTotal = valueTotal + faceValue;
		}
		setTotal(valueTotal);
		
		pq.add(valueTotal);

		return total;
	}

	/**
	 * rollStats method specifically for three 6 sided dice for stats rolling
	 * @return total
	 */
	public int rollStats() {
		Dice statsDice = new Dice(3, 6);
		total = statsDice.rollDice();
		return total;

	}
	
	/**
	 * method to undo a roll in the dice roller
	 * @return pq.poll()
	 */
	public int UndoRoll() {
		
		return pq.poll();
		
	}
	
}
