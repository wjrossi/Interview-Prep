// Source: LeetCode
// https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/

class Solution {
    public int findKthNumber(int m, int n, int k) {
        int low = 1, high = m * n;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // move mid left if it has at least k numbers less than it to its left
            // else move right
            if (isEnough(mid, m, n, k))
                high = mid;
            else
                low = mid + 1;
        }

        return low;
    }

    public boolean isEnough(int mid, int m, int n, int k) {
        int count = 0;

        // enough is true when there are z total elements <= mid
        // z * i <= mid
        // --> z = mid / i
        // but if mid is large, mid/i could be greater than n, which wouldn't make sense
        // since there are n numbers in each row, so we need the min of both
        for (int i = 1; i <= m; i++) {
            // for each row, add the numbers that are <= x (or the total numbers in the row)
            count += Math.min(mid / i, n);
        }

        // return true if mid has at least k numbers below it
        return count >= k;
    }
}
