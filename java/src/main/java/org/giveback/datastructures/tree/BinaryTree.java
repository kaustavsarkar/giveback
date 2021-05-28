package org.giveback.datastructures.tree;

public class BinaryTree<T> {

    public static class Node<T> {
        private BinarySearchTree.Node<T> leftChild;
        private BinarySearchTree.Node<T> rightChild;
        private T key;

        public Node() {
        }

        public Node(T key) {
            this.key = key;
        }

        public BinarySearchTree.Node<T> getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(
                BinarySearchTree.Node<T> leftChild) {
            this.leftChild = leftChild;
        }

        public BinarySearchTree.Node<T> getRightChild() {
            return rightChild;
        }

        public void setRightChild(
                BinarySearchTree.Node<T> rightChild) {
            this.rightChild = rightChild;
        }

        public T getKey() {
            return key;
        }

        public void setKey(T key) {
            this.key = key;
        }
    }
}
