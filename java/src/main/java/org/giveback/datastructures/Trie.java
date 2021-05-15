package org.giveback.datastructures;

import org.giveback.annotations.Annotations.VisibleForTests;

import java.util.HashMap;
import java.util.Map;

/**
 * Provides an efficient way to store a list of strings and search them for a
 * particular string.
 * <p>
 * Trie comprises of nodes represented as {@link Node}. It shall have a root
 * node which shall contain the first characters of all the words which shall be
 * a part of the trie. And the words shall be further added on.
 * <p>
 * Reference: https://en.wikipedia.org/wiki/Trie
 */
public final class Trie {
    private final Node root;

    public Trie() {
        root = new Node();
    }

    private static void insertRec(String word, Node current, int index) {
        // If we have reached the end of word, it means there are no more
        // characters to be added and the node can be marked as end of the word.
        if (index == word.length()) {
            current.isEnd = true;
            return;
        }

        var character = word.charAt(index);
        var node = current.children.get(character);
        if (node == null) {
            node = new Node();
            current.children.put(character, node);
        }
        insertRec(word, node, index + 1);
    }

    public Node getRoot() {
        return root;
    }

    /**
     * Checks if the {@code word} is present in the {@link Trie}.
     */
    public boolean isWordPresent(String word) {
        Node current = root;
        for (var index = 0; index < word.length(); index++) {
            var character = word.charAt(index);
            if (!current.children.containsKey(character)) {
                return false;
            }
            current = current.children.get(character);
        }

        // Once we reach the end of word, we check if the trie recognises it
        // as end or not. There can be a chance the word passed is a prefix
        // for a bigger word.
        return current.isEnd;
    }

    /**
     * Uses {@link Trie#remove(String)} and provides a comprehensible name which
     * asserts that the word is present and has been removed.
     */
    public boolean findAndRemove(String word) {
        return remove(word);
    }

    public boolean remove(String word) {
        if (word == null || word.isEmpty() || word.isBlank()) {
            throw new IllegalArgumentException("Invalid word input");
        }

        var currentNode = root;
        // The node from which further trie nodes are to be deleted.
        Node targetNode = new Node();
        // Character corresponding to {@code targetNode} which needs to be
        // removed from the trie.
        char targetCharacter = '\0';
        for (var index = 0; index < word.length(); index++) {
            var character = word.charAt(index);
            var node = currentNode.children.get(character);

            // The provided word is not present in the Trie.
            if (node == null) {
                throw new IllegalArgumentException("The word does not exist " +
                        "in the Trie.");
            }

            // If the current node has more than 1 children, we need to track
            // it since the further nodes may be required to be removed from
            // the particular node. If it is less than one, then we wait for
            // the word end.
            // In case the current node is the end of word, we take a node of
            // the node and the character. Considering there could be more
            // than one words in the same branch. eg: tax, taxi.
            if (currentNode.children.size() > 1 || currentNode.isEnd) {
                targetNode = currentNode;
                targetCharacter = character;
            }
            currentNode = node;
        }

        // We have traversed till end of the word however, the trie node does
        // not represent the end of word. So we can safely say that the word
        // does not exist in trie.
        if (!currentNode.isEnd) {
            throw new IllegalArgumentException("The word does not exist in " +
                    "the Trie.");
        }

        // If the branch of trie does not go any further, we can remove the
        // word from the last found end of word.
        // Eg: if we remove trains from train, trains. We would remove s
        // character from `n` train | s.
        // Else if there are children to the current node then removing the
        // node shall not be a safe option. Say if we want to remove `train`
        // from the above example. In such case we mark our node as not the end.
        if (currentNode.children.isEmpty()) {
            targetNode.children.remove(targetCharacter);
        } else {
            currentNode.isEnd = false;
        }
        return true;
    }


    /**
     * Inserts word into trie using an iterative approach.
     * <p>
     * It iterates through the word and checks if the characters are present in
     * the {@link Node} or not. Adds them if they don't else moves ahead and
     * checks for other characters.
     *
     * @param word to be inserted in {@link Trie}.
     */
    public void insert(String word) {
        if (word == null || word.isEmpty() || word.isBlank()) {
            throw new IllegalArgumentException("There are no characters in " +
                    "the word provided");
        }
        var current = root;
        for (var index = 0; index < word.length(); index++) {
            var character = word.charAt(index);
            var node = current.children.get(character);

            // The character does not already exist in the trie branch. So we
            // should be adding it.
            if (node == null) {
                node = new Node();
                current.children.put(character, node);
            }
            current = node;
        }
        current.isEnd = true;
    }

    /**
     * Inserts words in the {@link Trie} recursively.
     * <p>
     * Uses the same logic as used in {@link Trie#insert(String)} only in
     * recursive fashion.
     *
     * @param word
     */
    public void insertRec(String word) {
        insertRec(word, root, 0);
    }

    /**
     * Represents a single node in trie.
     */
    public static class Node {
        private final Map<Character, Node> children;
        private boolean isEnd;

        public Node() {
            children = new HashMap<>();
            isEnd = false;
        }

        public Map<Character, Node> getChildren() {
            return children;
        }
    }
}