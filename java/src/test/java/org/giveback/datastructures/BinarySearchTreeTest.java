package org.giveback.datastructures;

import org.giveback.datastructures.tree.BinarySearchTree;
import org.giveback.datastructures.tree.BinarySearchTree.Node;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public final class BinarySearchTreeTest {

    @Test
    public void insertIsValid_test1() {
        int[] array = {2, 1, 3};
        var bst = new BinarySearchTree<Integer>();
        for (var num : array) {
            bst.insert(num);
        }

        List<Integer> list = getInorder(bst);
        assertTrue(isAscSorted(list));
    }

    @Test
    public void recInsertIsValid_test1() {
        int[] array = {2, 1, 3};
        var bst = new BinarySearchTree<Integer>();
        for (var num : array) {
            bst.insertRecur(num);
        }

        List<Integer> list = getInorder(bst);
        assertTrue(isAscSorted(list));
    }

    @Test
    public void insertIsValid_test2() {
        int[] array = {1, 2, 3, 4, 5};
        var bst = new BinarySearchTree<Integer>();
        for (var num : array) {
            bst.insert(num);
        }

        List<Integer> list = getInorder(bst);
        assertTrue(isAscSorted(list));
    }

    @Test
    public void insertIsValid_test3() {
        int[] array = {5, 4, 3, 2, 1};
        var bst = new BinarySearchTree<Integer>();
        for (var num : array) {
            bst.insert(num);
        }

        List<Integer> list = getInorder(bst);
        assertTrue(isAscSorted(list));
    }

    private boolean isAscSorted(List<Integer> list) {
        for (var index = 1; index < list.size(); index++) {
            if (list.get(index) < list.get(index - 1)) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> getInorder(BinarySearchTree<Integer> bst) {
        var sortedList = new ArrayList<Integer>();
        fillList(bst.getRoot(), sortedList);
        return sortedList;
    }

    private void fillList(Node<Integer> node,
                          List<Integer> sortedList) {
        if (node.getLeftChild() != null) {
            fillList(node.getLeftChild(), sortedList);
        }

        sortedList.add(node.getKey());

        if (node.getRightChild() != null) {
            fillList(node.getRightChild(), sortedList);
        }
    }
}
