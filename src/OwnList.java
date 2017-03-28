/**
 * Created by Markus Blechschmidt on 2017_03_25.
 */

public interface OwnList<T> {
    void insert(Pos insertPos, Elem<T> insertElem) throws IndexOutOfBoundsException;
    void delete(Pos deletePos) throws IndexOutOfBoundsException;
    void delete(T key) throws ElementNotFoundException;
    Pos find(Elem<T> findElem) throws ElementNotFoundException;
    Elem<T> retrieve(Pos retrievePos) throws IndexOutOfBoundsException;
    void concat(OwnList<T> otherList);
    int size();
}
