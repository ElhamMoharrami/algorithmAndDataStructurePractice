package com.practice.algorithmanddatastructure.leetcode;

import java.util.Arrays;

public class MaxNumberOfKSumPairs {
    public static void main(String[] args) {
      /*  System.out.println(maxOperations(new int[]{1, 2, 3, 4}, 5));//2
        System.out.println(maxOperations(new int[]{3, 1, 3, 4, 3}, 6));//1*/
        System.out.println(maxOperations(new int[]{4, 4, 1, 3, 1, 3, 2, 2, 5, 5, 1, 5, 2, 1, 2, 3, 5, 4}, 2));//2
    }

    public static int maxOperations(int[] nums, int k) {
        //sort
        Arrays.sort(nums);
        //two pointer
        int left = 0;
        int right = nums.length - 1;
        int count = 0;
        while (left < right) {
            if (nums[left] + nums[right] == k) {
                count++;
                right--;
                left++;
            }
            //the arr is sorted so if the sum is less than k by increasing left you are going to check larger numbers
            if (nums[left] + nums[right] < k) {
                left++;
            }   //the arr is sorted so if the sum is > than k you try to go to check with lesser numbers
            else if (nums[left] + nums[right] > k) {
                right--;
            }

        }
        return count;
    }
}
/*Runtime
20
ms
Beats
46.71%*/

/*Memory
57.56
MB
Beats
25.40%*/

/*You are given an integer array nums and an integer k.
In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
Return the maximum number of operations you can perform on the array.
Example 1:
Input: nums = [1,2,3,4], k = 5
Output: 2
Explanation: Starting with nums = [1,2,3,4]:
- Remove numbers 1 and 4, then nums = [2,3]
- Remove numbers 2 and 3, then nums = []
There are no more pairs that sum up to 5, hence a total of 2 operations.
Example 2:
Input: nums = [3,1,3,4,3], k = 6
Output: 1
Explanation: Starting with nums = [3,1,3,4,3]:
- Remove the first two 3's, then nums = [1,4,3]
There are no more pairs that sum up to 6, hence a total of 1 operation.
Constraints:
1 <= nums.length <= 105
1 <= nums[i] <= 109
1 <= k <= 109*/

//better solution
/*  public int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer> hm= new HashMap<>();
		//Initialized The Counter
        int count=0;
        for(int i=0; i<nums.length; i++){
		// Checking if the HashMap Contains the k-nums[i] (desired Integer)
            if(hm.containsKey(k-nums[i]) && hm.get(k-nums[i])>0){
                count +=1;
                hm.put((k-nums[i]),(hm.get(k-nums[i])-1));
            }
			// Otherwise we add the Integer to the HashMap
            else{
                hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
            }
        }
		// Return the Count
        return count;
	}*/