// Source: Leetcode
// https://leetcode.com/problems/find-in-mountain-array/

/**
 * // This is MountainArray's API interface. // You should not implement it, or
 * speculate about its implementation interface MountainArray { public int
 * get(int index) {} public int length() {} }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peakIndex = findPeak(mountainArr);

        if (target > mountainArr.get(peakIndex))
            return -1; // target is higher than the peak

        if (target == mountainArr.get(peakIndex))
            return peakIndex; // target == peak, return to save time

        // search left half of peak first for minimum index
        int leftOfPeakResult = binarySearch(mountainArr, 0, peakIndex, target);

        // return the result of the search on the left side of peak if found, otherwise
        // result of search on right side
        return leftOfPeakResult != -1 ? leftOfPeakResult
                : binarySearch(mountainArr, peakIndex, mountainArr.length() - 1, target);

    }

    // binary search function to find the peak of the bitonic array
    private int findPeak(MountainArray arr) {
        int start = 0, end = arr.length() - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr.get(mid) > arr.get(mid + 1)) {
                // array is decreasing, peak is either this value or to the left
                end = mid;
            } else {
                // array is increasing, peak is to the right
                start = mid + 1;
            }
        }

        // start == end == peak
        return start;
    }

    // order-agnostic binary search
    private int binarySearch(MountainArray arr, int start, int end, int target) {
        boolean isAscending = arr.get(start) < arr.get(end);

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr.get(mid) == target) {
                return mid; // found our target
            } else if (arr.get(mid) > target) {
                if (isAscending)
                    end = mid - 1;
                else
                    start = mid + 1;
            } else {
                if (isAscending)
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }

        // didn't find the target
        return -1;
    }
}