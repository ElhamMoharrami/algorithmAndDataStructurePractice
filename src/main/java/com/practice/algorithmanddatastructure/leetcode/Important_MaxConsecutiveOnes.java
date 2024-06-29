package com.practice.algorithmanddatastructure.leetcode;

public class Important_MaxConsecutiveOnes {
    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));//6
        System.out.println(longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));//10
        System.out.println(longestOnes(new int[]{0, 0, 0, 1}, 4));//10
    }

    public static int longestOnes(int[] nums, int k) {
        int start = 0;
        int end = 0;
        while (end < nums.length) {
            if (nums[end] == 0) {
                k--;
            }
            if (k < 0) {
                if (nums[start] == 0) {
                    k++;
                }
                start++;
            }
            end++;
        }
        return end - start;
    }
}

/*Runtime
2
ms
Beats
100.00%
*/

/*Memory
46.45
MB
Beats
90.71%
*/

/*Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
Example 1:
Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:
Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Constraints:
1 <= nums.length <= 105
nums[i] is either 0 or 1.
0 <= k <= nums.length*/