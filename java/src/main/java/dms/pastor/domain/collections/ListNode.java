package dms.pastor.domain.collections;

/**
 * Author Dominik Symonowicz
 * Created 27.08.2020
 * WWW:	https://dominiksymonowicz.com/
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
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
