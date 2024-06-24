package com.practice.algorithmanddatastructure.leetcode;

public class MaximumAverageSubArray {

    public static void main(String[] args) {
      //  System.out.println(findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));//12.75000
        System.out.println(findMaxAverage(new int[]{8860,-853,6534,4477,-4589,8646,-6155,-5577,-1656,-5779,-2619,
                -8604,-1358,-8009,4983,7063,3104,-1560,4080,2763,5616,-2375,2848,1394,-7173,-5225,-8244,-809,8025,
                -4072,-4391,-9579,1407,6700,2421,-6685,5481,-1732,-8892,-6645,3077,3287,-4149,8701,-4393,-9070,-1777,
                2237,-3253,-506,-4931,-7366,-8132,5406,-6300,-275,-1908,67,3569,1433,-7262,-437,8303,4498,-379,3054,
                -6285,4203,6908,4433,3077,2288,9733,-8067,3007,9725,9669,1362,-2561,-4225,5442,-9006,-429,160,-9234,
                -4444,3586,-5711,-9506,-79,-4418,-4348,-5891}, 93));//-594.58065
    }

    public static double findMaxAverage(int[] nums, int k) {
        if (nums.length == 1 && k == 1) {
            return nums[0];
        }
        int indexWatcher = 0;
        double maxAvg = -Double.MAX_VALUE;
        double sum = 0;
        double avg = 0;
        int iterationalIndex = 0;
        for (int number : nums) {
            if (indexWatcher <= k) {
                sum += number;
                indexWatcher++;
            }
            if (indexWatcher == k) {
                avg = sum / indexWatcher;
                if (avg > maxAvg) {
                    maxAvg = avg;
                }
                indexWatcher--;
                sum -= nums[iterationalIndex];
                iterationalIndex++;
            }
        }
        return maxAvg;
    }
}

/*Runtime
4
ms
Beats
66.16%*/
/*Memory
56.02
MB
Beats
38.38%*/


/* public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
       for(int i = 0; i < k; i ++)
           sum += nums[i];
       int maxSum = sum;
       for(int i = k; i < nums.length; i ++) {
       //Adds the current element (nums[i]) to the sum, and subtracts the first element of the previous subarray
      //(nums[i - k]) from the sum.
           sum += nums[i] - nums[i - k];
           maxSum = Math.max(maxSum, sum);
       }
       return (double)maxSum / k;
    }*/