package org.giveback.dscbanasthali.linkedlist;

public class CircularLinkedList<T extends Comparable<T>> {
    private ListNode<T> tail;
    private int length;

    CircularLinkedList() {
        tail = null;
        length = 0;
    }

}
