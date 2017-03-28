/**
 * Created by marble on 3/26/17.
 */
import org.junit.*;
import static org.junit.Assert.*;

// TODO: Auto-generated Javadoc
/**
 * The Class DoubleLinkedListTest.
 */
public class DoubleLinkedListTest {
    
    /** The test size. */
    private final int TEST_SIZE = 10;
    
    /** The my counter. */
    Counter myCounter;
    
    /** The double linked list. */
    DoubleLinkedList<Integer> doubleLinkedList;
    
    /** The temp. */
    Elem<Integer> temp;
    
    /** The excpetion handled. */
    boolean excpetion_handled = false;

    /**
     * Setup.
     */
    @Before
    public void setup(){
        excpetion_handled = false;
        doubleLinkedList = new DoubleLinkedList<>();
        /* fill list with dummy data */
        for(int i = 0; i < TEST_SIZE; i++) {
            temp = new Elem<Integer>();
            temp.setData(i);
            doubleLinkedList.insert(new Pos(i), temp);
        }
    }

    /**
     * Test double linked list insert.
     */
    @Test
    public void testDoubleLinkedListInsert(){
        /* check first, middle and last element */
        assertEquals(doubleLinkedList.retrieve(new Pos(0)).getData(), (Integer)(0));
        assertEquals(doubleLinkedList.retrieve(new Pos(TEST_SIZE/2)).getData(), (Integer)(TEST_SIZE/2));
        assertEquals(doubleLinkedList.retrieve(new Pos(TEST_SIZE-1)).getData(), (Integer)(TEST_SIZE-1));
        /* try to insert after end */
        try {
            temp = new Elem<Integer>();
            temp.setData(TEST_SIZE+1);
            doubleLinkedList.insert(new Pos(TEST_SIZE+1), temp);
        } catch(IndexOutOfBoundsException e){
            excpetion_handled = true;
        }
        assertTrue(excpetion_handled);
        /* try to insert before start */
        try {
            temp = new Elem<Integer>();
            temp.setData(-1);
            doubleLinkedList.insert(new Pos(-1), temp);
        } catch(IndexOutOfBoundsException e){
            excpetion_handled = true;
        }
        assertTrue(excpetion_handled);
    }

    /**
     * Test double linked list delete.
     */
    @Test
    public void testDoubleLinkedListDelete(){
        /* delete first, middle and last element and check size */
        doubleLinkedList.delete(new Pos(TEST_SIZE-1));
        doubleLinkedList.delete(new Pos(TEST_SIZE/2));
        doubleLinkedList.delete(new Pos(0));
        /* try to delete two after end */
        try {
            doubleLinkedList.delete(new Pos(TEST_SIZE));
        } catch(IndexOutOfBoundsException e){
            excpetion_handled = true;
        }
        assertTrue(excpetion_handled);
        /* try to delete before start */
        try {
            doubleLinkedList.delete(new Pos(-1));
        } catch(IndexOutOfBoundsException e){
            excpetion_handled = true;
        }
        assertTrue(excpetion_handled);
    }

    /**
     * Test double linked list find.
     */
    @Test
    public void testDoubleLinkedListFind(){
        Elem<Integer> temp= new Elem<Integer>();
        try {
            temp.setData(0);
            assertEquals(0, doubleLinkedList.find(temp).getPos());
            temp.setData(TEST_SIZE/2);
            assertEquals(TEST_SIZE/2, doubleLinkedList.find(temp).getPos());
            temp.setData(TEST_SIZE-1);
            assertEquals(TEST_SIZE-1, doubleLinkedList.find(temp).getPos());
        } catch(ElementNotFoundException e){
            excpetion_handled = true;
        }
        assertFalse(excpetion_handled);
        /* try to find non existing element */
        try {
            temp.setData(Integer.MIN_VALUE);
            doubleLinkedList.find(temp);
        } catch(ElementNotFoundException e){
            excpetion_handled = true;
        }
        assertTrue(excpetion_handled);
    }
}
