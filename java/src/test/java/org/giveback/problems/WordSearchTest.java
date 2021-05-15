package org.giveback.problems;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public final class WordSearchTest {

    @Test
    public void searchWord_test1() {
        char[][] matrix = {
                {'e', 'a', 'a', 'n'},
                {'e', 't', 'a', 'o'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}};
        List<String> words = List.of("oath", "pea", "eat", "rain");

        WordSearch wordSearch = new WordSearch();
        List<String> result = wordSearch.search(words, matrix);

        assertThat(result, containsInAnyOrder("oath", "eat"));
    }

    @Test
    public void searchWord_continuingWords() {
        char[][] matrix = {
                {'e', 'a', 'a', 'n'},
                {'e', 't', 'a', 'o'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}};
        List<String> words = List.of("oath", "pea", "eat", "rain", "oathf",
                "eath");

        WordSearch wordSearch = new WordSearch();
        List<String> result = wordSearch.search(words, matrix);

        assertThat(result, containsInAnyOrder("oath", "eat", "oathf", "eath"));
    }

    @Test
    public void searchWord_emtpyListOfWords() {
        char[][] matrix = {
                {'e', 'a', 'a', 'n'},
                {'e', 't', 'a', 'o'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}};
        List<String> words = List.of();

        WordSearch wordSearch = new WordSearch();
        List<String> result = wordSearch.search(words, matrix);

        assertTrue(result.isEmpty());
    }

    @Test
    public void searchWord_emptyMatrix() {
        char[][] matrix = {};
        List<String> words = List.of("oath", "pea", "eat", "rain", "oathf",
                "eath");

        WordSearch wordSearch = new WordSearch();
        List<String> result = wordSearch.search(words, matrix);

        assertTrue(result.isEmpty());
    }
}
