// Source: Leetcode
// https://leetcode.com/problems/peak-index-in-a-mountain-array/

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0, end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[mid + 1]) {
                // array is decreasing after mid, need to move left
                // end = mid instead of mid - 1 because mid could be the peak
                end = mid;
            } else {
                // array is increasing after mid, need to move right
                // start becomes mid + 1 because we know mid cannot be peak
                start = mid + 1;
            }
        }

        // start == end == peak
        return start;
    }
}