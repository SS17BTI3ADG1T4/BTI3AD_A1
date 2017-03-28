// TODO: Auto-generated Javadoc
/**
 * Created by Markus Blechschmidt on 9/19/16.
 *
 * @param <T> the generic type
 */
public class Elem <T>{
    
    /** The next. */
    private Elem<T> next = null;
    
    /** The prev. */
    private Elem<T> prev = null;
    
    /** The data. */
    private T data;

	/**
	 * Instantiates a new elem.
	 */
	public Elem() {
	}

    
	/**
	 * Instantiates a new elem.
	 *
	 * @param data the data
	 */
	public Elem(T data) {
		this.data = data;
	}

	/**
	 * Gets the next.
	 *
	 * @return the next
	 */
	/* getters */
    public Elem<T> getNext() {
        return next;
    }

    /**
     * Gets the prev.
     *
     * @return the prev
     */
    public Elem<T> getPrev() {
        return prev;
    }

    /**
     * Gets the data.
     *
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * Sets the next.
     *
     * @param next the new next
     */
    /* setters */
    public void setNext(Elem<T> next) {
        this.next = next;
    }

    /**
     * Sets the prev.
     *
     * @param prev the new prev
     */
    public void setPrev(Elem<T> prev) {
        this.prev = prev;
    }

    /**
     * Sets the data.
     *
     * @param data the new data
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Equals.
     *
     * @param other the other
     * @return true, if successful
     */
    //Compares the Data element of two elements
    public boolean equals(Elem other){
    	if(other.getData().equals(this.getData())){
    		return true;
    	}else return false;
    	
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object other){
        if(other.getClass().equals(this.getClass())){
            return ((Elem<T>)other).getData().equals(this.data);
        }
        else{
            return false;
        }
    }
}
