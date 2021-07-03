package org.giveback.dscbanasthali.graph;

import java.util.*;

public class AlienDictionary {

    public String alienOrder(String[] words) {
        Map<Character, Integer> degree = new HashMap<>();
        Map<Character, Set<Character>> graph = buildGraph(words, degree,
                new HashSet<Character>());


        // Topological sort.
        Queue<Character> zeroDegreeNodes = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry : degree.entrySet()) {
            if (entry.getValue() == 0) {
                zeroDegreeNodes.offer(entry.getKey());
            }
        }

        StringBuilder result = new StringBuilder();

        while (!zeroDegreeNodes.isEmpty()) {
            char vertex = zeroDegreeNodes.poll();
            result.append(vertex);
            Set<Character> neighbors = graph.get(vertex);
            if (neighbors != null) {
                for (char neighbor : graph.get(vertex)) {
                    int count = degree.get(neighbor);
                    count--;
                    if (count == 0) {
                        zeroDegreeNodes.offer(neighbor);
                    } else {
                        degree.put(neighbor, count);
                    }
                }
            }
            graph.remove(vertex);
        }

        return graph.size() > 0 ? "" : result.toString();
    }

    private Map<Character, Set<Character>> buildGraph(String[] words,
                                                      Map<Character, Integer> degree,
                                                      HashSet<Character> charSet) {
        // Get all the characters we have in a set and initialise their
        // degrees with 0 in the map.
        getAllCharacters(words, degree, charSet);

        Set<Character> allChars = new HashSet<>(charSet);
        Map<Character, Set<Character>> graph = new HashMap<>();

        // Create the graph by taking combinations of two words at a time.
        for (var wIndex = 0; wIndex < words.length - 1; wIndex++) {
            String currWord = words[wIndex];
            String nextWord = words[wIndex + 1];

            // Take the smaller length between the two.
            for (var charLength = 0; charLength < Math.min(currWord.length(),
                    nextWord.length()); charLength++) {

                // If the two characters of the word are not the same, then
                // we need to check which character comes before the other.
                if (currWord.charAt(charLength) !=
                        nextWord.charAt(charLength)) {

                    // To make sure only the words left are added in the graph.
                    allChars.remove(currWord.charAt(charLength));

                    // If the graph does not contain the character yet, add
                    // an empty set.
                    Set<Character> set =
                            graph.computeIfAbsent(currWord.charAt(charLength),
                                    k -> new HashSet<>());

                    // Add the character in the set.
                    set.add(nextWord.charAt(charLength));

                    // Add the degree against the character.
                    degree.compute(nextWord.charAt(charLength),
                            (key, count) -> count + 1);
                }
            }
        }
        for (char ch : allChars) {
            graph.put(ch, null);
        }
        return graph;
    }

    private void getAllCharacters(String[] words,
                                  Map<Character, Integer> degree,
                                  HashSet<Character> charSet) {
        for (String word : words) {
            for (var ch : word.toCharArray()) {
                charSet.add(ch);
                degree.putIfAbsent(ch, 0);
            }
        }
    }
}
