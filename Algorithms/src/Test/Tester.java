package Test;

import java.util.Iterator;
import java.util.Stack;

public class Tester {
    public static void main(String[] args) {
        Stack<Integer> o = new Stack<>();
        o.push(0);
        o.push(1);
        o.push(2);
        o.push(3);
        o.push(4);
        //
        while(!o.isEmpty()){
            System.out.println(o.pop());
        }

        System.out.println();

        o.push(0);
        o.push(1);
        o.push(2);
        o.push(3);
        o.push(4);

        Iterator <Integer> it = o.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }


}
