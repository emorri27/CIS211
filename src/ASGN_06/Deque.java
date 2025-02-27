package ASGN_06;

/**
 * @author Delaware Technical Community College
 * Starter and/or reference code provided for Delaware Technical Community College courses.
 *
 * Deque (Double Ended Queue) ADT
 *
 * based on https://people.cs.vt.edu/shaffer/Book/JAVA3elatest.pdf
 */
public interface Deque<E> {

    /**
     * Place an element at the rear of the queue.
     *
     * @param it The element being added.
     * @throws IllegalStateException- if the element cannot be added at this time due to capacity restrictions
     */
    public void addBack(E it) throws IllegalStateException;

    /**
     * Place an element at the front of the queue.
     *
     * @param it The element being enqueued.
     * @throws IllegalStateException- if the element cannot be added at this time due to capacity restrictions
     */
    public void addFront(E it) throws IllegalStateException;;

    /**
     * Remove and return element at the front of the queue.
     *
     * @return The element at the front of the queue.
     * @return null if the queue is empty
     */
    public E removeFront();

    /**
     * Remove and return element at the back of the queue.
     *
     * @return The element at the back of the queue.
     * @return null if the queue is empty
     */
    public E removeBack();

    /**
     * @return The front element.
     * @return null if the queue is empty
     */
    public E getFront();

    /**
     * @return The back element.
     * @return null if the queue is empty
     */
    public E getBack();

    /**
     * Detects whether this queue is empty.
     *
     * @return True if the queue is empty.
     */

    public boolean isEmpty();

    /**
     * @return The number of elements in the queue.
     */
    public int length();
}
