/**
 * Created by marble on 3/26/17.
 */
public class DoubleLinkedList<T> implements OwnList{
    private Counter  counter = null;
    private Elem<T> headDummy = null;
    private Elem<T> lastDummy = null;
    private int size = 0;

    DoubleLinkedList() {
        headDummy = new Elem<>();
        lastDummy = new Elem<>();
        headDummy.setNext(lastDummy);
        lastDummy.setPrev(headDummy);
        /* make loops at the end */
        headDummy.setPrev(headDummy);
        lastDummy.setNext(lastDummy);
    }

    DoubleLinkedList(Counter counter) {
        this();
        this.counter = counter;
    }

    @Override
    public void insert(Pos insertPos, Elem insertElem) throws IndexOutOfBoundsException {
        Elem<T> refElem = insertPos.getRefElem();
        if(refElem == null) {
            refElem = retrieve(insertPos);
        }
        insertElem.setNext(refElem.getNext());
        refElem.getNext().setPrev(insertElem);
        insertElem.setPrev(refElem);
        refElem.setNext(insertElem);

    }

    @Override
    public void delete(Pos deletePos) throws IndexOutOfBoundsException {

    }

    @Override
    public Pos find(Elem findElem) throws ElementNotFoundException {
        return null;
    }

    @Override
    public Elem retrieve(Pos retrievePos) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public void concat(OwnList otherList) {

    }

    @Override
    public int size() {
        return 0;
    }
}
