// Source: LeetCode
// https://leetcode.com/problems/search-in-rotated-sorted-array/

class Solution {
    // single pass binary search
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) // found the target
                return mid;
            else if (nums[mid] >= nums[start]) {
                // left subarray is in ascending order so we can check it for the target
                if (target < nums[mid] && target >= nums[start])
                    end = mid - 1; // target is in left subarray, move left
                else
                    start = mid + 1; // target is not in left subarray, move right
            } else {
                // right subarray is in ascending order so we can check it for the target
                if (target > nums[mid] && target <= nums[end])
                    start = mid + 1; // target is in right subarray, move right
                else
                    end = mid - 1; // target is not in right subarray, move left
            }
        }

        // we never found the target
        return -1;
    }
}