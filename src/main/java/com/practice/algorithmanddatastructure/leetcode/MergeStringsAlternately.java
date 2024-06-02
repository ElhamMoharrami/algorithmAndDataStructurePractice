package com.practice.algorithmanddatastructure.leetcode;

import java.util.Arrays;

public class MergeStringsAlternately {
    public static void main(String[] args) {
        merge("abc", "pqr");//expected: apbqcr
        merge("ab", "pqrs");//expected: apbqrs
        merge("abcd", "pq");//apbqcd
    }

    private static void merge(String string1, String string2) {
        char[] string1Arr = string1.toCharArray();
        char[] string2Arr = string2.toCharArray();
        int string1ArrLength = string1Arr.length;
        int string2ArrLength = string2Arr.length;
        char[] result = new char[string1ArrLength + string2ArrLength];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i <= string1ArrLength - 1 && j <= string2ArrLength - 1) {
            result[k] = string1Arr[i];
            k++;
            i++;
            result[k] = string2Arr[j];
            k++;
            j++;
        }

        while (i <= string1ArrLength - 1) {
            result[k] = string1Arr[i];
            k++;
            i++;
        }

        while (j <= string2ArrLength - 1) {
            result[k] = string2Arr[j];
            k++;
            j++;
        }
        String resultString = new String(result);
        System.out.println(resultString);
    }

}

/*
Runtime
0
ms
Beats
100.00%
of users with Java

41.71
MB
Beats
46.16%
of users with Java
 */

//problem:
/*You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.

Return the merged string.
Example 1:
Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
Explanation: The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r
Example 2:
Input: word1 = "ab", word2 = "pqrs"
Output: "apbqrs"
Explanation: Notice that as word2 is longer, "rs" is appended to the end.
word1:  a   b
word2:    p   q   r   s
merged: a p b q   r   s
Example 3:
Input: word1 = "abcd", word2 = "pq"
Output: "apbqcd"
Explanation: Notice that as word1 is longer, "cd" is appended to the end.
word1:  a   b   c   d
word2:    p   q
merged: a p b q c   d
Constraints:
1 <= word1.length, word2.length <= 100
word1 and word2 consist of lowercase English letters.*/