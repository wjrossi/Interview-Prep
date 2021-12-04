
// Source: Educative
// https://www.educative.io/courses/grokking-the-coding-interview/gxrnL0GQGqk

class SubsetSum {

    public boolean canPartition(int[] num, int sum) {
        int len = num.length;

        // create our dp array
        // len + 1 rows, each row representing the inclusion of the corresponding index
        // of num in the subset sum
        // sum + 1 columns, each representing a sum
        boolean[][] dp = new boolean[len + 1][sum + 1];

        // initialize dp array -- we know we can form sum 0 from the empty set
        dp[0][0] = true;

        // index represents the index of num array if it was one-indexed
        // for each index, we get the corresponding value in nums
        // and attempt to reach the current sum if we include it or exclude it from the
        // subset
        // so the 0th index represents the empty set
        for (int index = 1; index <= len; index++) {
            int valOfIndex = num[index - 1];
            for (int currSum = 0; currSum <= sum; currSum++) {
                // if the value of the current index is greater than the current sum, we know we can't include it
                // and we will get an index out of bounds exception if we do
                if (currSum < valOfIndex) {
                    dp[index][currSum] = dp[index - 1][currSum];
                } else {
                    // the current cell is equal to the value of the cell if we include the current value, or if we don't include the current value
                    dp[index][currSum] = dp[index - 1][currSum] || dp[index - 1][currSum - valOfIndex];
                }

                // optimization to save us some operations if we can form the sum with < all the
                // elements
                if (currSum == sum && dp[index][currSum] == true)
                    return true;
            }
        }

        // return the tip of the array, which tells us that we can reach the sum
        return dp[len][sum];
    }
}