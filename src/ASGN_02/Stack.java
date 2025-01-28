package ASGN_02;

/*
 * @author Delaware Technical Community College
 * Starter and/or reference code provided for Delaware Technical Community College courses.
 *
 * Stack ADT
 */
public interface Stack<T> {

    /**
     * Adds a new entry to the top of the stack.
     *
     * @param item An object to be added to the stack.
     * @throws IllegalStateException if the element cannot be added due to capacity restrictions.
     */
    void push(T item) throws IllegalStateException;
    /**
     * Removes and returns the top entry of the stack.
     *
     * @return The object at the top of the stack, or null if the stack is empty.
     */
    T pop();

    /**
     * Retrieves the top entry of the stack without removing it.
     *
     * @return The object at the top of the stack, or null if the stack is empty.
     */
    T peek();

    /**
     * Checks if the stack is empty.
     *
     * @return True if the stack is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Retrieves the number of entries in the stack.
     *
     * @return The number of entries.
     */
    int length();
}
