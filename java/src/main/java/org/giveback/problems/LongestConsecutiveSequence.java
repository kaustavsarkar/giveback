package org.giveback.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an unsorted array of integers nums, return the length of the longest
 * consecutive elements sequence..
 */
//Example 1:
//        Input: nums = [100,4,200,1,3,2]
//        Output: 4
//        Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4
public final class LongestConsecutiveSequence {
    public int findMaxConsecutiveBySorting(int[] array) {
        if (array == null || array.length == 0) {
            // we may also return 0
            throw new IllegalArgumentException("Input array cannot be null");
        }

        Arrays.sort(array);
        var currentSequence = 1;
        var longestSequence = 1;

        for (var index = 1; index < array.length; index++) {
            if (array[index] == array[index - 1] + 1) {
                currentSequence++;
            } else {
                // If the sequence breaks currentSequence starts from zero.
                longestSequence = Math.max(longestSequence, currentSequence);
                currentSequence = 0;
            }

        }
        return Math.max(longestSequence, currentSequence);
    }

    public int findMaxConsecutiveOpt(List<Integer> array) {
        if (array == null || array.isEmpty()) {
            // we may also return 0
            throw new IllegalArgumentException("Input array cannot be null");
        }

        int currentSequence = 1;
        int longestSequence = 1;

        Set<Integer> set = new HashSet<>(array);
        for (var num : set) {
            var currentNum = num - 1;
            while (set.contains(currentNum)) {
                currentNum --;
            }
            longestSequence = Math.max(longestSequence, num - currentNum);
            currentNum = num + 1;
            while (set.contains(currentNum)) {
                currentNum ++;
            }
            longestSequence = Math.max(longestSequence, currentNum - num);
            currentSequence = 0;
        }
        return longestSequence;
    }
}
