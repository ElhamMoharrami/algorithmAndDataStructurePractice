package com.practice.algorithmanddatastructure.leetcode;

public class GreatestCommonDivisorOfStrings {
    public static void main(String[] args) {
        String s1 = "AAAAAAAAA";
        String s2 = "AAACCC";
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        int a = s1Arr.length;
        int b = s2Arr.length;
        while (b != 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }
        System.out.println(a);
        char[] result = new char[a];
        int k = 0;
        for (int i = 0; i < a; i++) {
            if (s1Arr[k] == s2Arr[k]) {
                result[i] = s1Arr[k];
                k++;
            }
        }
        System.out.println(new String(result));
        check(result, s1Arr);
        check(result, s2Arr);

        boolean isEmpty = true;
        for (char c : result) {
            if (c != '\u0000') {
                isEmpty = false;
                break;
            }
        }

        if (isEmpty) {
            System.out.println("");
        } else {
            System.out.println(new String(result));
        }

    }
    public static void check(char[] result, char[] strArr) {
        int j = 0;
        for (int i = 0; i < strArr.length; i++) {
            if (j == result.length) {
                j = 0;
            }
            if (strArr[i] == result[j]) {
                j++;
            } else {
                System.out.println("Emptyyyyyyyy");
            }
        }
    }
}

/*
For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).
Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
Example 1:
Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"
 */

/*
Runtime
2
ms
Beats
20.04%
of users with Java
 Memory
42.05
MB
Beats
52.25%
of users with Java
 */

/*better solution*/

/*
class Solution {
    int gcd(int n, int m) {
        while (m != 0) {
            int temp = m;
            m = n % m;
            n = temp;
        }
        return n;
    }
    public String gcdOfStrings(String str1, String str2) {
        //this means both strings are nothing but repetition of the ag string
        if((str1+str2).equals(str2+str1)){
            int index=gcd(str1.length(),str2.length());
            return str1.substring(0,index);
        }
        return "";
    }
}*/
