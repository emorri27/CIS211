/*
Course: CIS211-400
Author: Elliott Morris
Assignment: Module 6, Lab: Doubly Linked List
Date: 2/27/2025
Description: This program implements a doubly linked list data structure called DTCCDoublyLinkedList. The list is designed to
store integer values. It includes methods for adding (add(int value)), getting (get(int index)), and removing (remove(int index)) elements,
along with exception handling for empty lists and invalid indexes. The toString() method provides a string representation of the list.

I wrote all the code submitted, and I have provided citations and references where appropriate.
*/

package LAB_06;

import java.util.NoSuchElementException;

public class TestDTCCDoublyLinkedList {
    public static void main(String[] args) {
        DTCCDoublyLinkedList list = new DTCCDoublyLinkedList();

        try {
            System.out.print("Attempting to remove from empty list: ");
            list.remove(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        list.add(10);

        try {
            System.out.print("Attempting to remove with out of bounds index: ");
            list.remove(-5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        System.out.println("List: " + list.toString()); // Output: [10, 20, 30, 40, 50]

        System.out.println("Element at index 1: " + list.get(1)); // Output: 20

        list.remove(2);
        System.out.println("List after removing element at index 2: " + list.toString()); // Output: [10, 20, 40, 50]

        list.remove(0);
        System.out.println("List after removing element at index 0: " + list.toString()); // Output: [20, 40, 50]

        list.remove(2);
        System.out.println("List after removing last element at index 2: " + list.toString()); // Output: [20, 40]
    }
}
