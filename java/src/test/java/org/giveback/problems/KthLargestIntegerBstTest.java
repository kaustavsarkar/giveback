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

        var claz = new KthLargestIntegerBst();
        var node = claz.recursiveTraversal(bst.getRoot(), 3);

        assertEquals(node.getKey().intValue(), 27);
    }

    @Test
    public void iter_find_thirdLargest_success() {
        int[] array = {20, 19, 25, 24, 29, 27, 28, 26};
        var bst = new BinarySearchTree<Integer>();
        for (Integer number : array) {
            bst.insert(number);
        }

        var claz = new KthLargestIntegerBst();
        var node = claz.iterativeSolution(bst.getRoot(), 3);

        assertEquals(node.getKey().intValue(), 27);
    }

    @Test
    public void morris_find_thirdLargest_success() {
        int[] array = {20, 19, 25, 24, 29, 27, 28, 26};
        var bst = new BinarySearchTree<Integer>();
        for (Integer number : array) {
            bst.insert(number);
        }

        var claz = new KthLargestIntegerBst();
        var node = claz.morrisApproach(bst.getRoot(), 3);

        assertEquals(node.getKey().intValue(), 27);
    }

    @Test
    public void kLargerThanNodes_returnsNull() {
        int[] array = {20, 19, 25, 24, 29, 27,};
        var bst = new BinarySearchTree<Integer>();
        for (Integer number : array) {
            bst.insert(number);
        }

        var claz = new KthLargestIntegerBst();
        var node = claz.recursiveTraversal(bst.getRoot(), 7);

        assertNull(node);
    }

    @Test(expected = IllegalArgumentException.class)
    public void iter_kLargerThanNodes_returnsNull() {
        int[] array = {20, 19, 25, 24, 29, 27,};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (Integer number : array) {
            bst.insert(number);
        }

        KthLargestIntegerBst claz = new KthLargestIntegerBst();
        claz.iterativeSolution(bst.getRoot(), 7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void morris_kLargerThanNodes_returnsNull() {
        int[] array = {20, 19, 25, 24, 29, 27,};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (Integer number : array) {
            bst.insert(number);
        }

        var claz = new KthLargestIntegerBst();
        claz.morrisApproach(bst.getRoot(), 7);
    }

    @Test
    public void returnsNull_nullTree() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        KthLargestIntegerBst claz = new KthLargestIntegerBst();
        Node<Integer> node = claz.recursiveTraversal(bst.getRoot(), 3);

        assertNull(node);
    }

    @Test(expected = IllegalArgumentException.class)
    public void iter_returnsNull_nullTree() {
        var bst = new BinarySearchTree<Integer>();

        var claz = new KthLargestIntegerBst();
        claz.iterativeSolution(bst.getRoot(), 3);
    }

    public void morris_returnsNull_nullTree() {
        var bst = new BinarySearchTree<Integer>();

        var claz = new KthLargestIntegerBst();
        claz.morrisApproach(bst.getRoot(), 3);
    }
}
