package com.practice.algorithmanddatastructure.leetcode;

import java.util.*;

public class FindTheDifferenceOfTwoArrays {
    public static void main(String[] args) {
        System.out.println(findDifference(new int[]{1, 2, 3}, new int[]{2, 4, 6}));//[[1,3],[4,6]]
        System.out.println(findDifference(new int[]{1, 2, 3, 3}, new int[]{1, 1, 2, 2}));//[[3],[]]
        System.out.println(findDifference(new int[]{-80, -15, -81, -28, -61, 63, 14, -45, -35, -10},
                new int[]{-1, -40, -44, 41, 10, -43, 69, 10, 2}));//[[-81,-35,-10,-28,-61,-45,-15,14,-80,63],[-1,2,69,-40,41,10,-43,-44]]
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = convert(nums1);
        Set<Integer> set2 = convert(nums2);
        Iterator<Integer> iter = set1.iterator();
        while (iter.hasNext()) {
            Integer integer = iter.next();
            if (set2.contains(integer)) {
                iter.remove();
                set2.remove(integer);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>(set1);
        List<Integer> l2 = new ArrayList<>(set2);
        result.add(l1);
        result.add(l2);
        return result;
    }

    static Set<Integer> convert(int[] array) {
        // Hash Set Initialisation
        Set<Integer> Set = new HashSet<>();

        // Iteration using enhanced for loop
        for (int element : array) {
            Set.add(element);
        }
        // returning the set
        return Set;
    }
}


/*Runtime:10ms
Beats:81.94%
Memory:45.06MB
Beats:90.15%
Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
Note that the integers in the lists may be returned in any order.
Example 1:
Input: nums1 = [1,2,3], nums2 = [2,4,6]
Output: [[1,3],[4,6]]
Explanation:
For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums2. Therefore, answer[1] = [4,6].
Example 2:
Input: nums1 = [1,2,3,3], nums2 = [1,1,2,2]
Output: [[3],[]]
Explanation:
For nums1, nums1[2] and nums1[3] are not present in nums2. Since nums1[2] == nums1[3], their value is only included once and answer[0] = [3].
Every integer in nums2 is present in nums1. Therefore, answer[1] = [].
Constraints:
1 <= nums1.length, nums2.length <= 1000
-1000 <= nums1[i], nums2[i] <= 1000
*/



/*brute force:
Runtime:93ms
Beats:8.34%
Memory:45.36MB
Beats:46.05%

   List<List<Integer>> result = new ArrayList<>();
        List<Integer> n1List = new ArrayList<>();
        List<Integer> n2List = new ArrayList<>();
        for (int k : nums1) {
            boolean exists = false;
            for (int i : nums2) {
                if (k == i) {
                    exists = true;
                    break;
                }
            }
            if (!exists && !n1List.contains(k)) {
                n1List.add(k);
            }
        }

        for (int k : nums2) {
            boolean exists = false;
            for (int i : nums1) {
                if (k == i) {
                    exists = true;
                    break;
                }
            }
            if (!exists  && !n2List.contains(k)) {
                n2List.add(k);
            }
        }
        result.add(n1List);
        result.add(n2List);
        return result;
*/