/**
 * Created by Markus Blechschmidt on 9/19/16.
 */
public class Elem <T>{
    private Elem<T> next = null;
    private Elem<T> prev = null;
    private T data;
    public int index;


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
