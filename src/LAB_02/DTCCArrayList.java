/*
Course: CIS211-400
Author: Elliott Morris
Assignment: Module 2, Lab: Array List
Date: 1/21/2025
Description: Program defines a DTCCArrayList class for managing integers in a dynamically sized array

I wrote all the code submitted, and I have provided citations and references where appropriate.
 */

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
        } else {
            System.out.println("Error. List is full.");
        }
    }
    public int get(int index) {
        if (index < size && index >= 0) {
            return array[index];
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); // I got this from observing the other Java classes
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
