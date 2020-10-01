package dms.pastor.domain.collections;

import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Author Dominik Symonowicz
 * Created 27.08.2020
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class DoubleWayLinkedList<Type> {
    private ListNode<Type> head;
    private int size;

    //create empty list
    public DoubleWayLinkedList() {
        head = null;
        size = 0;
    }

    public void addHead(Type element) {
        if (isEmpty()) {
            head = new ListNode<>(element);
        } else {
            ListNode<Type> temp = head;
            head = new ListNode<>(element, null, temp);
            head.nextNode.previousNode = head; //TODO set method for that
        }
        size++;
    }

    /*
    Empty list: Simply initiate the front variable as a new ListNode.
    Non-empty list: Traverse the list until the end. Make the last-node.next point the new node. Remember to update the previous pointer for the inserted node!
     */
    public void addTail(Type element) {
        if (isEmpty()) {
            head = new ListNode<>(element);
        } else {
            ListNode<Type> temp = head;
            //traverse until end of the list
            while (Objects.nonNull(temp.nextNode)) {
                temp = temp.nextNode;
            }
            temp.nextNode = new ListNode<>(element);
        }
        size++;
    }

    public void addBefore(Type currentElement, Type newElement) {
        throwExceptionIfEmpty(currentElement);

        ListNode<Type> current = head;

        //looping through until found (move to method)
        while (Objects.nonNull(current) && !current.data.equals(currentElement)) { // move to seperate method
            current = current.nextNode;
        }

        if (Objects.isNull(current)) {
            throwNotFoundException(currentElement); //test it
        }

        ListNode<Type> newNode = new ListNode<>(newElement, current.previousNode, current);

        if (Objects.isNull(current.previousNode)) {
            current.previousNode.nextNode = newNode;
        } else {
            head = newNode;
        }
        current.previousNode = newNode;

        size++;
    }


    public void addAfter(Type currentElement, Type y) {
        throwExceptionIfEmpty(currentElement);

        ListNode<Type> current = head;
    }

    public void remove(Type element) {

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
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
