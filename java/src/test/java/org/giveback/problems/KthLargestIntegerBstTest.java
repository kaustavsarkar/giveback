package org.giveback.problems;

import org.giveback.datastructures.tree.BinarySearchTree;
import org.giveback.datastructures.tree.BinarySearchTree.Node;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(JUnit4.class)
public final class KthLargestIntegerBstTest {

    @Test
    public void find_thirdLargest_success() {
        int[] array = {20, 19, 25, 24, 29, 27, 28, 26};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (Integer number : array) {
            bst.insert(number);
        }

        KthLargestIntegerBst claz = new KthLargestIntegerBst();
        Node<Integer> node = claz.recursiveTraversal(bst.getRoot(), 3);

        assertEquals(node.getKey().intValue(), 27);
    }

    @Test
    public void kLargerThanNodes_returnsNull() {
        int[] array = {20, 19, 25, 24, 29, 27,};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (Integer number : array) {
            bst.insert(number);
        }

        KthLargestIntegerBst claz = new KthLargestIntegerBst();
        Node<Integer> node = claz.recursiveTraversal(bst.getRoot(), 7);

        assertNull(node);
    }

    @Test
    public void returnsNull_nullTree() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        KthLargestIntegerBst claz = new KthLargestIntegerBst();
        Node<Integer> node = claz.recursiveTraversal(bst.getRoot(), 3);

        assertNull(node);
    }
}
