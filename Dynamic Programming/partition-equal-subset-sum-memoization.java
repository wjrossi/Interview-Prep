// Source: LeetCode
// https://leetcode.com/problems/partition-equal-subset-sum/

class Solution {
    public boolean canPartition(int[] nums) {
        // base case -- can't have two subsets with 1 or less elements
        if (nums.length <= 1)
            return false;

        // calculate the total sum first
        int total = 0;
        for (int i : nums)
            total += i;

        // can't have two equal subsets if the total sum is odd (we'd need an even plus
        // an odd number)
        if (total % 2 != 0)
            return false;

        // recurse
        int target = total / 2;
        Boolean[][] cache = new Boolean[nums.length][target + 1];
        return canPartitionRecursive(total / 2, nums, 0, cache);
    }

    public Boolean canPartitionRecursive(int target, int[] nums, int currentIndex, Boolean[][] cache) {
        if (target == 0)
            return true; // we found our match

        if (currentIndex >= nums.length || target < 0)
            return false; // we can't find out match with this subset

        // return the existing value if we already have it
        if (cache[currentIndex][target] != null)
            return cache[currentIndex][target];

        // either choose the element or don't and determine our result for each path
        Boolean res = canPartitionRecursive(target - nums[currentIndex], nums, currentIndex + 1, cache)
                || canPartitionRecursive(target, nums, currentIndex + 1, cache);

        // cache the result before returning
        cache[currentIndex][target] = res;

        return res;
    }
}