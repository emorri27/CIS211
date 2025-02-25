/*
Course: CIS211-400
Author: Elliott Morris
Assignment: Module 5, Lab: Circular Array
Date: 2/20/2025
Description: Program defines a DTCC_CircularArray class that implements a circular array.
The class includes methods for adding elements, getting elements by index, removing elements, and converting the array to a string representation.

I wrote all the code submitted, and I have provided citations and references where appropriate.
*/

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
        array[back] = value;
        back = (back+1)%capacity;
        size++;
    }

    public int get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index out of bounds");
        return array[(index+front) % capacity];
    }

    public void remove(int index) {
        if (size == 0) return;

        int actualIndex = (index+front) % capacity;
        if (index+front <= size/2) {
            for (int i = actualIndex; i != front; i = (i-1+capacity)%capacity) {
                array[i] = array[(i-1+capacity)%capacity];
            }
            front = (front+1)%capacity;
        } else {
            for (int i = actualIndex; i != (back-1+capacity)%capacity; i = (i+1)%capacity) {
                array[i] = array[(i+1)%capacity];
            }
            back = (back-1+capacity)%capacity;
        }
        size--;
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
