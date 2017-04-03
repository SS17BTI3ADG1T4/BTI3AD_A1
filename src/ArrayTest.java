import static org.junit.Assert.*;

import org.junit.Test;

/**
 * The Class SingleLinkedListTest.
 */
public class ArrayTest {

	/**
	 * Inserts an Element in a empty List.
	 *
	 * @throws ElementNotFoundException
	 *             the element not found exception
	 */
	@Test
	public void testInsertInEmptyList() throws ElementNotFoundException {
		Array<Integer> List = new Array<Integer>(2, 2);
		assertEquals(List.size(), 0);
		List.insert(new Pos(0), new Elem<Integer>(0));
		assertEquals(List.size(), 1);
	}

	/**
	 * Inserts an ELement in a filled List at a position.
	 *
	 * @throws ElementNotFoundException
	 *             the element not found exception
	 */
	@Test
	public void testInsertInFilledListAtPosition() throws ElementNotFoundException {
		Array<Integer> List = new Array<Integer>(2, 2);
		for (int i = 0; i < 10; i++) {
			List.insert(new Pos(i), new Elem<Integer>(i));
		}
		int oldSize = List.size();

		List.insert(new Pos(2), new Elem<Integer>(20));
		System.out.println(List.size());
		assertEquals(oldSize + 1, List.size());

	}

	/**
	 * Try delete by pos if pos not exists.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testDeletePosIfPosNotExists() {
		Array<Integer> List = new Array<Integer>(2, 2);
		List.delete(new Pos(10));
	}

	/**
	 * Try delete with Pos if List is empty.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testDeleteIfListIsEmpty() {
		Array<Integer> List = new Array<Integer>(2, 2);
		List.delete(new Pos(0));
	}

	/**
	 * Try to delete at a Pos by an List with an Single Element.
	 *
	 * @throws ElementNotFoundException
	 *             the element not found exception
	 */
	@Test
	public void testDeleteAtAnListWithSingleElement() throws ElementNotFoundException {
		Array<Integer> List = new Array<Integer>(2, 2);
		List.insert(new Pos(0), new Elem<Integer>(20));
		assertEquals(List.retrieve(new Pos(0)), new Elem<Integer>(20));
		List.delete(new Pos(0));
		assertEquals(List.size(), 0);
	}

	/**
	 * Try to Delete an Element with a key .
	 *
	 * @throws ElementNotFoundException
	 *             the element not found exception
	 */
	@Test
	public void testDeleteELemWithKey() throws ElementNotFoundException {
		Array<Integer> List = new Array<Integer>(2, 2);
		List.insert(new Pos(0), new Elem<Integer>(0));
		List.insert(new Pos(1), new Elem<Integer>(1));
		List.insert(new Pos(2), new Elem<Integer>(2));
		List.insert(new Pos(3), new Elem<Integer>(3));
		assertEquals(List.size(), 4);
		assertEquals(List.retrieve(new Pos(2)), new Elem<Integer>(2));
		List.delete(new Elem<Integer>(2));
		assertEquals(List.size(), 3);
		assertEquals(List.retrieve(new Pos(2)), new Elem<Integer>(3));
	}

	/**
	 * Try to Delete an Element with a not existing key .
	 *
	 * @throws ElementNotFoundException
	 *             the element not found exception
	 */
	@Test(expected = ElementNotFoundException.class)
	public void testDeleteELemWithNotExistingKey() throws ElementNotFoundException {
		Array<Integer> List = new Array<Integer>(2, 2);
		List.delete(new Elem<Integer>(0));

	}

	/**
	 * Find a single Pos in List.
	 *
	 * @throws ElementNotFoundException
	 *             the element not found exception
	 */
	@Test
	public void testFindPosinList() throws ElementNotFoundException {
		Array<Integer> List = new Array<Integer>(2, 2);
		List.insert(new Pos(0), new Elem<Integer>(0));
		List.insert(new Pos(1), new Elem<Integer>(1));
		List.insert(new Pos(2), new Elem<Integer>(2));
		List.insert(new Pos(3), new Elem<Integer>(3));
		assertEquals(List.find(new Elem<Integer>(2)), new Pos(2));
		assertEquals(List.find(new Elem<Integer>(0)), new Pos(0));
		assertEquals(List.find(new Elem<Integer>(3)), new Pos(3));
	}

	/**
	 * Find a Pos of an not existing Element.
	 * 
	 * @throws ElementNotFoundException
	 */

	@Test(expected = ElementNotFoundException.class)
	public void testFindPosNotInList() throws ElementNotFoundException {
		Array<Integer> List = new Array<Integer>(2, 2);
		assertEquals(List.find(new Elem<Integer>(0)), new Pos(0));
	}

	/**
	 * Retrieve an Element by position List has Element.
	 *
	 * @throws ElementNotFoundException
	 *             the element not found exception
	 */
	@Test
	public void testRetrieve() throws ElementNotFoundException {
		Array<Integer> List = new Array<Integer>(2, 2);
		List.insert(new Pos(0), new Elem<Integer>(0));
		List.insert(new Pos(1), new Elem<Integer>(1));
		List.insert(new Pos(2), new Elem<Integer>(2));
		List.insert(new Pos(3), new Elem<Integer>(3));
		assertEquals(List.retrieve(new Pos(0)), new Elem<Integer>(0));
		assertEquals(List.retrieve(new Pos(3)), new Elem<Integer>(3));
	}

	/**
	 * Retrieve an Element by position List has no Element.
	 *
	 * @throws ElementNotFoundException
	 *             the element not found exception
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRetrieveByNotExisitingPosition() throws ElementNotFoundException {
		Array<Integer> List = new Array<Integer>(2, 2);
		assertEquals(List.retrieve(new Pos(3)), new Elem<Integer>(3));
	}

	/**
	 * Tries to concatenate 2 filled Lists.
	 *
	 * @throws ElementNotFoundException
	 *             the element not found exception
	 */
	@Test
	public void testConcatTwoFilledLists() throws ElementNotFoundException {
		Array<Integer> List = new Array<Integer>(2, 2);
		Array<Integer> List2 = new Array<Integer>(2, 2);
		List.insert(new Pos(0), new Elem<Integer>(0));
		List2.insert(new Pos(0), new Elem<Integer>(10));
		List2.insert(new Pos(1), new Elem<Integer>(20));
		int size = List.size();
		int size2 = List2.size();
		List.concat(List2);
		assertEquals(size+size2, List.size());
		assertEquals(List.retrieve(new Pos(2)), new Elem<Integer>(20));
	}

	/**
	 * Tries to concatenate a empty List and a filled List2.
	 *
	 * @throws ElementNotFoundException
	 *             the element not found exception
	 */
	@Test
	public void testConcatEmptyListWithFilledList() throws ElementNotFoundException {
		Array<Integer> List = new Array<Integer>(2, 2);
		Array<Integer> List2 = new Array<Integer>(2, 2);
		List2.insert(new Pos(0), new Elem<Integer>(10));
		List2.insert(new Pos(1), new Elem<Integer>(20));
		int size = List.size();
		int size2 = List2.size();
		List.concat(List2);
		assertEquals(size+size2, List.size());
		assertEquals(List.retrieve(new Pos(1)), new Elem<Integer>(20));
	}
	/**
	 * Tries to concatenate a filled List and a empty List2.
	 *
	 * @throws NullPointerException
	 *             
	 */
	@Test(expected = NullPointerException.class)
	public void testConcatFilledListWithAnEmptyList() throws NullPointerException {
		Array<Integer> List = new Array<Integer>(2, 2);
		Array<Integer> List2 = new Array<Integer>(2, 2);
		List.insert(new Pos(0), new Elem<Integer>(10));
		List.insert(new Pos(1), new Elem<Integer>(20));
		List.concat(List2);

	}

	/**
	 * Size of Empty List.
	 */
	@Test
	public void testSizeOfEmptyList() {
		Array<Integer> List = new Array<Integer>(2, 2);
		assertEquals(List.size(), 0);
	}

	/**
	 * Size of Filled List.
	 *
	 * @throws ElementNotFoundException
	 *             the element not found exception
	 */
	@Test
	public void testSize2() throws ElementNotFoundException {
		Array<Integer> List = new Array<Integer>(2, 2);
		List.insert(new Pos(0), new Elem<Integer>(20));
		assertEquals(List.size(), 1);
	}
}
