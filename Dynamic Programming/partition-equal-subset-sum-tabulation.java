// Source: LeetCode
// https://leetcode.com/problems/partition-equal-subset-sum/

class Solution {
    public boolean canPartition(int[] nums) {
        // calculate the total sum first
        int total = 0;
        for (int num : nums)
            total += num;

        // can't have two equal subsets if the total sum is odd (we'd need an even plus
        // an odd number)
        if (total % 2 != 0)
            return false;

        // we are going to have overlapping subproblems here (higher sums are
        // combinations of lower sums)
        // so we should think about dynamic programming

        // create our dynamic programming array
        // 2D array [i][j] where i = the index of the input array and j = the sum
        // remember since arrays are zero-indexed we need to add 1 so that the last
        // value is included in both i and j
        int n = nums.length;
        int target = total / 2;
        boolean[][] cache = new boolean[n + 1][target + 1];

        // initialize the dp array
        for (int i = 0; i <= n; i++)
            cache[i][0] = true; // every result where the sum == 0 is true (we've found the target)

        // below line is unneeded as in java boolean arrays are inintialized to false;
        // for(int j = 0; j <= target; j++) cache[n][j] = false; // every result
        // including an index out of bounds is false

        // moving from bottom to top, left to right
        // fill out the dp array
        for (int index = n - 1; index >= 0; index--) {
            for (int sum = 0; sum <= target; sum++) {

                // we cannot choose the element at this index because adding this index to the
                // sum will make it greater than our target
                if (sum < nums[index])
                    cache[index][sum] = cache[index + 1][sum];

                // we can either choose the element or not choose it to try to reach the target
                else
                    cache[index][sum] = cache[index + 1][sum - nums[index]] || cache[index + 1][sum];
            }
        }
        return cache[0][target];
    }
}