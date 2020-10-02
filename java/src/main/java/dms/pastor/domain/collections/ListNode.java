package dms.pastor.domain.collections;

/**
 * Author Dominik Symonowicz
 * Created 27.08.2020
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
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

    //create a root
    ListNode(T dataType) {
        this(dataType, null, null);
    }

    public ListNode(T data, ListNode<T> previousNode, ListNode<T> nextNode) {
        this.data = data;
        this.previousNode = previousNode;
        this.nextNode = nextNode;
    }
}
