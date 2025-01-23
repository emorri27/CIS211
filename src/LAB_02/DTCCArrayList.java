package LAB_02;

import java.util.List;

public class DTCCArrayList {
    private final int DEFAULT_SIZE = 0;
    private int[] array;
    private int size = 0;

    public DTCCArrayList() {
        this.array = new int[DEFAULT_SIZE];
    }
    public DTCCArrayList(int initialCapacity) {
        this.array = new int[initialCapacity];
    }

    public void add(int value) {
        if (size < array.length) {
            array[size] = value;
            size++;
        }
    }
    public int get(int index) {
        if (size >= index) {
            return array[index];
        } else {
            throw new IllegalArgumentException("Index out of bounds.");
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); // I got this from
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i < size-1) {
                sb.append(", ");
            }
        }
        sb.append("]");

        return sb.toString();
    }
}
