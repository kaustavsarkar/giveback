package org.giveback.datastructures;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class TrieTest {
    private static final List<String> words = List.of("train", "trains",
            "tramp", "ramp", "rage", "noise", "nose");
    private Trie trie;

    @Before
    public void setUp() {
        trie = new Trie();

        for (var word : words) {
            trie.insert(word);
        }
    }

    @Test
    public void rootHasThreeChildren() {
        var node = trie.getRoot();

        assertEquals(node.getChildren().size(), 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void insert_emptyString_throwsError() {
        trie.insert("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void insert_blankString_throwsError() {
        trie.insert("  ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void insert_nullString_throwsError() {
        trie.insert(null);
    }

    @Test
    public void insert_recursively_success() {
        trie.insertRec("rain");

        assertTrue(trie.isWordPresent("rain"));
    }

    @Test
    public void containsAllWordsInTheList() {
        assertTrue(trie.isWordPresent("train"));
        assertTrue(trie.isWordPresent("trains"));
        assertTrue(trie.isWordPresent("tramp"));
        assertTrue(trie.isWordPresent("ramp"));
        assertTrue(trie.isWordPresent("rage"));
        assertTrue(trie.isWordPresent("noise"));
        assertTrue(trie.isWordPresent("nose"));
    }

    @Test
    public void isWordPresent_forUnknownWord_returnsFalse() {
        assertFalse(trie.isWordPresent("something"));
    }

    @Test
    public void removesExistingWordSuccessfully() {
        trie.remove("train");

        assertFalse(trie.isWordPresent("train"));
    }

    @Test
    public void removesExistingWord_pruneNode_Successfully() {
        trie.remove("trains");

        assertFalse(trie.isWordPresent("trains"));
        assertTrue(trie.isWordPresent("train"));
    }

    @Test
    public void findAndRemovesExistingWord_pruneNode_Successfully() {
        trie.findAndRemove("trains");

        assertFalse(trie.isWordPresent("trains"));
        assertTrue(trie.isWordPresent("train"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void remove_emptyString_throwsException() {
        trie.remove("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void remove_nonexistentString_throwsException() {
        trie.remove("rain");
    }

    @Test(expected = IllegalArgumentException.class)
    public void remove_partiallyMatchingShortString_throwsException() {
        trie.remove("trai");
    }

    @Test(expected = IllegalArgumentException.class)
    public void remove_partiallyMatchingLongString_throwsException() {
        trie.remove("trainsa");
    }

    @Test(expected = IllegalArgumentException.class)
    public void remove_blankString_throwsError() {
        trie.remove(" ");
    }
}
