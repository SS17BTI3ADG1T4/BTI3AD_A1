/**
 * Diese Klasse stellt eine Liste in einem Array dar.
 * 
 * @author Nils Eggebrecht
 *
 */

public class Array<T> implements OwnList<T> {

	private final int K;
	private int size;
	private Elem<T>[] array;
	protected Counter counter;

	/**
	 * Konstruktor
	 */

	@SuppressWarnings("unchecked")
	public Array(int K, int length) {
		if(K<=1){
			this.K = 1;
		}
		else {
		this.K = K;	
		}
		this.size = 0;
		this.array = new Elem[length];
		this.counter = new Counter();
	}

	public Array(int K, int length, Counter counter) {
		this(K, length);
		this.counter = counter;
	}
	/*
	 * Getter
	 * 
	 */
	// @SuppressWarnings("unchecked")
	public Object[] getArray() {
		return this.array;
	}

	public Counter getCounter() {
		return counter;
	}

	/**
	 * Diese Methode vergrößert das Array um K. (K wird einmalig beim erzeugen
	 * des Objektes gesetzt)
	 */
	@SuppressWarnings("unchecked")
	private void resize(Elem<T>[] array) {
		@SuppressWarnings("rawtypes")
		Elem[] newArray = new Elem[array.length + K];
		counter.counterUp(2); // Array erzeugen + laenge berechnen
		System.arraycopy(this.array, 0, newArray, 0, array.length);
		counter.counterUp(array.length);
		this.array = newArray;
	}

	/**
	 * Diese Methode fügt an der Pos, ein Elem<T> ein.
	 */
	@Override
	public void insert(Pos insertPos, Elem<T> insertElem) throws IndexOutOfBoundsException {
		if (insertPos.getPos() >= 0 && insertPos.getPos() <= size && insertElem.getData() != null) {
			if (size == array.length) {
				resize(array);
				counter.counterUp(1);
			}
			if (array[insertPos.getPos()] != null) {
				counter.counterUp(1);
				for (int i = size; i > insertPos.getPos(); i--) {
					array[i] = array[i - 1];
					counter.counterUp(1);
				}
			}
			array[insertPos.getPos()] = insertElem;
			size++;
			counter.counterUp(2);
		} else {
			throw new IndexOutOfBoundsException(
					"Element ist null oder die Position ist nicht im gueltigern Bereich (von 0 bis size)");
		}

	}

	/**
	 * Diese Methode löscht an der Pos, ein Elem<T>.
	 */
	@Override
	public void delete(Pos deletePos) throws IndexOutOfBoundsException {
		if (deletePos.getPos() >= 0 && deletePos.getPos() < size) {
			counter.counterUp(1);
			for (int i = deletePos.getPos(); i < size - 1; i++) {
				array[i] = array[i + 1];
				counter.counterUp(1);
			}
			array[size - 1] = null;
			size--;
			counter.counterUp(2);
		} else {
			throw new IndexOutOfBoundsException(
					"Element ist null oder die Position ist nicht im gueltigern Bereich (von 0 bis size)");
		}
	}

	@Override
	public void delete(Elem<T> key) throws IndexOutOfBoundsException,ElementNotFoundException {
		delete(find(key));
	}

	/**
	 * Diese Methode sucht nach einem Elem<T> und gibt die Pos von dem Element
	 * aus.
	 */
	@Override
	public Pos find(Elem<T> findElem) throws ElementNotFoundException{
		Pos position = new Pos(-1);
		for (int i = 0; i < size; i++) {
			counter.counterUp(1); // i erhoehen
			if (array[i].equals(findElem)) {
				counter.counterUp(1);
				position.set(i);
				return position;
			}
		}
		throw new ElementNotFoundException();
	}

	/**
	 * Diese Methode liefert den Inhalt an der Stelle der gewünschten Position
	 * aus.
	 */

	@Override
	public Elem<T> retrieve(Pos retrievePos) throws IndexOutOfBoundsException {
		if (retrievePos.getPos() >= 0 && retrievePos.getPos() < size) {
			counter.counterUp(1);
			return (Elem<T>) array[retrievePos.getPos()];
		} else {
			throw new IndexOutOfBoundsException(
					"Element ist null oder die Position ist nicht im gueltigern Bereich (von 0 bis size)");
		}
	}

	/**
	 * Diese Methode hängt den Inhalt einer OwnList<T> an eine andere
	 * Ownlist<T>.
	 */
	@Override
	public void concat(OwnList<T> otherlist) {
		if (otherlist != null && otherlist.size() != 0) {
			int newsize = size + otherlist.size();
			counter.counterUp(2);
			while (newsize > array.length) {
				resize(this.array);
			}
			System.arraycopy(((Array<T>) otherlist).array, 0, array, size, otherlist.size());
			counter.counterUp(otherlist.size() + 1);
			size = newsize;

		} else {
			throw new NullPointerException();
		}
	}

	@Override
	public int size() {
		counter.counterUp(1);
		return this.size;
	}

	public static void main(String[] args) {


		System.out.println("Maintest");

		Array<Integer> arr = new Array<Integer>(2, 2);
		Array<Integer> arr1 = new Array<Integer>(2, 2);

		arr.insert(new Pos(0), new Elem<Integer>(0));
		arr.insert(new Pos(1), new Elem<Integer>(1));
		arr.insert(new Pos(2), new Elem<Integer>(2));
		arr.insert(new Pos(3), new Elem<Integer>(3));
		arr.insert(new Pos(4), new Elem<Integer>(4));

		arr1.insert(new Pos(0), new Elem<Integer>(0));
		arr1.insert(new Pos(1), new Elem<Integer>(1));
		arr1.insert(new Pos(2), new Elem<Integer>(2));
		arr1.insert(new Pos(3), new Elem<Integer>(3));
		arr1.insert(new Pos(4), new Elem<Integer>(4));
		
		arr.concat(arr1);
		System.out.println(new Pos(5).getPos());
		System.out.println(arr.size);
		

		arr.delete(new Pos(0));

	}
	
}