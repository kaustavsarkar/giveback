package org.giveback.dscbanasthali.linkedlist;

public final class ReverseALinkedList {

    public ListNode<Integer> iterativeSolution(ListNode<Integer> head) {
        // We start from head.
        var currentNode = head;
        // Node prev the head is null.
        ListNode<Integer> prevNode = null;

        while (currentNode != null) {
            // Let an object save the next node.
            var nextNode = currentNode.getNext();

            // Now we can remove the reference of current node from its next
            // node and point it to the previous node.
            currentNode.setNext(prevNode);

            // Now my current should become previous.
            prevNode = currentNode;

            // At this point the linked list shall look something like this
            // after first iteration
            // null <- 1 <- prev    curr -> 2 ->3 ....
            // There is a disconnect in current and prev which the algo shall
            // be filling up..

            // Let us move ahead.
            currentNode = nextNode;
        }
        return prevNode;
    }
}
