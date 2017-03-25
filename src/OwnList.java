/**
 * Created by Markus Blechschmidt on 2017_03_25.
 */

public interface OwnList<T> {
    void insert(Pos insertPos, Elem<T> insertElem) throws IndexOutOfBoundsException;
    void delete(Pos deletePos) throws IndexOutOfBoundsException;
    Pos find(Elem<T> findElem);
    Elem<T> retrieve(Pos retrievePos) throws IndexOutOfBoundsException;
    void concat(OwnList<T> otherList);
    int size();
}
