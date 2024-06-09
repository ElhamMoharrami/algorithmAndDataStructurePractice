package com.practice.algorithmanddatastructure.leetcode;

public class CanPlaceFlowers {
    public static void main(String[] args) {
        int[] flowerbed = {0,0,1,0,0};
        int n = 2;
        System.out.println(canPlaceFlowers(flowerbed, n));

    }

    private static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        boolean result = true;
        for (int i = 0; i < flowerbed.length; i++) {
            if (i == 0 && flowerbed[i] == 0) {
                if (flowerbed.length == 1) {
                    flowerbed[i] = 1;
                    return true;
                }
                if (flowerbed[i + 1] != 1) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
            if (i == flowerbed.length - 1 && flowerbed[i] == 0) {
                if (flowerbed[i - 1] != 1) {
                    flowerbed[i] = 1;
                    count++;
                }
                break;
            }
            if (i == flowerbed.length - 1 && flowerbed[i] == 1) {
                break;
            }
            if (flowerbed[i] == 0 && flowerbed[i + 1] == 0 && flowerbed[i - 1] == 0) {
                flowerbed[i] = 1;
                count++;
            }
        }
        if (n > count) {
           return false;
        }
        return result;
    }
}

 /*  Runtime
1
ms
Beats
96.90%
of users with Java*/

/*Memory
45.65
MB
Beats
20.67%
of users with Java*/

/*You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n,
return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
Example 1:
Input: flowerbed = [1,0,0,0,1], n = 1
Output: true
Example 2:
Input: flowerbed = [1,0,0,0,1], n = 2
Output: false
Constraints:
1 <= flowerbed.length <= 2 * 104
flowerbed[i] is 0 or 1.
There are no two adjacent flowers in flowerbed.
0 <= n <= flowerbed.length*/