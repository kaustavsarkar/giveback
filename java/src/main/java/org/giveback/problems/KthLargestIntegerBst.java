package org.giveback.problems;

import org.giveback.datastructures.tree.BinarySearchTree.Node;

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

    public Node<Integer> recursiveTraversal(Node<Integer> root, int k) {
        recurRight(root, k);
        return kthLargestNode;
    }

    private void recurRight(Node<Integer> node, int k) {
        if (node == null) {
            return;
        }
        recurRight(node.getRightChild(), k);
        if (kthLargestNode != null) {
            return;
        }
        nodeFromRight++;
        if (nodeFromRight == k) {
            kthLargestNode = node;
            return;
        }

        recurRight(node.getLeftChild(), k);

    }
}
