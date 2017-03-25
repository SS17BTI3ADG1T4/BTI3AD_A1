/**
 * Created by Markus Blechschmidt on 2017_03_25.
 */
public class Pos {
    /* private variables */
    private int pos;

    /* constructor */
    Pos(int pos){
        this.pos = pos;
    }

    /* getters*/
    public int get(){
        return pos;
    }

    /*setters */
    public void set(int pos){
        this.pos = pos;
    }

    @Override
    public boolean equals(Object other){
        if(other.getClass().equals(this.getClass())){
            return ((Pos)other).get() == pos;
        }
        else{
            return false;
        }
    }
}
