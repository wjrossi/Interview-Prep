// Source: Leetcode

/**
 * // This is ArrayReader's API interface. // You should not implement it, or
 * speculate about its implementation interface ArrayReader { public int get(int
 * index) {} }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int start = 0, end = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (reader.get(mid) == Integer.MAX_VALUE) {
                // mid is outside bounds of array, shrink problem space
                end = mid - 1;
            } else {
                // mid is inside bounds of array
                if (reader.get(mid) == target) {
                    // found the target
                    return mid;
                } else if (reader.get(mid) > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        // didn't find the target
        return -1;
    }
}