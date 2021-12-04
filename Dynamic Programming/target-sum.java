// Source: LeetCode
// https://leetcode.com/problems/target-sum/

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // this is a great problem to check your edge cases: target is > total, target =
        // -total, etc
        int len = nums.length;

        // find the total
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        // stop early if we can
        if (target > total || target < total * -1)
            return 0;

        // create the dp array
        int[][] dp = new int[len + 1][total * 2 + 1];

        // in dp array, the sum 0 is actually represented by the value total
        // we can always form the sum 0 from the empty set
        dp[0][total] = 1;

        for (int index = 1; index <= len; index++) {
            int currVal = nums[index - 1];
            for (int sum = 0; sum <= total * 2; sum++) {
                // if statements are for boundary checking
                // the current cell is equal to the sum of the previous cell minus the current
                // value and the previous cell plus the current value
                if (sum - currVal >= 0)
                    dp[index][sum] += dp[index - 1][sum - currVal];
                if (currVal <= total * 2 - sum)
                    dp[index][sum] += dp[index - 1][sum + currVal];
            }
        }

        // return the cell representing selection of all elements for a sum equal to the
        // target
        return dp[len][total + target];
    }
}