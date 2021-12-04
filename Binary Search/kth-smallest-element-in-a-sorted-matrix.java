// Source: LeetCode
// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

class Solution {

    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;
        int start = matrix[0][0], end = matrix[n - 1][n - 1];

        while (start < end) {
            // calculate mid
            int mid = start + (end - start) / 2;

            // create the smallest and largest possible values
            // these track smallest value <= mid and largest value > mid
            int[] smallestLargestPair = { matrix[0][0], matrix[n - 1][n - 1] };

            int count = countLessEqual(matrix, mid, smallestLargestPair);

            // found our answer
            if (count == k)
                return smallestLargestPair[0];

            if (count < k) {
                // k higher than count, search high
                // smallestLargestPair[1] is the smallest value greater than mid
                start = smallestLargestPair[1];
            } else {
                // k is lower than count, search low
                // smallestLargestPair[0] is the greatest value less than or equal to mid
                end = smallestLargestPair[0];
            }
        }
        return start;
    }

    private int countLessEqual(int[][] matrix, int mid, int[] smallLargePair) {
        int count = 0;
        int n = matrix.length, row = n - 1, col = 0;

        while (row >= 0 && col < n) {
            int candidate = matrix[row][col];

            if (candidate <= mid) {
                smallLargePair[0] = Math.max(smallLargePair[0], candidate);
                col++;

                // counting numbers <= mid
                count += row + 1;
            } else {
                smallLargePair[1] = Math.min(smallLargePair[1], candidate);
                row--;
            }
        }

        return count;
    }
}