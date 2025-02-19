package ASGN_04;

import java.util.NoSuchElementException;

public class LinkedToDoList implements ToDoList {
    private Node head;
    private int size;

    private class Node {
        private String task;
        private Node next;

        Node(String task) {
            this.task = task;
        }
    }

    LinkedToDoList() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public void addTask(String task) {
        Node node = new Node(task);
        node.next = head;
        head = node;
        size++;
    }

    @Override
    public void removeTask(String task) throws NoSuchElementException {
        if (head == null) {
            throw new NoSuchElementException("Error: List is empty. Nothing to remove.");
        }

        if (head.task.equals(task)) {
            head = head.next;
            size--;
            return;
        }

        Node iterator = head;
        while (iterator.next != null) {
            if (iterator.next.task.equals(task)) {
                iterator.next = iterator.next.next;
                size--;
                return;
            }
            iterator = iterator.next;
        }

        throw new NoSuchElementException("Error: Task '" + task + "' not found in list.");
    }

    @Override
    public String toString() {
        if (head == null) return "\nThe list is empty.";

        StringBuilder sb = new StringBuilder();
        sb.append("\n=====To Do List=====\n");
        Node iterator = head;

        printTasks(sb, head, size);

        return sb.toString();
    }

    private void printTasks(StringBuilder sb, Node node, int index) {
        if (node == null) return;
        printTasks(sb, node.next, index - 1);
        sb.append(index).append(": ").append(node.task).append("\n");
    }

    @Override
    public void clearAllTasks() {
        head = null;
        size = 0;
    }
}