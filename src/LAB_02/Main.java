package LAB_02;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DTCCArrayList list = new DTCCArrayList(5);

        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println("Element at index 1: " + list.get(1)); // Output: 20
        System.out.println("List: " + list.toString()); // Output: [10, 20, 30]

        list.add(40);
        list.add(50);

        System.out.println("List after adding more elements: " + list.toString()); // Output: [10, 20, 30, 40, 50]
    }
}