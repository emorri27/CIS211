/*
Course: CIS211-400
Author: Elliott Morris
Assignment: Module 2, Assignment: Array Stack and Test Program
Date: 1/27/2025
Description: This program implements a generic stack using an array, following the Stack<T> interface. It includes
push, pop, peek, isEmpty, and length operations. It also tests to validate functionality and edge cases.

I wrote all the code submitted, and I have provided citations and references where appropriate.
 */

package ASGN_02;

import java.lang.reflect.Array;

public class StackTest {
    public static void main(String[] args) {
        System.out.println("\n=== Testing Integer Stack, Capacity 3 ===");
        ArrayStack<Integer> stack1 = new ArrayStack<Integer>(3);

        stack1.push(10);
        stack1.push(20);
        stack1.push(30);

        System.out.println("Stack after pushes: " + stack1.toString());
        System.out.println("Popped element: " + stack1.pop());
        System.out.println("Stack after popping: " + stack1.toString());
        System.out.println("Peek element: " + stack1.peek());
        System.out.println("Is stack empty?: " + stack1.isEmpty());
        System.out.println("Stack size: " + stack1.length());

        System.out.println("\n=== Testing Empty Stack Operations ===");
        ArrayStack<String> stack2 = new ArrayStack<String>();

        System.out.println("Empty stack: " + stack2);
        System.out.println("Popping empty stack: " + stack2.pop());
        System.out.println("Popping empty stack again: " + stack2.pop());
        System.out.println("Peeking empty stack: " + stack2.peek());
        System.out.println("Is stack empty?: " + stack2.isEmpty());
        System.out.println("Stack size: " + stack2.length());

        System.out.println("\n=== Testing Pushing After Popping ===");
        stack2.push("Elliott");
        stack2.push("Jin");
        stack2.push("James");
        System.out.println("Stack after pushes: " + stack2);

        System.out.println("\n=== Testing Overfilling Stack ===");
        ArrayStack<Integer> stack3 = new ArrayStack<Integer>(1);

        stack3.push(100);
        System.out.println("Stack after pushing: " + stack3);
        System.out.println("Attempting to push full stack: ");
        try {
            stack3.push(200); // This will throw an exception
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
