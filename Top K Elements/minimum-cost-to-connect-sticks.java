// Source: LeetCode
// https://leetcode.com/problems/minimum-cost-to-connect-sticks/

class Solution {
    public int connectSticks(int[] sticks) {
        if (sticks.length <= 1)
            return 0;

        // we'll use a default pq as java's implementation of a min heap
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        // add all the sticks to the min heap
        for (int num : sticks) {
            pq.add(num);
        }

        int totalCost = 0;

        while (pq.size() > 1) {
            // poll twice for the two lowest sticks and store their cost
            int currentCost = pq.poll() + pq.poll();
            // add the current cost to the total cost
            totalCost += currentCost;
            // push the current cost back onto the heap to be considered for next iteration
            pq.add(currentCost);
        }

        // return the final cost
        return totalCost;
    }
}