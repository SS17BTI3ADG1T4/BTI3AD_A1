
//import static org.junit.Assert.assertEquals;

/**
 * Diese Klasse stellt eine Liste in einem Array dar.
 * 
 * @author Nils Eggebrecht
 *
 */

public class Array<T> implements OwnList<T> {
	// System.out.println(arr.K);
	// public static void main(String[] args) throws IndexOutOfBoundsException {
	//
	// System.out.println("Maintest");
	// Array<Integer> arr = new Array<Integer>(2, 2);
	// // Array<Integer> arr1 = new Array<Integer>(2, 2);
	//
	// System.out.printf("size= %d \n",arr.size);
	// System.out.printf("laenge= %d\n\n",arr.getArray().length);
	//
	// Elem <Integer> element = new Elem<Integer>();
	// Pos pos = new Pos(0);
	// element.setData(6);
	// arr.insert(pos, element);
	// // arr.insert(0,10);
	// System.out.printf("size= %d \n",arr.size);
	// // System.out.printf("laenge= %d\n\n",arr.getArray().length);
	// // arr.insert(0,20);
	// // System.out.printf("size= %d \n",arr.size);
	// // System.out.printf("laenge= %d\n\n",arr.getArray().length);
	// // arr.insert(0,15);
	// // System.out.printf("size= %d \n",arr.size);
	// // System.out.printf("laenge= %d\n\n",arr.getArray().length);
	// // arr.insert(0,30);
	// // System.out.printf("size= %d \n",arr.size);
	// // System.out.printf("laenge= %d\n\n",arr.getArray().length);
	// // arr.insert(0,45);
	// // System.out.printf("size= %d \n",arr.size);
	// // System.out.printf("laenge= %d\n\n",arr.getArray().length);
	// arr.delete(pos);
	// System.out.printf("size= %d \n",arr.size);
	// // System.out.println(arr.find(10));
	// // System.out.println(arr.find(20));
	// // System.out.println(arr.find(15));
	// // System.out.println(arr.find(30));
	// // System.out.println(arr.find(45));
	// // System.out.println();
	// // System.out.println(arr.find(10));
	// // System.out.println(arr.retrieve(0));
	// // arr.delete(0);
	// // System.out.println(arr.find(10));
	// // System.out.println(arr.find(20));
	// // System.out.println(arr.find(15));
	// // System.out.println(arr.find(30));
	// // System.out.println(arr.find(45));
	// // System.out.println(arr.retrieve(0));
	// // System.out.printf("arr size= %d \n", arr.size);
	// // System.out.printf("arr laenge= %d\n\n", arr.getArray().length);
	// // arr.insert(0, 10);
	// // arr.insert(0, 10);
	// // System.out.println(arr.retrieve(0));
	// // System.out.println(arr.retrieve(1));
	// // System.out.printf("arr size= %d \n", arr.size);
	// // System.out.printf("arr laenge= %d\n\n", arr.getArray().length);
	// //
	// // arr1.insert(0, 50);
	// // System.out.println("arr1 elem 0:");
	// // System.out.println(arr1.retrieve(0));
	// //
	// // System.out.printf("arr size= %d \n", arr.size);
	// // System.out.printf("arr laenge= %d\n\n", arr.getArray().length);
	// //
	// // System.out.printf("arr1 size= %d \n", arr1.size);
	// // System.out.printf("arr1 laenge= %d\n\n", arr1.getArray().length);
	// // System.out.println("concat");
	// // arr.concat(arr1);
	// // System.out.printf("arr1 size= %d \n", arr1.size);
	// // System.out.printf("arr1 laenge= %d\n\n", arr1.getArray().length);
	// // System.out.println("arr elem 2:");
	// // System.out.println(arr.retrieve(2));
	// //
	// // System.out.println("arr1 elem 0:");
	// // System.out.println(arr1.retrieve(0));
	// //
	// // System.out.printf("arr size= %d \n", arr.size);
	// // System.out.printf("arr laenge= %d\n\n", arr.getArray().length);
	// // System.out.println();
	// //
	// }

	private final int K;
	private int size;
	private Object[] array;
	protected Counter counter;

	/**
	 * Konstruktor
	 */
	public Array(int K, int length) {
		this.K = K;
		this.size = 0;
		this.array = new Object[length];
		this.counter = new Counter();
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
	private void resize(Object[] array) {
		Object[] newArray = new Object[array.length + K];
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
		if (insertPos.get() >= 0 && insertPos.get() <= size && insertElem.getData() != null) {
			if (size == array.length) {
				resize(array);
				counter.counterUp(1);
			}
			if (array[insertPos.get()] != null) {
				counter.counterUp(1);
				for (int i = size; i > insertPos.get(); i--) {
					array[i] = array[i - 1];
					counter.counterUp(1);
				}
			}
			array[insertPos.get()] = insertElem.getData();
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
		if (deletePos.get() >= 0 && deletePos.get() < size) {
			counter.counterUp(1);
			for (int i = deletePos.get(); i < size - 1; i++) {
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

	/**
	 * Diese Methode sucht nach einem Elem<T> und gibt die Pos von dem Element
	 * aus.
	 */
	@Override
	public Pos find(Elem<T> findElem) {
		Pos position = new Pos(-1);
		for (int i = 0; i < size; i++) {
			counter.counterUp(1); // i erhoehen
			if (array[i].equals(findElem.getData())) {
				counter.counterUp(1);
				position.set(findElem.index);
			}
		}
		return position;
	}

	/**
	 * Diese Methode liefert den Inhalt an der Stelle der gewünschten Position
	 * aus.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Elem<T> retrieve(Pos retrievePos) throws IndexOutOfBoundsException {
		if (retrievePos.get() >= 0 && retrievePos.get() < size) {
			counter.counterUp(1);
			return (Elem<T>) array[retrievePos.get()];
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
}
