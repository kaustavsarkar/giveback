package org.giveback.datastructures.tree;

import java.util.Objects;

/**
 * Implements Binary Search Tree.
 * <p>
 * Parameter {@code T} must be comparable. For coding interviews this can be
 * ignored though.
 */
public final class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;

    public Node<T> getRoot() {
        return root;
    }

    public void insert(T key) {
        // If this is the first node to be added in the Tree.
        if (root == null) {
            root = new Node<>(key);
            return;
        }
        var current = root;
        // Keeps track of the trailing node to attach the new node wherever
        // there is no successor.
        Node<T> previousNode = null;
        while (current != null) {
            previousNode = current;
            if (key.compareTo(current.key) > 0) {
                current = current.rightChild;
            } else {
                current = current.leftChild;
            }
        }

        if (key.compareTo(previousNode.key) > 0) {
            previousNode.rightChild = new Node<>(key);
        } else {
            previousNode.leftChild = new Node<>(key);
        }
    }

    public void insertRecur(T key) {
        root = insertRecur(root, key);
    }

    private Node<T> insertRecur(Node<T> node, T key) {
        if (node == null) {
            return new Node<>(key);
        }

        if (key.compareTo(node.key) > 0) {
            node.rightChild = insertRecur(node.rightChild, key);
        } else {
            node.leftChild = insertRecur(node.leftChild, key);
        }
        return node;
    }

    public static class Node<T> {
        private Node<T> leftChild;
        private Node<T> rightChild;
        private T key;

        public Node() {
        }

        public Node(T key) {
            this.key = key;
        }

        public Node<T> getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(
                Node<T> leftChild) {
            this.leftChild = leftChild;
        }

        public Node<T> getRightChild() {
            return rightChild;
        }

        public void setRightChild(
                Node<T> rightChild) {
            this.rightChild = rightChild;
        }

        public T getKey() {
            return key;
        }

        public void setKey(T key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node<?> node = (Node<?>) o;
            return Objects.equals(getKey(), node.getKey());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getKey());
        }
    }
}
