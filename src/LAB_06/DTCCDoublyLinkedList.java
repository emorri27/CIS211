package LAB_06;

import java.util.NoSuchElementException;

public class DTCCDoublyLinkedList {
    private Node head, tail;
    private int size;

    public DTCCDoublyLinkedList() {
        this.head = this.tail = null;
        this.size = 0;
    }

    private static class Node {
        private Node prev, next;
        private int data;

        Node(int data) {
            this.data = data;
        }
    }

    public boolean add(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            tail = node;
            size++;
            return true;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
            size++;
            return true;
        }
    }

    public int get(int index) throws NoSuchElementException {
        if (head == null) throw new NoSuchElementException("Error: List is empty.");
        if (index >= size || index < 0) throw new IndexOutOfBoundsException("Error: Index out of bounds.");

        if (index < size/2) {
            Node itr = head;
            for (int i = 0; i < index; i++) {
                itr = itr.next;
            }
            return itr.data;
        } else {
            Node itr = tail;
            for (int i = size-1; i > index; i--) {
                itr = itr.prev;
            }
            return itr.data;
        }
    }

    public boolean remove(int index) {
        if (head == null) throw new NoSuchElementException("Error: List is empty.");
        if (index >= size || index < 0) throw new IndexOutOfBoundsException("Error: Index out of bounds.");

        if (index == 0) {
            head = head.next;
        } else if (index == size-1) {
          tail = tail.prev;
          tail.next = null;
        } else if (index < size/2) {
            Node itr = head;
            for (int i = 0; i < index-1; i++) {
                itr = itr.next;
            }
            itr.next = itr.next.next;
            itr.next.prev = itr;
        } else {
            Node itr = tail;
            for (int i = size-1; i > index+1; i--) {
                itr = itr.prev;
            }
            itr.prev = itr.prev.prev;
            itr.prev.next = itr;
        }
        size--;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        if (head != null) {
            Node itr = head;
            sb.append(itr.data);
            while (itr.next != null) {
                sb.append(", ");
                itr = itr.next;
                sb.append(itr.data);
            }
        }

        sb.append("]");

        return sb.toString();
    }
}
