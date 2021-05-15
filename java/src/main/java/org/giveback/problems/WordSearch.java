package org.giveback.problems;

import org.giveback.datastructures.Trie;

import java.util.AbstractMap.SimpleEntry;
import java.util.*;
import java.util.Map.Entry;

/**
 * Given an m x n board of characters and a list of strings words, return all
 * words on the board.
 * <p>
 * Each word must be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring. The same
 * letter cell may not be used more than once in a word.
 */
// Input: board =
// [[‘e’,’a’,’a’,’n’],
//   ['e','t','a','o’],
//   ['i','h","k","r"],
//   ["i","f","l","v"]],
// words = [ "oath","pea","eat","rain"]
// Output: ["eat","oath"]
public final class WordSearch {
    // Taking an {@link Entry} as tuple of (row, col).
    private final Set<Entry<Integer, Integer>> possibleMoves =
            Set.of(new SimpleEntry<>(0, 1),
                    new SimpleEntry<>(1, 0),
                    new SimpleEntry<>(0, -1),
                    new SimpleEntry<>(-1, 0));
    private Trie trie = null;

    public List<String> search(List<String> words, char[][] matrix) {
        trie = new Trie();
        // Insert words into trie.
        for (var word : words) {
            trie.insert(word);
        }

        List<String> foundWords = new ArrayList<>();

        // Traverse the matrix.
        for (var row = 0; row < matrix.length; row++) {
            for (var col = 0; col < matrix[row].length; col++) {
                var character = matrix[row][col];

                // If the character is present in the root, start a dfs.
                if (trie.getRoot().getChildren().containsKey(character)) {
                    startFinding(matrix, row, col, foundWords);
                }
            }
        }
        return foundWords;
    }

    private void startFinding(char[][] matrix, int row,
                                int col,
                                List<String> foundWords) {
        Set<SimpleEntry<Integer, Integer>> visitedCoordinates = new HashSet<>();
        Stack<SimpleEntry<Integer, Integer>> nextMoves = new Stack<>();
        nextMoves.push(new SimpleEntry<>(row, col));
        var currentNode = trie.getRoot();
        var wordFound = "";

        while (!nextMoves.isEmpty()) {
            var move = nextMoves.pop();
            if (!visitedCoordinates.add(move)) {
                continue;
            }
            int rowMove = move.getKey();
            int colMove = move.getValue();
            var character = matrix[rowMove][colMove];
            var node = currentNode.getChildren().get(character);
            if (node == null) {
                continue;
            }
            wordFound += character;
            if(node .isEnd()) {
                foundWords.add(wordFound);
            }
            if(node.isEnd() && node.getChildren().isEmpty()) {
                return;
            }
            currentNode = node;
            List<SimpleEntry<Integer, Integer>> validMoves =
                    getPossibleMoves(rowMove, colMove, matrix);

            for (var validMove : validMoves) {
                if (!visitedCoordinates.contains(validMove)) {
                    nextMoves.push(validMove);
                }
            }
        }
    }

    private List<SimpleEntry<Integer, Integer>> getPossibleMoves(int row,
                                                                 int col,
                                                                 char[][] matrix) {
        List<SimpleEntry<Integer, Integer>> validMoves = new ArrayList<>();
        for (var move : possibleMoves) {
            int nextRow = row + move.getKey();
            int nextCol = col + move.getValue();
            if (isInBounds(nextRow, nextCol, matrix)) {
                validMoves.add(new SimpleEntry<>(nextRow, nextCol));
            }
        }
        return validMoves;
    }

    private boolean isInBounds(int row, int col, char[][] matrix) {
        return row < matrix.length && row >= 0 && col < matrix[row].length &&
                col >= 0;
    }
}
