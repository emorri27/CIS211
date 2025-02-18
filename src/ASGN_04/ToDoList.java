package ASGN_04;

import java.util.NoSuchElementException;

public interface ToDoList<T> {
    void addTask(String task);
    /**
     * Adds a new task to the list. Position designated by the implementation.
     *
     * @param task A task to be added to the list.
     */
    void removeTask(String task) throws NoSuchElementException;
    /**
     * Removes the specified task from the list.
     *
     * @param task The task to be removed.
     */
    String toString();
    /**
     * Return a string representation of the list.
     */
    void clearAllTasks();
    /**
     * Clears all tasks from the list.
     */

}
