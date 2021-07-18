package org.giveback.dscbanasthali.linkedlist;

public class LinkedList<T> {
    private final ListNode<T> head;
    protected int length;

    public LinkedList() {
        this.head = new ListNode<>();
        length = 0;
    }

    public ListNode<T> getHead() {
        return head;
    }

    public int refreshLength() {
        var currentNode = head;
        // No need to create a new variable here. It is just for explanation
        // purpose.
        var tempLength = 0;
        while (currentNode != null) {
            tempLength++;
            currentNode = currentNode.getNext();
        }
        length = tempLength;
        return length;
    }

    // Can be void as well.
    public boolean insertAt(ListNode<T> newNode, int position) {
        // If we decide to keep it void then we should throw an exception.
        if (position < 0) {
            return false;
        }
        // If we decide to keep it void then we should throw an exception.
        if (position > length) {
            return false;
        }
        ListNode<T> temp = head;
        for (int index = 0; index < position; index++) {
            temp = temp.getNext();
        }
        newNode.setNext(temp.getNext());
        temp.setNext(newNode);
        length++;
        return true;
    }

    public boolean insertAtHead(ListNode<T> newNode) {
        return insertAt(newNode, 0);
    }

    public boolean insertAtTail(ListNode<T> newNode) {
        return insertAt(newNode, length);
    }

    public boolean removeAt(int position) {
        if (position < 0 || position > length || head == null) {
            return false;
        }
        var temp = head;
        for (var index = 0; index < position; index++) {
            temp = temp.getNext();
        }
        temp.setNext(temp.getNext().getNext());
        length--;
        return true;
    }

    public boolean removeAtBeginning() {
        return removeAt(0);
    }

    public boolean removeAtTail() {
        return removeAt(length);
    }

}
