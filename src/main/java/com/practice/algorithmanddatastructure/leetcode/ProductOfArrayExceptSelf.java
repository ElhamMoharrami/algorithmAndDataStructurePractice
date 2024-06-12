package com.practice.algorithmanddatastructure.leetcode;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{2, 3, 4, 5, 6})));
       /* System.out.println(Arrays.toString(productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{0, 0})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{0, 4, 0})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{2, 3, 0, 0})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 0})));*/

    }

    public static int[] productExceptSelf(int[] nums) {
        int[] left= new int[nums.length];
        int[] right=new int[nums.length];
        left[0]=1;
        for(int i=1; i< nums.length; i++)
        {
            left[i]=left[i-1]*nums[i-1];
        }
        right[nums.length-1]=1;
        for(int i=nums.length-2; i>=0;i--)
        {
            right[i]=right[i+1]*nums[i+1];
        }
        for(int i=0;i<nums.length;i++)
        {
            nums[i]=left[i]*right[i];
        }
        return nums;
    }


}
