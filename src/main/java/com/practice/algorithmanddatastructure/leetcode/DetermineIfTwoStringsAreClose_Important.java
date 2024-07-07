package com.practice.algorithmanddatastructure.leetcode;

import java.util.*;

public class DetermineIfTwoStringsAreClose_Important {
    public static void main(String[] args) {
        System.out.println(closeStrings("abc", "bca"));//true
        System.out.println(closeStrings("a", "aa"));//false
        System.out.println(closeStrings("cabbba", "abbccc"));//true
        System.out.println(closeStrings("abbzzca", "babzzcz"));//false
    }

    public static boolean closeStrings(String word1, String word2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (char ch : word1.toCharArray()) {
            freq1[ch - 'a']++;
        }

        for (char ch : word2.toCharArray()) {
            freq2[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if ((freq1[i] == 0 && freq2[i] != 0) || (freq1[i] != 0 && freq2[i] == 0)) {
                return false;
            }
        }

        Arrays.sort(freq1);
        Arrays.sort(freq2);

        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }

        return true;
    }
}
