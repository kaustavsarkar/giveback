package org.giveback.problems;

import org.giveback.datastructures.tree.BinarySearchTree.Node;

import java.util.Stack;

/**
 * FInd Kth largest integer in a Binary Search Tree.
 * <p>
 * Input: {@link Node} root, int k
 * <p>
 * Eg: Root - 10 k - 3 Output - 15
 * <code>
 *                               10
 *                           /       \
 *                      4           20
 *                    /            /      \
 *                 2           15         40
 *</code>
 */
public final class KthLargestIntegerBst {

    private Node<Integer> kthLargestNode;
    private int nodeFromRight;

    /**
     * Morris' Algorithm helps to traverse through the tree without using an
     * extra memory. It does uses few extra iterations for that.
     *
     * @param root
     * @param k
     * @return
     */
    public Node<Integer> morrisApproach(Node<Integer> root, int k) {
        if (root == null) {
            return null;
        }
        var current = root;
        Node<Integer> predecessor = null;
        var count = 0;

        while (current != null) {
            // We have reached the max for a sub-tree.
            if (current.getRightChild() == null) {
                count++;
                current = current.getLeftChild();
            } else {
                // If there are elements to the right then we find the left
                // most child of the right sub tree and assign the current
                // node to the left child.
                predecessor = current.getRightChild();
                while (predecessor.getLeftChild() != null &&
                        !predecessor.getLeftChild().equals(current)) {
                    predecessor = predecessor.getLeftChild();
                }
                // If the left child to the predecessor is null then we
                // assign current node to it.
                if (predecessor.getLeftChild() == null) {
                    predecessor.setLeftChild(current);
                    current = current.getRightChild();
                } else {
                    predecessor.setLeftChild(null);
                    count++;
                    current = current.getLeftChild();
                }
            }
            if (count + 1 == k && current != null) {
                return current;
            }
        }
        throw new IllegalArgumentException("Tree is smaller than k");
    }

    public Node<Integer> iterativeSolution(Node<Integer> root, int k) {
        var nodeStack = new Stack<Node<Integer>>();
        var current = root;
        var kthNumber = 0;

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
