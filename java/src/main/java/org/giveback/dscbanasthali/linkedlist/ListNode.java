package org.giveback.dscbanasthali.linkedlist;

public final class ListNode<T> {
    private T value;
    private ListNode<T> next;

    public T getValue() {

        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }
}
