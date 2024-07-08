package com.practice.algorithmanddatastructure.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EqualRowAndColumnPAirs {
    public static void main(String[] args) {
      //  System.out.println(equalPairs(new int[][]{{3, 2, 1}, {1, 7, 6}, {2, 7, 7}}));//1
      //  System.out.println(equalPairs(new int[][]{{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}}));//3
        System.out.println(equalPairs(new int[][]{{3,1,2,2}, {1,4,4,4}, {2,4,2,2}, {2,5,2,2}}));//3
    }

    public static int equalPairs(int[][] grid) {
        Map<String, Integer> cnt = new HashMap<>();
        for (int[] row : grid) {
            cnt.merge(Arrays.toString(row), 1, Integer::sum);
        }
        int pairs = 0;
        for (int c = 0, n = grid.length; c < n; ++c) {
            int[] col = new int[n];
        // This loop iterates through all the rows of the grid for the current column.
            for (int r = 0; r < n; ++r) {
                col[r] = grid[r][c];
            }
            pairs += cnt.getOrDefault(Arrays.toString(col), 0);
        }
        return pairs;
    }

}

/*Runtime
34
ms
Beats
55.20%
*/

/*Memory
48.58
MB
Beats
79.18%

2352. Equal Row and Column Pairs
Solved
Medium
Topics
Companies
Hint
Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.

A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).



Example 1:


Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
Output: 1
Explanation: There is 1 equal row and column pair:
- (Row 2, Column 1): [2,7,7]
Example 2:


Input: grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
Output: 3
Explanation: There are 3 equal row and column pairs:
- (Row 0, Column 0): [3,1,2,2]
- (Row 2, Column 2): [2,4,2,2]
- (Row 3, Column 2): [2,4,2,2]


Constraints:

n == grid.length == grid[i].length
1 <= n <= 200
1 <= grid[i][j] <= 105

*/