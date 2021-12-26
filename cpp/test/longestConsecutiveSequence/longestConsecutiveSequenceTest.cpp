#include "gtest/gtest.h"
#include "longestConsecutiveSequence.cpp"

TEST(longestConsecutive_Test, Test01)
{
    // Arrange
    LongestConsecutive s;
    int arr[] = {100, 4, 200, 1, 3, 2};
    vector<int> array(arr, arr + sizeof(arr) / sizeof(int));
    int expectedAnswer = 4;

    // Act
    int result = s.longestConsecutive(array);

    // Assert
    EXPECT_EQ(expectedAnswer, result);

    array.clear();
}

TEST(longestConsecutive_Test, Test02)
{
    // Arrange
    LongestConsecutive s;
    int arr[] = {100, 4, 1, 3, 99, 5};
    vector<int> array(arr, arr + sizeof(arr) / sizeof(int));
    int expectedAnswer = 3;

    // Act
    int result = s.longestConsecutive(array);

    // Assert
    EXPECT_EQ(expectedAnswer, result);

    array.clear();
}

TEST(longestConsecutive_Test, Test03)
{
    // Arrange
    LongestConsecutive s;
    int arr[] = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
    vector<int> array(arr, arr + sizeof(arr) / sizeof(int));
    int expectedAnswer = 9;

    // Act
    int result = s.longestConsecutive(array);

    // Assert
    EXPECT_EQ(expectedAnswer, result);

    array.clear();
}
