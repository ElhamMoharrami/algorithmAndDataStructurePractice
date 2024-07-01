package com.practice.algorithmanddatastructure.leetcode;

public class FindTheHighestAltitude {
    public static void main(String[] args) {
        System.out.println(largestAltitude(new int[]{-5, 1, 5, 0, -7}));//1
        System.out.println(largestAltitude(new int[]{-4, -3, -2, -1, 4, 3, 2}));//0
    }

    public static int largestAltitude(int[] gain) {
        int maxSum = 0;
        int sum = 0;
        for (int i = 0; i < gain.length; i++) {
            sum += gain[i];
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }
}


/*There is a biker going on a road trip. The road trip consists of n + 1 points at different altitudes.
The biker starts his trip on point 0 with altitude equal 0.

You are given an integer array gain of length n where gain[i] is the net gain in altitude between points
 i and i + 1 for all (0 <= i < n). Return the highest altitude of a point.
Example 1:
Input: gain = [-5,1,5,0,-7]
Output: 1
Explanation: The altitudes are [0,-5,-4,1,1,-6]. The highest is 1.
Example 2:
Input: gain = [-4,-3,-2,-1,4,3,2]
Output: 0
Explanation: The altitudes are [0,-4,-7,-9,-10,-6,-3,-1]. The highest is 0.
Constraints:
n == gain.length
1 <= n <= 100
-100 <= gain[i] <= 100
*/
/*Runtime:0ms
Beats:100.00%
*/
/*41.76MB
Beats 5.70%*/
/*
 first approach :
 public static int largestAltitude(int[] gain) {
        int[] altitudes = new int[gain.length + 1];
        altitudes[0] = 0;
        int sum = 0;
        int gainIndex = 0;
        for (int i = 1; i < altitudes.length; i++) {
            sum += gain[gainIndex];
            altitudes[i] = sum;
            gainIndex++;
        }
        int max = 0;
        for (int altitude : altitudes) {
            if (altitude > max) {
                max = altitude;
            }
        }
        return max;
    }

Runtime
118ms
Beats 5.22%
Memory:41.10MB
Beats 44%
*/