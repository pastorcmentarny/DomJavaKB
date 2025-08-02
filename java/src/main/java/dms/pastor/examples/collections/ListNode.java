package dms.pastor.examples.collections;

/**
 * Author: Dominik Symonowicz
 * Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
 * LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
 * GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 * Created 27.08.2020
 * <p>
 * With a doubly linked list, we can iterate both forwards and backward through the list.
 * <p>
 * The delete operation is much more efficient.
 * <p>
 * Insertion before a node is also much more efficient.
 */
public class ListNode<T> {
    T data;
    ListNode<T> previousNode;
    ListNode<T> nextNode;

}
