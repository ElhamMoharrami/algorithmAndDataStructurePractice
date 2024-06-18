package com.practice.algorithmanddatastructure.leetcode;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(moveZeroes(new int[]{0, 1, 0, 3, 12})));
    }

    public static int[] moveZeroes(int[] nums) {
        int nonZeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nonZeroCount++;
            }
        }
        int[] indices = new int[nonZeroCount];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                indices[j] = nums[i];
                j++;
            }
        }
        int k = 0;
        for (int i = 0; i < indices.length; i++) {
                nums[i] = indices[k];
                k++;
        }
        for (int i = indices.length; i < nums.length; i++) {
            nums[i] = 0;
        }
        return nums;
    }
}
/*Runtime
2
ms
Beats
83.39%
*/

/*Memory
45.77
MB
Beats
76.52%
*/

/*class Solution {
    public void moveZeroes(int[] nums) {
        //ap: Anchor pointer
        int ap = 0;
        //ep: Explore pointer
        int ep = 0;
        //n: length of the arr
        int n = nums.length;
        while(ep < n){
            if(nums[ap] != 0){
                //We move both pointers because we need to  prevent an example like this [1,0,1] where we could have ep < ap
                ap++;
                ep = ap;
            }else if(nums[ep] == 0){
                ep++;
            }else{
                //Current conditions: nums[ap] = 0 and nums[ep] != 0 so we swap
                int temp = nums[ap];
                nums[ap] = nums[ep];
                nums[ep] = temp;
            }
        }
    }*/