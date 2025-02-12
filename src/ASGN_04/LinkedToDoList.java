package ASGN_04;

public class LinkedToDoList<T> implements ToDoList<T>{
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
    public void removeTask(String task) {
        if (head != null) {
            if (head.task.equals(task)) {
                head = head.next;
            } else {
                Node iterator = head;
                while (iterator.next != null) {
                    if (iterator.next.task.equals(task)) {
                        iterator.next = iterator.next.next;
                        break;
                    }
                    iterator = iterator.next;
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("To Do List:\n");
        Node iterator = head;
        while (iterator != null) {
            sb.append(iterator.task + "\n");
            iterator = iterator.next;
        }
        return sb.toString();
    }
    @Override
    public void clearAllTasks() {
        head = null;
    }
}
