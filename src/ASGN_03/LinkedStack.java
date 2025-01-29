package ASGN_03;

public class LinkedStack<T> implements Stack<T> {
    private T[] stack;
    private int size = 0;
    private int capacity;
    private final int DEFAULT_SIZE = 10;

    public LinkedStack() {
        this.capacity = DEFAULT_SIZE;
        this.stack = (T[]) new Object[DEFAULT_SIZE];
    }
    public LinkedStack(int capacity) {
        this.capacity = capacity;
        this.stack = (T[]) new Object[capacity];
    }

    @Override
    public void push(T item) throws IllegalStateException {
        if (size >= capacity) {
            throw new IllegalStateException("Stack is full, can't push new item.");
        }
        stack[size] = item;
        size++;
    }

    @Override
    public T pop() {
        if (size > 0) {
            T item = stack[size-1];
            size--;
            return item;
        } else {
            return null;
        }
    }

    @Override
    public T peek() {
        if (size > 0) {
            return stack[size-1];
        } else {
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(stack[i]);
            if (i < size-1) {
                sb.append(", ");
            }
        }
        sb.append("]");

        return sb.toString();
    }
}
