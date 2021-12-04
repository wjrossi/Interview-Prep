// Source: Educative
// https://www.educative.io/courses/grokking-the-coding-interview/gxrnL0GQGqk

class SubsetSum {

    static boolean canPartition(int[] num, int sum) {
        int len = num.length;

        // we only need a 1d array 
        boolean[] dp = new boolean[sum + 1];

        // we can always form sum 0 with an empty set
        dp[0] = true;

        for (int index = 0; index < len; index++) {
            int currVal = num[index];
            // we have to operate from right to left so we don't overwrite previous values
            // and we must stop when we reach the value of the current index, as we won't form a sum lower than that with that number to consider
            for (int subsetSum = sum; subsetSum >= currVal; subsetSum--) {
                // either choose the element OR don't choose it to reach the sum
                dp[subsetSum] |= dp[subsetSum - currVal];
            }
        }
        return dp[sum];
    }
}