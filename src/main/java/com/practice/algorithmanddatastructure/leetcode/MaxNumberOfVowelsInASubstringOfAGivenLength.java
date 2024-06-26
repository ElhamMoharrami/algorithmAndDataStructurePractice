package com.practice.algorithmanddatastructure.leetcode;

public class MaxNumberOfVowelsInASubstringOfAGivenLength {
    public static void main(String[] args) {
        System.out.println(maxVowels("abciiidef", 3));//3
        System.out.println(maxVowels("aeiou", 2));//2
        System.out.println(maxVowels("leetcode", 3));//2
        System.out.println(maxVowels("tryhard", 4));//1
        System.out.println(maxVowels("weallloveyou", 7));//4
    }
    public static int maxVowels(String s, int k) {
        int window = 0;
        int maxVowels = 0;
        int vowelCount = 0;
        char[] arr = s.toCharArray();
        int indexChecker = 0;
        for (char character : arr) {
            if (window == k) {
                if (vowelCount > maxVowels) {
                    maxVowels = vowelCount;
                }
                if (isVowel(arr[indexChecker])) {
                    vowelCount--;
                }
                indexChecker++;
                window--;
            }
            if (!isVowel(character)) {
                window++;
            }
            if (isVowel(character)) {
                vowelCount++;
                window++;
            }
        }
        if (vowelCount > maxVowels) {
            maxVowels = vowelCount;
        }
        return maxVowels;
    }

    public static boolean isVowel(char character) {
        return character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u';
    }
}

/*Runtime
13
ms
Beats
70.94%
*/

/*Memory
45.12
MB
Beats
12.34%*/

/*Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
Example 1:
Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.
Example 2:
Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.
Example 3:
Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.
Constraints:
1 <= s.length <= 105
s consists of lowercase English letters.
1 <= k <= s.length*/

/*class Solution {
    public int maxVowels(String s, int k) {
        int vowel = 0;
        for(int i =0; i< k; i++)
            if(isVowel(s.charAt(i))) vowel++;
        int max = vowel;
        for(int i = k; i < s.length(); i++){
            if(isVowel(s.charAt(i))) vowel++;
            // if the character that falls out of the substring on the left side is a vowel
            if(isVowel(s.charAt(i-k))) vowel--;
            max = Math.max(max, vowel);
        }
        return max;
    }
    private boolean isVowel(char c){
        if((c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')) return true;
        return false;
    }
}*/