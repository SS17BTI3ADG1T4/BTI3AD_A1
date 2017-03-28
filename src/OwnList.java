// TODO: Auto-generated Javadoc
/**
 * Created by Markus Blechschmidt on 2017_03_25.
 *
 * @param <T> the generic type
 */

public interface OwnList<T> {
    
    /**
     * Insert.
     *
     * @param insertPos the insert pos
     * @param insertElem the insert elem
     * @throws IndexOutOfBoundsException the index out of bounds exception
     */
    void insert(Pos insertPos, Elem<T> insertElem) throws IndexOutOfBoundsException;
    
    /**
     * Delete.
     *
     * @param deletePos the delete pos
     * @throws IndexOutOfBoundsException the index out of bounds exception
     */
    void delete(Pos deletePos) throws IndexOutOfBoundsException;
    
    /**
     * Delete.
     *
     * @param deleteElemy the delete elemy
     * @throws ElementNotFoundException the element not found exception
     */
    void delete(Elem deleteElemy) throws ElementNotFoundException;
    
    /**
     * Find.
     *
     * @param findElem the find elem
     * @return the pos
     * @throws ElementNotFoundException the element not found exception
     */
    Pos find(Elem<T> findElem) throws ElementNotFoundException;
    
    /**
     * Retrieve.
     *
     * @param retrievePos the retrieve pos
     * @return the elem
     * @throws IndexOutOfBoundsException the index out of bounds exception
     */
    Elem<T> retrieve(Pos retrievePos) throws IndexOutOfBoundsException;
    
    /**
     * Concat.
     *
     * @param otherList the other list
     */
    void concat(OwnList<T> otherList);
    
    /**
     * Size.
     *
     * @return the int
     */
    int size();
}
