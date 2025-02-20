package LAB_05;

public class DTCC_CircularArray {
    private int[] array;
    private int front;
    private int back;
    private int size;
    private int capacity;

    DTCC_CircularArray(int initialCapacity) {
        this.capacity = initialCapacity;
        this.array = new int[initialCapacity];
        this.front = 0;
        this.back = 0;
        this.size = 0;
    }

    public void add(int value) throws IllegalStateException {
        if (size >= capacity) throw new IllegalStateException("Error: Array is full.");
        array[back++] = value;
        size++;
    }

    public int get(int index) {
        return array[index];
    }

    public void remove(int index) {
        if (index == front) {
            front++;
            size--;
            return;
        }

        if (index == back) {
            back--;
            size--;
            return;
        }

        if (index < size/2) {
            for (int i = front; i < index; i++) {
                array[i+1] = array[i];
            }
            front++;
            size--;
            return;
        }

        if (index >= size/2) {
            for (int i = index; i < back-1; i++) {
                array[i] = array[i+1];
            }
            back--;
            size--;
            return;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = front; i < back; i++) {
            sb.append(array[i]);
            if (i < back-1) {
                sb.append(", ");
            }
        }
        sb.append("]");

        return sb.toString();
    }
}
