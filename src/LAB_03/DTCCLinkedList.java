/*
Course: CIS211-400
Author: Elliott Morris
Assignment: Module 3, Lab: Linked List
Date: 1/29/2025
Description: Program defines a DTCCLinkedList class for managing a collection of elements in a dynamically sized linked list.
The class includes methods for adding elements, getting elements by index, and converting the list to a string representation.

I wrote all the code submitted, and I have provided citations and references where appropriate.
 */


/*
Course: CIS211-400
Author: Elliott Morris
Assignment: Module 3, Lab: Linked List
Date: 1/28/2025
Description: Program defines a DTCCArrayList class for managing integers in a dynamically sized array

I wrote all the code submitted, and I have provided citations and references where appropriate.
 */

package LAB_03;

public class DTCCLinkedList<T> {
    private Node head;
    private int size;

    DTCCLinkedList() {
        this.head = null;
        this.size = 0;
    }

    private class Node {
        T data;
        Node next;

        Node(T item) {
            this.data = item;
        }
    }

    public void add(T item) {
        Node node = new Node(item);

        if (head == null) {
            head = node;
            size++;
        } else {
            Node iterator = head;
            for (int i = 0; i < size-1; i++) {
                iterator = iterator.next;
            }
            iterator.next = node;
            size++;
        }

    }

    public T get(int index) {
        if (head == null) {
            return null;
        } else {
            Node iterator = head;
            for (int i = 0; i < index; i++) {
                iterator = head.next;
            }
            return (T) iterator.data;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node iterator = head;
        for (int i = 0; i < size; i++) {
            sb.append(iterator.data);
            iterator = iterator.next;
            if (i < size-1) {
                sb.append(", ");
            }
        }
        sb.append("]");

        return sb.toString();
    }
}