package ASGN_06;

public class DequeDoublyLinkedList<E> implements Deque<E> {
    private Node<E> head, tail;
    private int size;

    public DequeDoublyLinkedList() {
        this.head = this.tail = null;
        this.size = 0;
    }

    private static class Node<E> {
        private Node prev, next;
        private E data;

        public Node(E data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    @Override
    public void addBack(E it) throws IllegalStateException {
        Node node = new Node(it);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    @Override
    public void addFront(E it) throws IllegalStateException {
        Node node = new Node(it);
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    @Override
    public E removeFront() {
        if (head == null) return null;

        E target = head.data;
        if (size > 1) {
            head = head.next;
            head.prev = null;
        } else {
            head = tail = null;
        }
        size--;
        return target;
    }

    @Override
    public E removeBack() {
        if (head == null) return null;

        E target = tail.data;
        if (size > 1) {
            tail = tail.prev;
            tail.next = null;
        } else {
            head = tail = null;
        }
        size--;
        return target;
    }

    @Override
    public E getFront() {
        if (head == null) return null;
        return head.data;
    }

    @Override
    public E getBack() {
        if (head == null) return null;
        return tail.data;
    }

    @Override
    public boolean isEmpty() {
        if (head == null) return true;
        return false;
    }

    @Override
    public int length() {
        return size;
    }
}
