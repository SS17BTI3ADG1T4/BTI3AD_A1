/**
 * Created by marble on 3/27/17.
 */

import java.lang.Math;

public class ListBenchMark {
    static Counter counter;

    public static void main (String[] args){
        counter = new Counter();

        for(int j = 0; j <= 2; j++) {
            for (int i = 1; i <= 4; i++) {
                doBenchMarkTest(i, j);
            }
        }
    }

    private static void doBenchMarkTest(int exp, int type){
        Elem<Integer> temp;
        OwnList<Integer> listUnderTest;
        OwnList<Integer> otherList;
        int size = (int)Math.pow(10, exp);
        int[] positons = {0, size/2, size-1};
        long[] results= new long[3];

        counter.setCounter(0);

        switch(type){
            case (0):
//                listUnderTest = new HeapList<Integer>(counter);
//                otherList = new HeapList<Integer>();
//                break;
            case (1):
                listUnderTest = new DoubleLinkedList<Integer>(counter);
                otherList = new DoubleLinkedList<Integer>();
                break;
//            case (2):
//                listUnderTest = new Array<Integer>(size, counter);
//                otherList = new Array<Integer>(size);
//                break;
            default:
                return;
        }
        System.out.printf("\n\n\nStarting Test for %s with %d elements\n\n", listUnderTest.getClass().getSimpleName(), size);

        /* fill with elements */
        for(int i = 0; i < size; i++){
            temp = new Elem<Integer>(); temp.setData(i);
            listUnderTest.insert(new Pos(i), temp);

        }
        // TODO read counter
        counter.setCounter(0);

        /* insert */
        System.out.printf("%s insert\n", listUnderTest.getClass().getSimpleName());
        for(int i = 0; i < positons.length; i++) {
            temp = new Elem<>();
            temp.setData(-1);
            listUnderTest.insert(new Pos(positons[i]), temp);
            results[i] = counter.getCounter();
            counter.setCounter(0);
        }
        printResultsArray(results);

        /* delete */
        System.out.printf("%s delete\n", listUnderTest.getClass().getSimpleName());
        for(int i = 0; i < positons.length; i++) {
            listUnderTest.delete(new Pos(positons[i]));
            results[i] = counter.getCounter();
            counter.setCounter(0);
        }
        printResultsArray(results);

        /* find */
        System.out.printf("%s find\n", listUnderTest.getClass().getSimpleName());
        for(int i = 0; i < positons.length; i++) {
            temp = new Elem<>();
            temp.setData(positons[i]);
            try {
                listUnderTest.find(temp);
            } catch (ElementNotFoundException e) {
                e.printStackTrace();
            }
            results[i] = counter.getCounter();
            counter.setCounter(0);
        }
        printResultsArray(results);

        /* retrieve */
        System.out.printf("%s retrieve\n", listUnderTest.getClass().getSimpleName());
        for(int i = 0; i < positons.length; i++) {
            listUnderTest.retrieve(new Pos(positons[i]));
            results[i] = counter.getCounter();
            counter.setCounter(0);
        }
        printResultsArray(results);

        /* get size */
        System.out.printf("%s size\n", listUnderTest.getClass().getSimpleName());
        listUnderTest.size();
        results[0] = counter.getCounter();
        counter.setCounter(0);
        System.out.printf("\t%12d\n", results[0]);

        /* fill other list with elements */
        for(int i = 0; i < size; i++){
            temp = new Elem<Integer>(); temp.setData(i);
            otherList.insert(new Pos(i), temp);
        }

        System.out.printf("%s concat\n", listUnderTest.getClass().getSimpleName());
        listUnderTest.concat(otherList);
        results[0] = counter.getCounter();
        counter.setCounter(0);
        System.out.printf("\t%12d\n", results[0]);
    }

    private static void printResultsArray(long[] results){
        final String format = "\t%12s%12s%12s\n";
        System.out.printf(format, "first", "middle", "last");
        System.out.printf(format, results[0], results[1], results[2]);
    }
}
