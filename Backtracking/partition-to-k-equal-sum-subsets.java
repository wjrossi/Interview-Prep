// Source: LeetCode
// https://leetcode.com/problems/partition-to-k-equal-sum-subsets/

class Solution {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        // get the total sum
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // if the total isn't divisible evenly by k return false
        if (sum % k != 0)
            return false;

        // create a visited array to track if we've already used the index
        boolean visited[] = new boolean[nums.length];

        // start backtracking
        return backtrack(nums, k, 0, sum / k, visited, 0);
    }

    boolean backtrack(int[] nums, int k, int currSum, int target, boolean[] visited, int index) {
        // we have completed k-1 equal sum subsets so we know we must have k equal sum
        // subsets
        // so we can return true here
        if (k == 1)
            return true;

        // our subset sum is too large
        if (currSum > target)
            return false;

        // our subset sum equals target so reset index and currentSum and re-solve
        if (currSum == target)
            return backtrack(nums, k - 1, 0, target, visited, 0);

        // classic backtracking below
        for (int i = index; i < nums.length; i++) {
            if (!visited[i]) {
                // set the current index to visited
                visited[i] = true;

                // solve if we choose the current index
                if (backtrack(nums, k, currSum + nums[i], target, visited, i + 1))
                    return true;

                // set the current index back to unvisited
                visited[i] = false;
            }
        }

        // we weren't able to find a match here
        return false;
    }
}