package practice;

import java.util.ArrayList;

public class ArrayListDemo {

    public static void main(String[] args) {

        ArrayList<Integer> l1= new ArrayList<Integer>();
        ArrayList<String> l2= new ArrayList<String>();
        System.out.println(l1.size());
        l1.add(29);
        l1.add(30);
        l1.add(6);
//        System.out.println(l1.size());
//        System.out.println(l1.get(2));
//        
//        l1.add(2, 15);
//        System.out.println(l1.get(2));
//        
//        for(int i=0; i<l1.size(); i++) {
//        	System.out.print(l1.get(i)+" ");
//        }
//        System.out.println();
//        
//        l1.remove(2);
        for(int i=0; i<l1.size(); i++) {
        	System.out.print(l1.get(i)+" ");
        }
        System.out.println();
        
//        l1.set(0, 25);
//        for(int i=0; i<l1.size(); i++) {
//        	System.out.print(l1.get(i)+" ");
//        }
//        System.out.println();
        
        for( int element: l1) {
        	System.out.print(element+" ");
        }
        System.out.println();
        
    }
}
