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
        if(word1.length() != word2.length())
            return false;

        //create frequency map for corresponding words
        int[] freqMap1 = new int[26];
        int[] freqMap2 = new int[26];

        //fill the maps with values
        word1.chars().forEach(i->freqMap1[i - 97]++);
        word2.chars().forEach(i->freqMap2[i - 97]++);

        //check if there exists a character that exisit in one word and does not exist in the other word
        for(int i = 0 ; i < 26 ; i++)
            if(freqMap1[i] != 0 || freqMap2[i] != 0)
                if(freqMap1[i] == 0 || freqMap2[i] == 0)
                    return false;

        //sort both maps to compare values
        Arrays.sort(freqMap1);
        Arrays.sort(freqMap2);

        //check if any value is different
        for(int i = 0 ; i < 26 ; i++)
            if(freqMap1[i] != freqMap2[i])
                return false;

        return true;

    }
}
