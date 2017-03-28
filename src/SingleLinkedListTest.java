import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class SingleLinkedListTest.
 */
public class SingleLinkedListTest {
	
	/**
	 * Adds an ELement in a empty List.
	 *
	 * @throws ElementNotFoundException the element not found exception
	 */
	@Test
	public void testAdd() throws ElementNotFoundException {
		SingleLinkedList List = new SingleLinkedList<>();
		Elem elem = new Elem("Test");
		List.add(elem);
		assertEquals(List.size(), 1);
	}

	/**
	 * Inserts an ELement in a empty List.
	 *
	 * @throws ElementNotFoundException the element not found exception
	 */
	@Test
	public void testInsert() throws ElementNotFoundException {
		SingleLinkedList List = new SingleLinkedList<>();
		Elem elem = new Elem("Test");
		List.insert(new Pos(0), elem);
		assertEquals(List.find(elem).getPos(), 0);
	}
	
	/**
	 * Inserts an ELement in a filled List at a position.
	 *
	 * @throws ElementNotFoundException the element not found exception
	 */
	@Test
	public void testInsert2() throws ElementNotFoundException {
		SingleLinkedList List = new SingleLinkedList<>();
		for(int i =0; i<10; i++){
			List.add(new Elem(String.valueOf(i)));
		}
		int oldSize=List.size();
		Elem elem= new Elem("Test");
		List.insert(new Pos(5), elem);
		System.out.println(List.size());
		assertEquals(oldSize+1, List.size());
	}

	/**
	 * Try delete by pos if pos not exists.
	 */
	@Test(expected =IndexOutOfBoundsException.class)
	public void testDeletePos() {
		SingleLinkedList List = new SingleLinkedList<>();
		List.delete(new Pos(10));
		
	}
	
	/**
	 * Try delete if List is empty.
	 */
	@Test(expected =IndexOutOfBoundsException.class)
	public void testDeletePos2(){
		SingleLinkedList List = new SingleLinkedList<>();
		List.delete(new Pos(0));
		
	}
	
	/**
	 * Try to delete a List with an Single Element.
	 *
	 * @throws ElementNotFoundException the element not found exception
	 */
	@Test
	public void testDeletePos3() throws ElementNotFoundException{
		SingleLinkedList List = new SingleLinkedList<>();
		List.add(new Elem("test"));
		List.delete(new Pos(0));
		assertEquals(List.size(), 0);
	}

	/**
	 * Try to Delete an Element with a key .
	 *
	 * @throws ElementNotFoundException the element not found exception
	 */
	@Test
	public void testDeleteT() throws ElementNotFoundException {
		SingleLinkedList List = new SingleLinkedList<>();
		Elem elem = new Elem("Test");
		List.add(elem);
		List.delete(elem);
		assertEquals(List.size(), 0);
	}
	
	/**
	 * Try to Delete an Element with a not existing key .
	 *
	 * @throws ElementNotFoundException the element not found exception
	 */
	@Test(expected = ElementNotFoundException.class)
	public void testDeleteT2() throws ElementNotFoundException {
		SingleLinkedList List = new SingleLinkedList<>();
		List.delete(new Elem());
		
	}

	
	/**
	 * Find a single Pos in List with one ELem.
	 *
	 * @throws ElementNotFoundException the element not found exception
	 */
	@Test
	public void testFind() throws ElementNotFoundException {
		SingleLinkedList List = new SingleLinkedList<>();
		Elem elem = new Elem("Test");
		System.out.println("find test");
		List.add(elem);		
		Pos pos = new Pos(-100);
		pos=List.find(elem);			
		assertEquals(pos.getPos(), 0);
	}

	/**
	 * Find a Pos of an not existing Element.
	 */
	@Test
	public void testFind2()   {
		SingleLinkedList List = new SingleLinkedList<>();
		Elem elem = new Elem("Test");
		
		Pos pos = List.find(elem);
		assertEquals(pos.getPos(), -1);
	}
	
	/**
	 * Retrieve an Element by position
	 * List has Element.
	 *
	 * @throws ElementNotFoundException the element not found exception
	 */
	@Test
	public void testRetrieve() throws ElementNotFoundException {
		SingleLinkedList List = new SingleLinkedList<>();
		Elem elem = new Elem("Test");
		List.add(elem);
		Elem elem2 = List.retrieve(new Pos(0));
		assertEquals("Test", elem2.getData());
	}
	
	/**
	 * Retrieve an Element by position
	 * List has no Element.
	 *
	 * @throws ElementNotFoundException the element not found exception
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRetrieve2() throws ElementNotFoundException {
		SingleLinkedList List = new SingleLinkedList<>();
		Elem elem2 = List.retrieve(new Pos(0));
		
	}

	
	/**
	 * Tries to concatenate a filled List and a Empty List2.
	 *
	 * @throws ElementNotFoundException the element not found exception
	 */
	@Test
	public void testConcatSingleLinkedListOfT2() throws ElementNotFoundException {
		SingleLinkedList List = new SingleLinkedList<>();
		Elem elem= new Elem<>("Test");
		List.add(elem);
		SingleLinkedList List2 = new SingleLinkedList<>();
		int size = List.size();
		List.concat(List2);
		assertEquals(size, List.size());
	}
	
	/**
	 * Tries to concatenate a empty List and a filled List2.
	 *
	 * @throws ElementNotFoundException the element not found exception
	 */
	@Test
	public void testConcatSingleLinkedListOfT3() throws ElementNotFoundException {
		SingleLinkedList List = new SingleLinkedList<>();
		Elem elem= new Elem<>("Test");
		SingleLinkedList List2 = new SingleLinkedList<>();
		List2.add(elem);	
		int size = List2.size();
		List.concat(List2);
		assertEquals(size, List.size());
	}
	
	/**
	 * Tries to concatenate 2 filled Lists.
	 *
	 * @throws ElementNotFoundException the element not found exception
	 */
	@Test
	public void testConcatSingleLinkedListOfT4() throws ElementNotFoundException {
		SingleLinkedList List = new SingleLinkedList<>();
		SingleLinkedList List2 = new SingleLinkedList<>();
		for(int i =0; i<10; i++){
			List.add(new Elem("liste1:"+i));
			List2.add(new Elem("liste2:"+i));
		}
		System.out.println(List.size());
		System.out.println(List2.size());
		List.concat(List2);
		assertEquals(20, List.size());
	}

	/**
	 * Size of Empty List.
	 */
	@Test
	public void testSize() {
		SingleLinkedList List = new SingleLinkedList<>();
		assertEquals(List.size(), 0);
	}
	
	/**
	 * Size of Filled List.
	 *
	 * @throws ElementNotFoundException the element not found exception
	 */
	@Test
	public void testSize2() throws ElementNotFoundException {
		SingleLinkedList List = new SingleLinkedList<>();
		List.add(new Elem());
		assertEquals(List.size(), 1);
	}
	
	/**
	 * Gets the end elem.
	 *
	 * @return the end elem
	 */
	@Test
	public void getEndElem(){
		SingleLinkedList List = new SingleLinkedList();
		System.out.println("Endelem: "+List.getEndElem());
	}
	
	
	

}
