// Source: Educative
// https://www.educative.io/courses/grokking-the-coding-interview/mE53y85Wqw9

class PartitionSet {

    public int canPartition(int[] num) {
        // get the total sum first
        int total = 0;
        for (int number : num) {
            total += number;
        }

        // track the minimum difference
        int minDiff = total;

        // create our dp array with one cell for each subsetsum
        boolean[] dp = new boolean[total + 1];

        // we can always reach a sum of zero with the empty set
        dp[0] = true;

        for (int currVal : num) {
            for (int subsetSum = total; subsetSum >= currVal; subsetSum--) {
                // determine if we can form the current subsetSum
                dp[subsetSum] |= dp[subsetSum - currVal];

                // if we can, minimize the difference
                if (dp[subsetSum])
                    minDiff = Math.min(Math.abs(subsetSum - (total - subsetSum)), minDiff);
            }
        }

        // return the smallest difference
        return minDiff;
    }
}