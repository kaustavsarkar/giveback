package org.giveback.dscbanasthali.linkedlist;

public final class CllProblem {

    public ListNode<Integer> findLoopAndBeginning(ListNode<Integer> head) {
        ListNode<Integer> slowPtr = head;
        ListNode<Integer> fastPtr = head;
        boolean hasLoop = false;
        while (fastPtr != null && fastPtr.getNext() != null) {
            fastPtr = fastPtr.getNext().getNext();
            slowPtr = slowPtr.getNext();

            if (fastPtr.getValue().compareTo(slowPtr.getValue()) == 0) {
                hasLoop = true;
                break;
            }
        }

        if (hasLoop) {
            slowPtr = head;
            while (slowPtr.getValue().compareTo(fastPtr.getValue()) != 0) {
                slowPtr = slowPtr.getNext();
                fastPtr = fastPtr.getNext();
            }
            return slowPtr;
        }
        return null;
    }
}
