package org.giveback.problems;

import org.giveback.datastructures.tree.BinarySearchTree.Node;

import java.util.Stack;

/**
 * FInd Kth largest integer in a Binary Search Tree.
 * <p>
 * Input: {@link Node} root, int k
 * <p>
 * Eg: Root - 10 k - 3 Output - 15 10 /      \ 4          20 /            /   \
 * 2           15     40
 */
public final class KthLargestIntegerBst {

    private Node<Integer> kthLargestNode;
    private int nodeFromRight;

    public Node<Integer> iterativeSolution(Node<Integer> root, int k) {
        Stack<Node<Integer>> nodeStack = new Stack<>();
        Node<Integer> current = root;
        int kthNumber = 0;

        while (current != null || !nodeStack.isEmpty()) {
            while (current != null) {
                nodeStack.push(current);
                current = current.getRightChild();
            }
            current = nodeStack.pop();
            kthNumber++;
            if (kthNumber == k) {
                return current;
            }
            current = current.getLeftChild();
        }
        throw new IllegalArgumentException("There is no such element");
    }

    public Node<Integer> recursiveTraversal(Node<Integer> root, int k) {
        recurRight(root, k);
        return kthLargestNode;
    }

    private void recurRight(Node<Integer> node, int k) {
        if (node == null) {
            return;
        }

        // Reach the right end for reaching the largest element in the sub-tree.
        recurRight(node.getRightChild(), k);

        // If the kthLargestNode is identified already, then we should not
        // move ahead.
        if (kthLargestNode != null) {
            return;
        }

        // Once returned from the right most node, means we have found the
        // next largest element.
        nodeFromRight++;

        // May reach the kth element here.
        if (nodeFromRight == k) {
            kthLargestNode = node;
            return;
        }

        // Move left.
        recurRight(node.getLeftChild(), k);

    }
}
