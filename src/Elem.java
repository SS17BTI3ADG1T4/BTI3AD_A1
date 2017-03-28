/**
 * Created by Markus Blechschmidt on 9/19/16.
 */
public class Elem <T>{
    private Elem<T> next = null;
    private Elem<T> prev = null;
    private T data;

	public Elem() {
	}

    
	public Elem(T data) {
		this.data = data;
	}

	/* getters */
    public Elem<T> getNext() {
        return next;
    }

    public Elem<T> getPrev() {
        return prev;
    }

    public T getData() {
        return data;
    }

    /* setters */
    public void setNext(Elem<T> next) {
        this.next = next;
    }

    public void setPrev(Elem<T> prev) {
        this.prev = prev;
    }

    public void setData(T data) {
        this.data = data;
    }

    //Compares the Data element of two elements
    public boolean equals(Elem other){
    	if(other.getData().equals(this.getData())){
    		return true;
    	}else return false;
    	
    }
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
