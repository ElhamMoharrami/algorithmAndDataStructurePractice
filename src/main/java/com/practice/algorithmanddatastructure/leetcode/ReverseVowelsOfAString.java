package com.practice.algorithmanddatastructure.leetcode;

public class ReverseVowelsOfAString {
    public static void main(String[] args) {
  /*      String result = reverseVowels("leetcode");
        System.out.println(result);
        String res1 = reverseVowels("hello");
        System.out.println(res1);
        String res2 = reverseVowels(" ");
        System.out.println(res2);*/
        String res3= reverseVowels("race a car");
        System.out.println(res3);
    }

    public static String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int frontPointer = 0;
        int endPointer = arr.length - 1;
        if (frontPointer == endPointer) {
            return s;
        }
        while (frontPointer < endPointer) {
            if (!isVowel(arr[frontPointer])) {
                frontPointer++;
            }
            if (!isVowel(arr[endPointer])) {
                endPointer--;
            }
            if (isVowel(arr[frontPointer]) && isVowel(arr[endPointer])) {
                char temp = arr[frontPointer];
                arr[frontPointer] = arr[endPointer];
                arr[endPointer] = temp;
                endPointer--;
                frontPointer++;
            }
        }
        return new String(arr);
    }

    public static boolean isVowel(char ch) {
        if (ch == 'i' || ch == 'I' || ch == 'E' || ch == 'e' || ch == 'O'
                || ch == 'o' || ch == 'A' || ch == 'a' || ch == 'u' || ch == 'U') {
            return true;
        }
        return false;
    }
}


/*Runtime
3
ms
Beats
80.30%
of users with Java*/

/*Memory
44.30
MB
Beats
95.28%
of users with Java*/

/*Given a string s, reverse only all the vowels in the string and return it.
The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
Example 1:
Input: s = "hello"
Output: "holle"
Example 2:
Input: s = "leetcode"
Output: "leotcede"
Constraints:
1 <= s.length <= 3 * 105
s consist of printable ASCII characters.*/