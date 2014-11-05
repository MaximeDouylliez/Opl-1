package spoonProcessed;

import com.google.common.collect.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class SpoonUnitTest {
    //LinkedList
    private LinkedList<String> ls;
    private LinkedList<Integer> ls2;
    private final LinkedList<Integer> ls3;
    private ArrayList test = Lists.newArrayList(1,2);
    //ArrayList
    public ArrayList<String> fal;
    private ArrayList<Integer> fal2;
    private final ArrayList<Integer> fal3;

    //Immutable
    public static final ArrayList arr = new ArrayList();
    public static final LinkedList<Integer> lin = new LinkedList();

    public SpoonUnitTest(){
        ls = new LinkedList<String>();
        fal= new ArrayList<String>();
        ls2 = new LinkedList<Integer>();
        ls3 = new LinkedList();
        fal2 = new ArrayList<Integer>();
        fal3 = new ArrayList();

        ls2.add(99);
        ls.add("hello");
        ls2.add(1);
        ls3.add(15);
        fal.add("hello2");
        fal.add("hello3");
        fal2.add(2);
        fal3.add(1);
        arr.add('r');
        lin.add(9);
    }

    public void linkedListClassicsUses() {

        this.ls.add("re");
        this.ls.addLast("lefih");
        this.ls2.add(100);
        this.ls3.add(1500);
        this.fal.add("drhyuhlk");
        this.fal2.add(200);
        this.fal3.add(100);
        this.arr.add('r');
        this.lin.add(900);
        this.test.add(3);

    }
    public static void main(String[]args){
        SpoonUnitTest sp = new SpoonUnitTest();
        sp.linkedListClassicsUses();
    }

}


