package dms.pastor.examples.collections;

import java.util.NoSuchElementException;

/**
 * Author: Dominik Symonowicz
 * Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
 * LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
 * GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 * Created 27.08.2020
 */
public class DoubleWayLinkedList<Type> {
    private ListNode<Type> head;
    private int size;


    public boolean isEmpty() {
        return size == 0;
    }


    private void throwExceptionIfEmpty(Type element) {
        if (isEmpty()) {
            throwNotFoundException(element);
        }
    }

    private void throwNotFoundException(Type element) {
        throw new NoSuchElementException(String.format("Element %s not found", element.toString()));
    }

}
