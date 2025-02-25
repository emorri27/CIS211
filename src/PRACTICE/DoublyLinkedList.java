package PRACTICE;

import java.util.NoSuchElementException;

public class DoublyLinkedList<T> {
    private Node head, tail;
    private int count = 0;

    public boolean add(T item) {
        Node node = new Node(item);
        if (head == null) {
            head = node;
            tail = node;
            count++;
            return true;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
            count++;
            return true;
        }
    }

    public void remove(int index) throws NoSuchElementException {
        if (head == null) throw new NoSuchElementException("Error: List is empty.");
        if (index > count || index < 0) throw new NoSuchElementException("Error: Index out of bounds.");

        if (index < count/2) {
            Node itr = head;
            for (int i = 0; i < index-1; i++) {
                itr = itr.next;
            }
            itr.next = itr.next.next;
            itr.next.next.prev = itr;
        } else {
            Node itr = tail;
            for (int i = 0; i > index; i--) {

            }
        }
        count--;
    }

    class Node {
        private Node prev, next;
        private T data;

        Node(T data) {
            this.data = data;
        }
    }
}
