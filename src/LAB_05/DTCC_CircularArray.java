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
        this.front = 1;
        this.back = 1;
        this.size = 0;
    }

    public void add(int value) throws IllegalStateException {
        if (size >= capacity) throw new IllegalStateException("Error: Array is full.");
        array[back++%capacity] = value;
        size++;
    }

    public int get(int index) {
        return array[index];
    }

    public void remove(int index) {
        if (size == 0) return;

        if (index+front <= size/2) {
            for (int i = index+front; i > front; i--) {
                array[i%capacity] = array[(i-1)%capacity];
            }
            front++;
            size--;
            return;
        }

        if (index+front > size/2) {
            for (int i = index+front; i < back-1; i++) {
                array[i%capacity] = array[(i+1)%capacity];
            }
            back--;
            size--;
            return;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = front%capacity; i < back; i++) {
            sb.append(array[i%capacity]);
            if (i+1 < back) sb.append(", ");
        }
        sb.append("]");

        return sb.toString();
    }
}
