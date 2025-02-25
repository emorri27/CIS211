package ASGN_05;

public class CircularArrayQueue<E> implements Queue<E> {
    private E[] array;
    private int front;
    private int back;
    private int capacity;
    private int size;

    CircularArrayQueue(int capacity) {
        this.capacity = capacity;
        this.array = (E[]) new Object[capacity];
        this.size = 0;
        this.front = 0;
        this.back = 0;
    }

    @Override
    public void enqueue(E it) throws IllegalStateException {
        if (size >= capacity) throw new IllegalStateException("Error: Queue is full.");
        array[back] = (E) it;
        back = (back+1)%capacity;
        size++;
    }

    @Override
    public E dequeue() {
        if (size == 0) return null;
        E frontItem = array[front];
        size--;
        front = (front+1)%capacity;
        return frontItem;
    }

    @Override
    public E frontValue() {
        if (size == 0) return null;
        return array[front];
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) return true;
        return false;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[(i+front)%capacity]);
            if (i+1 != size) sb.append(", ");
        }
        sb.append("]");

        return sb.toString();
    }
}
