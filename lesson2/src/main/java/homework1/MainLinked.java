package homework1;

import java.util.Iterator;

public class MainLinked {
    public static void main(String[] args) {
        NodeLinked<String> stringMyLinkedList = new NodeLinked<>();
        stringMyLinkedList.addLast("abx");
        stringMyLinkedList.addLast("asdw");
        stringMyLinkedList.addFirst("123");
        stringMyLinkedList.addFirst("444");
        
        System.out.println(stringMyLinkedList.size());
        System.out.println("---------------");
        System.out.println(stringMyLinkedList.getElementByIndex(1));
        System.out.println("---------------");
        for (String s:stringMyLinkedList) {
            System.out.println(s);
        }
        System.out.println("---------------");
        Iterator iterator =stringMyLinkedList.descendingIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
