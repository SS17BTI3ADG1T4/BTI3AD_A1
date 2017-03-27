/**
 * Created by marble on 3/26/17.
 */
public class DoubleLinkedList<T> implements OwnList{
    private Counter  counter = null;
    protected Elem<T> headDummy = null;
    protected Elem<T> lastDummy = null;
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
        /* attach insert element after predecessor of reference element */
        insertElem.setPrev(refElem.getPrev());
        refElem.getPrev().setNext(insertElem);
        /* attach reference element after insert element */
        refElem.setPrev(insertElem);
        insertElem.setNext(refElem);
        size++;
    }

    @Override
    public void delete(Pos deletePos) throws IndexOutOfBoundsException {
        Elem<T> refElem = deletePos.getRefElem();
        if(refElem == null) {
            refElem = retrieve(deletePos);
        }
        refElem.getPrev().setNext(refElem.getNext());
        refElem.getNext().setPrev(refElem.getPrev());
        size--;
    }

    @Override
    public Pos find(Elem findElem) throws ElementNotFoundException {
        Pos resultPos = new Pos(headDummy);
        lastDummy.setData((T)findElem.getData());
        while(!resultPos.getRefElem().equals(findElem)) {
            resultPos.setRefElem(resultPos.getRefElem().getNext());
            resultPos.set(resultPos.getPos()+1);
        }
        if(resultPos.getRefElem() == lastDummy) {
            lastDummy.setData(null);
            throw new ElementNotFoundException();
        }
        lastDummy.setData(null);
        return resultPos;
    }

    @Override
    public Elem retrieve(Pos retrievePos) throws IndexOutOfBoundsException {
        Elem<T> result = retrievePos.getRefElem();
        final int pos = retrievePos.getPos();
        if(result == null) {
            if(pos > size || pos < 0){
                throw new IndexOutOfBoundsException();
            }
            result = headDummy.getNext();
            for(int i = 0; i < pos; i++) {
                result = result.getNext();
            }
        }
        return result;
    }

    @Override
    public void concat(OwnList otherList) {
        if (otherList.getClass().equals(this.getClass())) {
            lastDummy.getPrev().setNext(((DoubleLinkedList) otherList).headDummy.getNext());
            headDummy.getNext().setPrev(((DoubleLinkedList) otherList).lastDummy.getPrev());
            lastDummy = ((DoubleLinkedList) otherList).lastDummy;
            size += otherList.size();
        }
        else {
            /* TODO implement */
        }
    }

    @Override
    public int size() {
        return size;
    }

    private void count() {
        if(counter != null){
            counter.counterUp(1);
        }
    }
}
