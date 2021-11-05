
// Source: LeetCode
// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/

class Solution {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0)
            return false;

        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) // found a match
                return true;

            if (!isBinarySearchHelpful(nums, start, nums[mid])) {
                start++;
                continue;
            }

            boolean midInFirstSubarray = isInFirstSubarray(nums, start, nums[mid]);

            boolean targetInFirstSubarray = isInFirstSubarray(nums, start, target);

            if (midInFirstSubarray != targetInFirstSubarray) { // mid and target are in different subarrays
                if (midInFirstSubarray)
                    start = mid + 1; // target is in second subarray between mid and end
                else
                    end = mid - 1; // target is in first subarray between mid and start;
            } else { // mid and target are in the same subarray
                if (nums[mid] > target)
                    end = mid - 1; // target is between mid and start
                else
                    start = mid + 1; // target is between mid and end
            }
        }

        // did not find a match
        return false;
    }

    public boolean isInFirstSubarray(int[] nums, int start, int element) {
        return nums[start] <= element;
    }

    private boolean isBinarySearchHelpful(int[] arr, int start, int element) {
        return arr[start] != element;
    }
}