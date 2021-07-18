package org.giveback.dscbanasthali.linkedlist;

public abstract class DoublyLinkedList<T extends Comparable<T>> {
    private final DllNode<T> head;
    private final DllNode<T> tail;
    private int length;

    public DoublyLinkedList() {
        this.head = new DllNode<>(null);
        this.tail = new DllNode<>(null);
        tail.setPrev(head);
        head.setNext(tail);
        length = 0;
    }

    int getPosition(T data) {
        if (data == null) {
            return -1;
        }
        var currentNode = head;
        int position = 0;
        while (currentNode != null) {
            if (currentNode.getData().compareTo(data) == 0) {
                return position;
            }
            position++;
            currentNode = currentNode.getNext();
        }
        return -1;
    }

    public boolean insertAt(DllNode<T> node, int position) {
        if (position < 0 || position > length || head == null || tail == null) {
            return false;
        }

        var currentNode = head;
        for (var index = 0; index < position; index++) {
            currentNode = currentNode.getNext();
        }
        node.setNext(currentNode.getNext());
        node.setPrev(currentNode);

        node.getNext().setPrev(node);
        currentNode.setNext(node);

        length++;
        return true;
    }

    public boolean insertAtHead(DllNode<T> node) {
        return insertAt(node, 0);
    }

    public boolean insertAtTail(DllNode<T> node) {
        return insertAt(node, length);
    }

    public boolean deleteAt(int position) {
        if (position < 0 || position > length || head == null || tail == null) {
            return false;
        }

        var currentNode = head;
        for(var index = 0; index < position; index++) {
            currentNode = currentNode.getNext();
        }
        currentNode.getNext().setPrev(currentNode.getPrev());
        currentNode.getPrev().setNext(currentNode.getNext());

        length--;
        return true;
    }

    public boolean deleteAtHead() {
        return deleteAt(0);
    }

    public boolean deleteAtTail() {
        return deleteAt(length);
    }
}
