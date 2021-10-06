package dms.pastor.domain.collections;

import java.util.NoSuchElementException;

/**
 * Author Dominik Symonowicz
 * Created 27.08.2020
 * WWW:	https://dominiksymonowicz.com/
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
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
