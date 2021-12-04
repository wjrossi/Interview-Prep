// Source: LeetCode
// https://leetcode.com/problems/search-a-2d-matrix/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int numCols = matrix[0].length;
        int start = 0, end = matrix.length * numCols - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // get the value of the mid index in the array
            // row = midIndex / numCols, col = midIndex % numCols
            int midValue = matrix[mid / numCols][mid % numCols];

            // found a match
            if (target == midValue)
                return true;

            if (target < midValue) {
                // target is lower, move lower
                end = mid - 1;
            } else {
                // target is higher, move higher
                start = mid + 1;
            }
        }

        // we didn't find a match;
        return false;
    }
}