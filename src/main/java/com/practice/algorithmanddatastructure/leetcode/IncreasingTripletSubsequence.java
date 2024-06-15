package com.practice.algorithmanddatastructure.leetcode;

public class IncreasingTripletSubsequence {
    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[]{1, 2, 3, 4, 5}));//true
        System.out.println(increasingTriplet(new int[]{1, 6, 2, 5, 1}));//true
        System.out.println(increasingTriplet(new int[]{2, 1, 5, 0, 4, 6}));//true
        System.out.println(increasingTriplet(new int[]{5, 4, 3, 2, 1}));//false
        System.out.println(increasingTriplet(new int[]{20, 100, 10, 12, 5, 13}));//false
        System.out.println(increasingTriplet(new int[]{2, 4, -2, -3}));//false
        System.out.println(increasingTriplet(new int[]{5, 1, 6}));//false
        System.out.println(increasingTriplet(new int[]{6, 7, 1, 2}));//false
    }

    public static boolean increasingTriplet(int[] nums) {
        //the indices are always increasing when we are looping from left to right so no need to check for that
        if (nums.length < 3) {
            return false;
        }
        int i = Integer.MAX_VALUE;
        int j = Integer.MAX_VALUE;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] <= i) {
                i = nums[k];
            } else if (nums[k] <= j) {
                j = nums[k];
            } else {
                return true;
            }
        }
        return false;
    }
}


/*Runtime
2
ms
Beats
91.14%
*/

/*Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k
and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
Example 1:
Input: nums = [1,2,3,4,5]
Output: true
Explanation: Any triplet where i < j < k is valid.
Example 2:
Input: nums = [5,4,3,2,1]
Output: false
Explanation: No triplet exists.
Example 3:
Input: nums = [2,1,5,0,4,6]
Output: true
Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
Constraints:
1 <= nums.length <= 5 * 105
-231 <= nums[i] <= 231 - 1
Follow up: Could you implement a solution that runs in O(n) time complexity and O(1) space complexity?*/