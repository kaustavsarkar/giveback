package org.giveback.problems;

import org.giveback.datastructures.tree.BinarySearchTree.Node;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of
 * two given nodes in the BST.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor
 * is defined between two nodes p and q as the lowest node in T that has both p
 * and q as descendants (where we allow a node to be a descendant of itself).”
 * <p>
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8 Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [2, 105]. -109 <= Node.val <=
 * 109 All Node.val are unique. p != q p and q will exist in the BST.
 */
public final class LcaBst {

    public Node<Integer> leastCommonAncestor(Node<Integer> root,
                                             Node<Integer> node1,
                                             Node<Integer> node2) {
        var current = root;
        while (current != null) {

            if (node1.getKey() > current.getKey() &&
                    node2.getKey() > current.getKey()) {
                current = current.getRightChild();
            } else if (node1.getKey() < current.getKey() &&
                    node2.getKey() < current.getKey()) {
                current = current.getLeftChild();
            } else {
                return current;
            }
        }
        throw new IllegalArgumentException("There is no common ancestor");
    }
}
