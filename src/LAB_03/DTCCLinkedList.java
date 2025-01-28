package LAB_03;

public class DTCCLinkedList<T> {
    private Node<T> head;
    private int size;

    DTCCLinkedList() {
        this.head = null;
        this.size = 0;
    }

    class Node<T> {
        T data;
        Node<T> next;

        Node(T item) {
            this.data = item;
        }
    }

    public void add(T item) {
        Node<T> node = new Node<T>(item);

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