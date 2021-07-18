#include "gtest/gtest.h"
#include "longestConsecutiveSequence.cpp"

TEST(longestConsecutive_Test, Test01)
{
    LongestConsecutive s;

    int arr[] = {100, 4, 200, 1, 3, 2};
    vector<int> array(arr, arr + sizeof(arr) / sizeof(int));

    int expected = 4;

    EXPECT_EQ(expected, s.longestConsecutive(array));

    array.clear();
}

TEST(longestConsecutive_Test, Test02)
{
    LongestConsecutive s;

    int arr[] = {100, 4, 1, 3, 99, 5};
    vector<int> array(arr, arr + sizeof(arr) / sizeof(int));

    int expected = 3;

    EXPECT_EQ(expected, s.longestConsecutive(array));

    array.clear();
}

TEST(longestConsecutive_Test, Test03)
{
    LongestConsecutive s;

    int arr[] = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
    vector<int> array(arr, arr + sizeof(arr) / sizeof(int));

    int expected = 9;

    EXPECT_EQ(expected, s.longestConsecutive(array));

    array.clear();
}
