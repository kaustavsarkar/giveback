package org.giveback.dscbanasthali.linkedlist;

public final class DllNode<T> {
    private T data;
    private DllNode<T> next;
    private DllNode<T> prev;

    DllNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DllNode<T> getNext() {
        return next;
    }

    public void setNext(DllNode<T> next) {
        this.next = next;
    }

    public DllNode<T> getPrev() {
        return prev;
    }

    public void setPrev(DllNode<T> prev) {
        this.prev = prev;
    }
}
