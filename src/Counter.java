package ADP_1;

/**
 * 
 * @author Nils Eggebrecht
 *
 * @class der Counter ist für die Aufwandsanalyse.
 */
public class Counter {
	/**
	 * counter ist der zaehlwert fuer den Counter
	 */
	private int counter;

	// construtor
	public Counter() {
		counter = 0;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	/**
	 * @param add
	 *            gibt die Zahl an, um wie viel hochgezaehlt werden soll.
	 */
	public void counterUp(int add) {
		this.counter = counter + add;
	}

}
