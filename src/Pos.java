// TODO: Auto-generated Javadoc
/**
 * Created by Markus Blechschmidt on 2017_03_25.
 */
public class Pos {
    
    /** The pos. */
    /* private variables */
    private int pos;
    
    /** The ref elem. */
    private Elem refElem = null;

    /**
     * Instantiates a new pos.
     *
     * @param pos the pos
     * @param refElem the ref elem
     */
    /* constructors */
    Pos(int pos, Elem refElem){
        this.pos = pos;
        this.refElem = refElem;
    }

    /**
     * Instantiates a new pos.
     *
     * @param pos the pos
     */
    Pos(int pos){
        this(pos, null);
    }

    /**
     * Instantiates a new pos.
     *
     * @param refElem the ref elem
     */
    Pos(Elem refElem){
        this(-1, refElem);
    }

    /**
     * Gets the pos.
     *
     * @return the pos
     */
    /* getters*/
    public int getPos(){
        return pos;
    }

    /**
     * Gets the ref elem.
     *
     * @return the ref elem
     */
    public Elem getRefElem() {
        return refElem;
    }

    /**
     * Sets the.
     *
     * @param pos the pos
     */
    /*setters */
    public void set(int pos){
        this.pos = pos;
    }

    /**
     * Sets the ref elem.
     *
     * @param refElem the new ref elem
     */
    public void setRefElem(Elem refElem) {
        this.refElem = refElem;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
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
