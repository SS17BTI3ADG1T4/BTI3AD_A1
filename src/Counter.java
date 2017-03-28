// TODO: Auto-generated Javadoc
/**
 * The Class Counter.
 *
 * @author Nils Eggebrecht
 * @class der Counter ist für die Aufwandsanalyse.
 */
public class Counter {
	
	/** counter ist der Zaehlwert fuer den Counter. */
	private int counter;

	/**
	 * Instantiates a new counter.
	 */
	// construtor
	public Counter() {
		counter = 0;
	}

	/**
	 * Gets the counter.
	 *
	 * @return the counter
	 */
	public int getCounter() {
		return counter;
	}

	/**
	 * Sets the counter.
	 *
	 * @param counter the new counter
	 */
	public void setCounter(int counter) {
		this.counter = counter;
	}

	/**
	 * Counter up.
	 *
	 * @param add            gibt die Zahl an, um wie viel hochgezaehlt werden soll.
	 */
	public void counterUp(int add) {
		this.counter = counter + add;
	}

}
