/**
 * Created by Markus Blechschmidt on 2017_03_25.
 */
public class Pos {
    /* private variables */
    private int pos;
    private Elem refElem = null;

    /* constructors */
    Pos(int pos, Elem refElem){
        this.pos = pos;
        this.refElem = refElem;
    }

    Pos(int pos){
        this(pos, null);
    }

    Pos(Elem refElem){
        this(-1, refElem);
    }

    /* getters*/
    public int getPos(){
        return pos;
    }

    public Elem getRefElem() {
        return refElem;
    }

    /*setters */
    public void set(int pos){
        this.pos = pos;
    }

    public void setRefElem(Elem refElem) {
        this.refElem = refElem;
    }

    @Override
    public boolean equals(Object other){
        if(other.getClass().equals(this.getClass())){
            return (((Pos)other).getPos() == pos) &&
                    (((Pos)other).getRefElem() == refElem);
        }
        else{
            return false;
        }
    }
}
