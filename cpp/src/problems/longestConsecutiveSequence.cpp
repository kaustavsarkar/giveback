#include <bits/stdc++.h>
using namespace std;

/**
 * Given an unsorted array of integers array, return the length of the longest
 * consecutive elements sequence
 */

//Example 1:
//        Input: array = [100,4,200,1,3,2]
//        Output: 4
//        Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4

// Example 2:
//        Input: array = [0,3,7,2,5,8,4,6,0,1]
//        Output: 9

class LongestConsecutive
{
public:
    int longestConsecutive(vector<int> &array)
    {
        if (array.empty())
            return 0;
        unordered_set<int> record(array.begin(), array.end());
        int longestSequence = 0;
        for (auto &num : record)
        {
            if (record.count(num - 1))
                continue;
            int currentSequence = 1;
            while (record.count(num + currentSequence))
                currentSequence++;
            longestSequence = max(longestSequence, currentSequence);
        }
        return longestSequence;
    }
};

/* unit test is in ../src/test/longestConsecutiveSequenceTest */
