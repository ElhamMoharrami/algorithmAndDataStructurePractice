package com.practice.algorithmanddatastructure.leetcode;

import java.util.Arrays;
import java.util.Objects;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        String result = reverseWords("a good   example");
    }

    public static String reverseWords(String s) {
        if (s.trim().isEmpty()) {
            return "";
        }
        String[] sArr = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = sArr.length - 1; i >= 0; i--) {
            if (!sArr[i].trim().isEmpty()) {
                stringBuilder.append(sArr[i].trim());
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString().trim();
    }
}

/*Runtime
6
ms
Beats
84.76%
of users with Java*/


/*Memory
42.64
MB
Beats
85.03%
of users with Java*/


/*Given an input string s, reverse the order of the words.
A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
Return a string of the words in reverse order concatenated by a single space.
Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string
 should only have a single space separating the words. Do not include any extra spaces.
Example 1:
Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:
Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:
Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
Constraints:
1 <= s.length <= 104
s contains English letters (upper-case and lower-case), digits, and spaces ' '.
There is at least one word in s.
Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?*/