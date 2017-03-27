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
        count();
        lastDummy = new Elem<>();
        count();
        headDummy.setNext(lastDummy);
        count();
        lastDummy.setPrev(headDummy);
        count();
        /* make loops at the end */
        headDummy.setPrev(headDummy);
        count();
        lastDummy.setNext(lastDummy);
        count();
    }

    DoubleLinkedList(Counter counter) {
        this();
        this.counter = counter;
    }

    @Override
    public void insert(Pos insertPos, Elem insertElem) throws IndexOutOfBoundsException {
        Elem<T> refElem = insertPos.getRefElem();
        count();
        if(refElem == null) {
            refElem = retrieve(insertPos);
            count();
        }
        count();
        /* attach insert element after predecessor of reference element */
        insertElem.setPrev(refElem.getPrev());
        count();
        refElem.getPrev().setNext(insertElem);
        count();
        /* attach reference element after insert element */
        refElem.setPrev(insertElem);
        count();
        insertElem.setNext(refElem);
        count();
        size++;
        count();
    }

    @Override
    public void delete(Pos deletePos) throws IndexOutOfBoundsException {
        Elem<T> refElem = deletePos.getRefElem();
        count();
        if(refElem == null) {
            refElem = retrieve(deletePos);
            count();
        }
        count();
        refElem.getPrev().setNext(refElem.getNext());
        count();
        refElem.getNext().setPrev(refElem.getPrev());
        count();
        size--;
        count();
    }

    @Override
    public Pos find(Elem findElem) throws ElementNotFoundException {
        Pos resultPos = new Pos(headDummy);
        count();
        lastDummy.setData((T)findElem.getData());
        count();
        while(!resultPos.getRefElem().equals(findElem)) {
            resultPos.setRefElem(resultPos.getRefElem().getNext());
            count();
            resultPos.set(resultPos.getPos()+1);
            count();
            count();
        }
        count();
        if(resultPos.getRefElem() == lastDummy) {
            lastDummy.setData(null);
            count();
            throw new ElementNotFoundException();
        }
        count();
        lastDummy.setData(null);
        count();
        return resultPos;
    }

    @Override
    public Elem retrieve(Pos retrievePos) throws IndexOutOfBoundsException {
        Elem<T> result = retrievePos.getRefElem();
        count();
        final int pos = retrievePos.getPos();
        count();
        if(result == null) {
            if(pos > size || pos < 0){
                throw new IndexOutOfBoundsException();
            }
            count();
            result = headDummy.getNext();
            count();
            for(int i = 0; i < pos; i++) {
                result = result.getNext();
                count();
                count();
            }
            count();
        }
        count();
        return result;
    }

    @Override
    public void concat(OwnList otherList) {
        if (otherList.getClass().equals(this.getClass())) {
            lastDummy.getPrev().setNext(((DoubleLinkedList) otherList).headDummy.getNext());
            count();
            headDummy.getNext().setPrev(((DoubleLinkedList) otherList).lastDummy.getPrev());
            count();
            lastDummy = ((DoubleLinkedList) otherList).lastDummy;
            count();
            size += otherList.size();
            count();
        }
        else {
            /* TODO implement */
        }
        count();
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
