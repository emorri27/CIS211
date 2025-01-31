package ASGN_03;

public class LinkedStack<T> implements Stack<T> {
    private Node head;
    private int size;

    private class Node {
        T data;
        Node next;

        Node(T item) {
            this.data = item;
        }
    }

    public LinkedStack() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public void push(T item)  {
        Node node = new Node(item);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    @Override
    public T pop() {
        if (head == null) {
            return null;
        }

        T data = head.data;
        head = head.next;
        size--;
        return data;
    }

    @Override
    public T peek() {
        if (head == null) {
            return null;
        }
        return head.data;
    }

    @Override
    public boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node iterator = head;
        for (int i = size; i > 0; i--) {
            sb.append(iterator.data);
            iterator = iterator.next;
            if (i != 1) {
                sb.append(", ");
            }
        }
        sb.append("]");

        return sb.toString();
    }

    public T get(int index) {
        if (head == null) {
            return null;
        } else {
            Node iterator = head;
            for (int i = 0; i < index; i++) {
                iterator = iterator.next;
            }
            return (T) iterator.data;
        }
    }
}
