package com.practice.algorithmanddatastructure.leetcode;

public class LongestSubarrayOf1sAfterDeletingOneElement {
    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1}));
        System.out.println(longestSubarray(new int[]{1, 1, 0, 1}));
        System.out.println(longestSubarray(new int[]{1, 1, 1}));
    }

    public static int longestSubarray(int[] nums) {
        int start = 0;
        int end = 0;
        int k = 1;
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
        return end - start - 1;
    }
}

/*Runtime
2
ms
Beats
96.06%
*/

/*Memory
56.72
MB
Beats
51.86%
*/

/*Given a binary array nums, you should delete one element from it.
Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.
Example 1:
Input: nums = [1,1,0,1]
Output: 3
Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
Example 2:
Input: nums = [0,1,1,1,0,1,1,0,1]
Output: 5
Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
Example 3:
Input: nums = [1,1,1]
Output: 2
Explanation: You must delete one element.
Constraints:
1 <= nums.length <= 105
nums[i] is either 0 or 1.*/