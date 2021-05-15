package org.giveback.problems;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public final class LongestConsecutiveSequenceTest {

    @Test
    public void sortTechnique() {
        int[] array = {100, 4, 200, 1, 3, 2};
        LongestConsecutiveSequence sol = new LongestConsecutiveSequence();

        var result = sol.findMaxConsecutiveBySorting(array);

        assertEquals(result, 4);
    }

    @Test
    public void optTechnique() {
        Integer[] array = {100, 4, 200, 1, 3, 2};
        LongestConsecutiveSequence sol = new LongestConsecutiveSequence();

        var result =
                sol.findMaxConsecutiveOpt(Arrays.asList(array));

        assertEquals(result, 4);
    }

    @Test
    public void optTechniqueDupeElements() {
        Integer[] array = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        LongestConsecutiveSequence sol = new LongestConsecutiveSequence();

        var result =
                sol.findMaxConsecutiveOpt(Arrays.asList(array));

        assertEquals(result, 9);
    }

    @Test
    public void sortWay_returns1() {
        int[] array = {100, 4, 200, 11, 31, 2};
        LongestConsecutiveSequence sol = new LongestConsecutiveSequence();

        var result = sol.findMaxConsecutiveBySorting(array);

        assertEquals(result, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void sortWay_emptyArray_throwsException() {
        int[] array = {};
        LongestConsecutiveSequence sol = new LongestConsecutiveSequence();

        sol.findMaxConsecutiveBySorting(array);
    }

    @Test(expected = IllegalArgumentException.class)
    public void sortWay_nullArray_throwsException() {
        int[] array = null;
        LongestConsecutiveSequence sol = new LongestConsecutiveSequence();

        sol.findMaxConsecutiveBySorting(array);
    }

    @Test
    public void sortWay_singleElementArray_returns1() {
        int[] array = {1};
        LongestConsecutiveSequence sol = new LongestConsecutiveSequence();

        var result = sol.findMaxConsecutiveBySorting(array);
        assertEquals(1, result);
    }
}

