package com.practice.algorithmanddatastructure.leetcode;

import java.util.*;

public class KidsWithTheGreatestNumberOfCandies {
    public static void main(String[] args) {
        int[] candies = {2, 3, 5, 1, 3};
        int extraCandies = 3;
        List<Boolean> result = new ArrayList<>(candies.length);
        PriorityQueue<Integer> theQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int candy : candies) {
            theQueue.add(candy);
        }
        int max = theQueue.peek();
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= max) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        System.out.println(result);

    }
}


/*Runtime
2
ms
Beats
17.06%
of users with Java
Memory
42.20
MB
Beats
47.03%
of users with Java
*/

/*better result:
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = -1;
        for (int i = 0; i < candies.length; i++) {
            max = Math.max(candies[i], max);
        }
        List<Boolean> b = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
		   b.add(candies[i] + extraCandies >= max);
        }
        return b;
    }
}
 */
/*There are n kids with candies. You are given an integer array candies, where each candies[i] represents the number
 of candies the ith kid has, and an integer extraCandies, denoting the number of extra candies that you have.
Return a boolean array result of length n, where result[i] is true if, after giving the ith kid all the extraCandies,
they will have the greatest number of candies among all the kids, or false otherwise.
Note that multiple kids can have the greatest number of candies.

Example 1:
Input: candies = [2,3,5,1,3], extraCandies = 3
Output: [true,true,true,false,true]
Explanation: If you give all extraCandies to:
- Kid 1, they will have 2 + 3 = 5 candies, which is the greatest among the kids.
- Kid 2, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
- Kid 3, they will have 5 + 3 = 8 candies, which is the greatest among the kids.
- Kid 4, they will have 1 + 3 = 4 candies, which is not the greatest among the kids.
- Kid 5, they will have 3 + 3 = 6 candies, which is the greatest among the kids.*/