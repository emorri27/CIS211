package PRACTICE;

public class MyMap<K, V> {
    private Node head, tail;
    private int size;

    public MyMap() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }


    class Node {
        Node next, prev;
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(K key, V value) {
        Node node = new Node(key, value);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    public V get(K key) {
        if (head == null) return null;
        Node itr = head;
        while (itr != null) {
            if (itr.key.equals(key)) {
                return itr.value;
            }
            itr = itr.next;
        }
        return null;
    }
}
