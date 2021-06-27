package org.giveback.dscbanasthali.graph;

import java.util.*;

public class AlienDictionary {
    List<Integer>[] adjDictionary = new ArrayList[26];

    public String alienOrder(String[] words) {
        Map<Character,  Integer> degree = new HashMap<>();
        Map<Character, Set<Character>> graph = buildGraph(words, degree,
                new HashSet<Character>());
    }

    private Map<Character, Set<Character>> buildGraph(String[] words,
                                                      Map<Character, Integer> degree,
                                                      HashSet<Character> charSet) {
        getAllCharacters(words, degree, charSet);

    }

    private void getAllCharacters(String[] words,
                                  Map<Character, Integer> degree,
                                  HashSet<Character> charSet) {
        for(String word : words) {
            for  (var ch : word.toCharArray()) {
                charSet.add(ch);
                degree.putIfAbsent(ch, 0);
            }
        }
    }
}
