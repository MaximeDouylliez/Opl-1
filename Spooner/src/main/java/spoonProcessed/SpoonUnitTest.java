package spoonProcessed;

import java.util.ArrayList;
import java.util.LinkedList;

public class SpoonUnitTest {
    //LinkedList
    private LinkedList<String> ls;
    private LinkedList<Integer> ls2;
    private final LinkedList<Integer> ls3;

    //ArrayList
    public ArrayList<String> fal;
    private ArrayList<Integer> fal2;
    private final ArrayList<Integer> fal3;

    //Immutable
    public static final ArrayList arr = new ArrayList();
    public static final LinkedList<Integer> lin = new LinkedList<>();

    public SpoonUnitTest(){
        int inte=6;
        ls = new LinkedList<String>();
        fal= new ArrayList<String>();
        ls2 = new LinkedList<Integer>();
        ls3 = new LinkedList<>();
        fal2 = new ArrayList<Integer>();
        fal3 = new ArrayList<>();

        this.ls2.add(99);
        this.ls.add("hello");
        this.ls2.add(1);
        this.ls3.add(15);
        this.fal.add("hello2");
        this.fal.add("hello3");
        this.fal2.add(2);
        this.fal3.add(1);
        this.arr.add('r');
        this.lin.add(9);
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

    }

}


